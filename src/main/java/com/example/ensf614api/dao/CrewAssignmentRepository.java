package com.example.ensf614api.dao;

import com.example.ensf614api.models.AvailableCrew;
import com.example.ensf614api.models.CrewAssignment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CrewAssignmentRepository extends CrudRepository<CrewAssignment, Integer> {


    @Query("SELECT new com.example.ensf614api.models.AvailableCrew(u, cr.position, cr.crewID) " +
            "FROM User u " +
            "JOIN Crew cr ON u.userID = cr.userID " +
            "WHERE cr.position = 'flight attendant'")
    public List<AvailableCrew> getAvailableFas();

    @Query("SELECT new com.example.ensf614api.models.AvailableCrew(u, cr.position, cr.crewID) " +
            "FROM User u " +
            "JOIN Crew cr ON u.userID = cr.userID " +
            "WHERE cr.position = 'pilot'")
    public List<AvailableCrew> getAvailablePilot();


}
