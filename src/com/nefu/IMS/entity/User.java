package com.nefu.IMS.entity;

public class User {
    private int id;
    private String name;
    private String password;
    private int boredBookNum;

    public User(int id, String name, String password, int boredBookNum) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.boredBookNum = boredBookNum;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBoredBookNum() {
        return boredBookNum;
    }

    public void setBoredBookNum(int boredBookNum) {
        this.boredBookNum = boredBookNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", boredBookNum=" + boredBookNum +
                '}';
    }
}
