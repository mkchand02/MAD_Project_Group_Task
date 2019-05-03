package com.example.registration.fragment;

public class Users {

    private String username;
    private long id;
    private String name;
    private String email;
    private String gender;
    private String imageUrl;
    private int credits;
    private String password;
    private long mobileNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    //SETTER FOR USERNAME
    public Users(long id, String username, String name, String email, String gender, String imageUrl, int credits) {

        this.id = id;
        this.username = username;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.imageUrl = imageUrl;
        this.credits = credits;
    }

    //GETTER FOR USERNAME
    public String getUsername() {
        return username;
    }

}
