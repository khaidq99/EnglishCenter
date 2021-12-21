/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.*;
import java.io.Serializable;

/**
 *
 * @author KHAI-PC
 */
public class Lesson implements Serializable {
    private int id;
    private String name, des;
    private Room room;
    private Date date;
    private Skill skill;
    private Shift shift;
    private EnglishClass englishClass;

    public Lesson() {
    }

    public Lesson(int id, String name, String des, Room room, Date date, 
            Skill skill, Shift shift, EnglishClass englishClass) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.room = room;
        this.date = date;
        this.skill = skill;
        this.shift = shift;
        this.englishClass = englishClass;
    }

    public Lesson(String name, String des, Room room, Date date, Skill skill, 
            Shift shift, EnglishClass englishClass) {
        this.name = name;
        this.des = des;
        this.room = room;
        this.date = date;
        this.skill = skill;
        this.shift = shift;
        this.englishClass = englishClass;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public EnglishClass getEnglishClass() {
        return englishClass;
    }

    public void setEnglishClass(EnglishClass englishClass) {
        this.englishClass = englishClass;
    }
}
