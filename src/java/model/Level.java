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
public class Level implements Serializable {
    private int id;
    private String name, des;
    private int numberLesson;
    private Curriculum curri;

    public Level() {
    }

    public Level(int id, String name, String des, int numberLesson, Curriculum curri) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.numberLesson = numberLesson;
        this.curri = curri;
    }

    public Level(String name, String des, int numberLesson, Curriculum curri) {
        this.name = name;
        this.des = des;
        this.numberLesson = numberLesson;
        this.curri = curri;
    }

    public int getNumberLesson() {
        return numberLesson;
    }

    public void setNumberLesson(int numberLesson) {
        this.numberLesson = numberLesson;
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

    public Curriculum getCurri() {
        return curri;
    }

    public void setCurri(Curriculum curri) {
        this.curri = curri;
    }
}
