package com.example.parkinglot.ejb;

import com.example.parkinglot.common.UserDto;
import com.example.parkinglot.entity.User;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Stateless
public class UsersBean {
    private static final Logger LOG = Logger.getLogger(UsersBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers()
    {
        LOG.info("findAllUsers");
        try
        {
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }catch (Exception e)
        {
            throw new EJBException(e);
        }
    }

    public List<UserDto> copyUsersToDto(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(
                    user.getId(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getUsername()
            );
            userDtos.add(userDto);
        }
        return userDtos;
    }

}
