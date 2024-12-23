package com.example.parkinglot.servlets.cars;

import com.example.parkinglot.common.CarDto;
import com.example.parkinglot.ejb.CarsBean;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@DeclareRoles({"READ_CARS", "WRITE_CARS"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"READ_CARS"}),
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = {"WRITE_CARS"})})
@WebServlet(name = "Cars", value = "/Cars")
public class Cars extends HttpServlet {
    @Inject
    CarsBean carsBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CarDto> cars = carsBean.findAllCars();
        request.setAttribute("cars", cars);
        request.setAttribute("numberOfFreeParkingSpots", 10-cars.size());
        request.getRequestDispatcher("/WEB-INF/pages/cars/cars.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] carIdsAsString = request.getParameterValues("car_ids");
        if (carIdsAsString != null) {
            List<Long> carsIds = new ArrayList<>();
            for(String carIdAsString : carIdsAsString) {
                carsIds.add(Long.parseLong(carIdAsString));
            }
            carsBean.deleteCarsByIds(carsIds);
        }
        response.sendRedirect(request.getContextPath() + "/Cars");
    }
}