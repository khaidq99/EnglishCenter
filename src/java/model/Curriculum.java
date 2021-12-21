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
public class Curriculum implements Serializable {
    private int id;
    private String name, des;

    public Curriculum() {
    }

    public Curriculum(int id, String name, String des) {
        this.id = id;
        this.name = name;
        this.des = des;
    }

    public Curriculum(String name, String des) {
        this.name = name;
        this.des = des;
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
