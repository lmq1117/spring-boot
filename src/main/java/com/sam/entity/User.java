package com.sam.entity;

public class User {
    private Integer id;
    private String userName;
    private String address;


    public User() {
    }

    public User(Integer id, String userName, String address) {
        this.id = id;
        this.userName = userName;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return decrypt(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String encrypt(String v){
        return v;
    }

    private String decrypt(String v){
        return v;
    }
}
