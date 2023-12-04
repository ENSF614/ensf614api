package com.example.ensf614api.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "userid")
	private Integer userID;
	@Column(name = "fname")
	private String fName;
	@Column(name = "lname")
	private String lName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
	@Column(name = "address")
	private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "postal")
    private String postal;
    @Column(name = "country")
    private String country;
	@Column(name = "phonenumber")
	private String phoneNumber;
	@Column(name = "companionPass")
	private Boolean companionPass;
	@Column(name = "loungepass")
	private Boolean loungePass;
	@Column(name = "joinedOnDate")
	private Date joinedOnDate;
	@Column(name = "role")
	private String role;

    public User(User user) {
        this.userID = user.userID;
        this.fName = user.fName;
        this.lName = user.lName;
        this.email = user.email;
        this.password = user.password;
        this.address = user.address;
        this.city = user.city;
        this.province = user.province;
        this.postal = user.postal;
        this.country = user.country;
        this.phoneNumber = user.phoneNumber;
        this.companionPass = user.companionPass;
        this.loungePass = user.loungePass;
        this.joinedOnDate = user.joinedOnDate;
        this.role = user.role;
    }

    public User() {

    }

    // Getter and setter methods for userID
	public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    // Getter and setter methods for fName
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    // Getter and setter methods for lName
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    // Getter and setter methods for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){return email;}

    public void setPassword(String password){
        this.password = password;
    }

    // Getter and setter methods for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods for companion
    public boolean getCompanionPass() {
        return companionPass;
    }

    public void setCompanionPass(boolean companionPass) {
        this.companionPass = companionPass;
    }

    // Getter and setter methods for loungePass
    public boolean getLoungePass() {
        return loungePass;
    }

    public void setLoungePass(boolean loungePass) {
        this.loungePass = loungePass;
    }

    // Getter and setter methods for renewalDate
    public Date getJoinedOnDate() {
        return joinedOnDate;
    }

    public void setJoinedOnDate(Date joinedOnDate) {
        this.joinedOnDate = joinedOnDate;
    }

    // Getter and setter methods for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
