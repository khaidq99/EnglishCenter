/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KHAI-PC
 */
public class Branch implements Serializable {
    private int id;
    private String name;
    private Address address;
    private String des;
    private List<User> listUser;
    private List<Room> listRoom;

    public Branch() {
        listUser = new ArrayList<>();
        listRoom = new ArrayList<>();
    }

    public Branch(int id, String name, Address address, String des, 
            List<User> listUser, List<Room> listRoom) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.des = des;
        this.listUser = listUser;
        this.listRoom = listRoom;
    }
    
    public Branch(String name, Address address, String des, List<User> listUser,
            List<Room> listRoom) {
        this.name = name;
        this.address = address;
        this.des = des;
        this.listUser = listUser;
        this.listRoom = listRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<User> getListUser() {
        return listUser;
    }

    public void setListUser(List<User> listUser) {
        this.listUser = listUser;
    }

    public List<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(List<Room> listRoom) {
        this.listRoom = listRoom;
    }
}
