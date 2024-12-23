package com.example.parkinglot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Car

{
    @ManyToOne
    private User owner;

    @GeneratedValue
    @Id
    Long id;
    String licensePlate;
    String parkingSpot;

    private CarPhoto photo;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min = 3, max = 100)
    @Column(unique = true,nullable = false,length = 100)
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Size(min = 3, max = 100)
    @Column(unique = true,nullable = false,length = 100)
    public String getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(String parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public CarPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(CarPhoto photo) {
        this.photo = photo;
    }
}