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
public class EnglishClass implements Serializable {
    private int id;
    private String name;
    private int maxSize, actualSize;
    private boolean isOpen;
    private String des;
    private User user;
    private Level level;

    public EnglishClass() {
    }

    public EnglishClass(int id, String name, int maxSize, int actualSize, 
            boolean isOpen, String des, User user, Level level) {
        this.id = id;
        this.name = name;
        this.maxSize = maxSize;
        this.actualSize = actualSize;
        this.isOpen = isOpen;
        this.des = des;
        this.user = user;
        this.level = level;
    }

    public EnglishClass(String name, int maxSize, int actualSize, 
            boolean isOpen, String des, User user, Level level) {
        this.name = name;
        this.maxSize = maxSize;
        this.actualSize = actualSize;
        this.isOpen = isOpen;
        this.des = des;
        this.user = user;
        this.level = level;
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

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getActualSize() {
        return actualSize;
    }

    public void setActualSize(int actualSize) {
        this.actualSize = actualSize;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
