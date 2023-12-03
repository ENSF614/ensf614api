package com.example.ensf614api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "aircraft")
public class Aircraft {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "aircraftid")
	private Integer aircraftID;
	@Column(name = "rownums")
	private Integer rowNums;
	@Column(name = "colnums")
	private Integer colNums;
	@Column(name = "capacity")
	private Integer capacity;
	@Column(name = "name")
	private String name;
	@Column(name = "type")
	private String type;
	@Column(name = "pilotNum")
	private Integer pilotNum;
    @Column(name = "crewNum")
    private Integer crewNum;
    @Column(name = "cycles")
    private Integer cycles;
    @Column(name = "hours")
    private Double hours;
	@Column(name = "numbusinessrows")
	private Integer numBusinessRows;
	
	// Getter and setter methods for aircraftID
    public Integer getAircraftID() {
        return aircraftID;
    }

    public void setAircraftID(Integer aircraftID) {
        this.aircraftID = aircraftID;
    }

    // Getter and setter methods for rowNums
    public Integer getRowNums() {
        return rowNums;
    }

    public void setRowNums(Integer rowNums) {
        this.rowNums = rowNums;
    }

    // Getter and setter methods for colNums
    public Integer getColNums() {
        return colNums;
    }

    public void setColNums(Integer colNums) {
        this.colNums = colNums;
    }

    // Getter and setter methods for capacity
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    // Getter and setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter methods for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter methods for crewNum
    public Integer getCrewNum() {
        return crewNum;
    }

    public void setCrewNum(Integer crewNum) {
        this.crewNum = crewNum;
    }

    public Integer getPilotNum(){return this.pilotNum;}
    public void setPilotNum(Integer pilotNum){this.pilotNum = pilotNum;}

    // Getter and setter methods for numBusinessSeats
    public Integer getNumBusinessRows() {
        return numBusinessRows;
    }

    public void setNumBusinessRows(Integer numBusinessRows) {
        this.numBusinessRows = numBusinessRows;
    }

    public Integer getCycles(){return this.cycles;}
    public void setCycles(Integer cycles){this.cycles = cycles;}

    public Double getHours(){return this.hours;}
    public void setHours(Double hours){this.hours = hours;}
}
