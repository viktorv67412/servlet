package com.model;

public class User {

    private String name;
    private String password;
    private String age;
    private String phoneNumber;
    private String homeAddress;
    private String email;

    public User(String name, String password, String age, String phoneNumber, String homeAddress, String email) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
        this.email = email;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
