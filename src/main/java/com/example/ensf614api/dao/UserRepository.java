package com.example.ensf614api.dao;

import com.example.ensf614api.models.AssignedUser;
import com.example.ensf614api.models.AvailableCrew;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.example.ensf614api.models.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static javax.swing.DropMode.INSERT;

@Service
public interface UserRepository extends CrudRepository<User, Integer>{

    @Query("select u from User u where u.userID=:userId")
    public User getUser(@Param("userId") String userId);

    @Query("select u from User u where u.email=:email and u.password=:password")
    public User signIn(@Param("email") String email, @Param("password") String password);

    @Query("select u from User u where u.email=:email")
    public User doesUserExist(@Param("email") String email);

    @Query("SELECT new com.example.ensf614api.models.AssignedUser(u, cr.position, ca.flightID, ca.crewAssignmentID) \n" +
            "FROM User u \n" +
            "JOIN Crew cr ON u.userID = cr.userID\n" +
            "JOIN CrewAssignment ca ON cr.crewID = ca.crewID\n" +
            "WHERE ca.flightID =:flightId\n" +
            "AND  cr.position = 'pilot'")
    public List<AssignedUser> getPilots(@Param("flightId") Integer flightId);

    @Query("SELECT new com.example.ensf614api.models.AssignedUser(u, cr.position, ca.flightID, ca.crewAssignmentID) " +
            "FROM User u " +
            "JOIN Crew cr ON u.userID = cr.userID " +
            "JOIN CrewAssignment ca ON cr.crewID = ca.crewID " +
            "WHERE ca.flightID = :flightId " +
            "AND cr.position = 'flight attendant'")
    public List<AssignedUser> getFas(@Param("flightId") Integer flightId);

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


    public void AddCrew(@Param("flightId") Integer flightId, @Param("crewId") Integer crewId);

}
