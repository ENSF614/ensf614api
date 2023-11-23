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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "userid")
	private Integer userID;
	@Column(name = "fname")
	private String fName;
	@Column(name = "lname")
	private String lName;
	@Column(name = "address")
	private String address;
	@Column(name = "phonenumber")
	private Integer phoneNumber;
	@Column(name = "companion")
	private Boolean companion;
	@Column(name = "loungepass")
	private Boolean loungePass;
	@Column(name = "renewaldate")
	private Date renewalDate;
	@Column(name = "role")
	private String role;
	
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

    // Getter and setter methods for phoneNumber
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and setter methods for companion
    public boolean isCompanion() {
        return companion;
    }

    public void setCompanion(boolean companion) {
        this.companion = companion;
    }

    // Getter and setter methods for loungePass
    public boolean isLoungePass() {
        return loungePass;
    }

    public void setLoungePass(boolean loungePass) {
        this.loungePass = loungePass;
    }

    // Getter and setter methods for renewalDate
    public Date getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(Date renewalDate) {
        this.renewalDate = renewalDate;
    }

    // Getter and setter methods for role
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
