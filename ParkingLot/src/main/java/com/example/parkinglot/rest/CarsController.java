package com.example.parkinglot.rest;


import com.example.parkinglot.common.CarDto;
import com.example.parkinglot.ejb.CarsBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/cars")
public class CarsController {
    @Inject
    CarsBean carsBean;
    @GET
    @Produces(MediaType.APPLICATION_JSON)

    public List<CarDto> findAllCars() {
        return carsBean.findAllCars();
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CarDto findCar(@PathParam("id") Long id) {
        return carsBean.findById(id);
    }
}
