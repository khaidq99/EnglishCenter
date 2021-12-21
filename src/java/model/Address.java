/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author KHAI-PC
 */
public class Address implements Serializable {
    private int id;
    private String number, street, district, city;

    public Address() {
    }

    public Address(int id, String number, String street, String district, String city) {
        this.id = id;
        this.number = number;
        this.street = street;
        this.district = district;
        this.city = city;
    }
    
    
    
    public Address(String number, String street, String district, String city) {
        this.number = number;
        this.street = street;
        this.district = district;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
