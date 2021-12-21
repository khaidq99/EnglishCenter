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
public class EnglishCenter implements Serializable {
    private int id;
    private String name, slogan, des;
    private List<Branch> listBranch;
    private List<Curriculum> listCurriculum;

    public EnglishCenter() {
        listBranch = new ArrayList<>();
        listCurriculum = new ArrayList<>();
    }

    public EnglishCenter(int id, String name, String slogan, String des, 
            List<Branch> listBranch, List<Curriculum> listCurriculum) {
        this.id = id;
        this.name = name;
        this.slogan = slogan;
        this.des = des;
        this.listBranch = listBranch;
        this.listCurriculum = listCurriculum;
    }

    public EnglishCenter(String name, String slogan, String des, 
            List<Branch> listBranch, List<Curriculum> listCurriculum) {
        this.name = name;
        this.slogan = slogan;
        this.des = des;
        this.listBranch = listBranch;
        this.listCurriculum = listCurriculum;
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

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<Branch> getListBranch() {
        return listBranch;
    }

    public void setListBranch(List<Branch> listBranch) {
        this.listBranch = listBranch;
    }

    public List<Curriculum> getListCurriculum() {
        return listCurriculum;
    }

    public void setListCurriculum(List<Curriculum> listCurriculum) {
        this.listCurriculum = listCurriculum;
    }
}
