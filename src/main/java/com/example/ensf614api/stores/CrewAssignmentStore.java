package com.example.ensf614api.stores;

import com.example.ensf614api.dao.CrewAssignmentRepository;
import com.example.ensf614api.dao.UserRepository;
import com.example.ensf614api.models.AvailableCrew;
import com.example.ensf614api.models.CrewAssignment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrewAssignmentStore {

    private CrewAssignmentRepository crewAssignmentRepo;

    public CrewAssignmentStore(CrewAssignmentRepository crewAssignmentRespository){
        this.crewAssignmentRepo = crewAssignmentRespository;
    }

    public CrewAssignment createCrewAssignment(CrewAssignment crewAssignment){
        return crewAssignmentRepo.save(crewAssignment);
    }

    public List<AvailableCrew> GetAvailablePilots(){
        return this.crewAssignmentRepo.getAvailablePilot();
    }

    public List<AvailableCrew> GetAvailableFas(){
        return this.crewAssignmentRepo.getAvailableFas();
    }

    public void removeCrewAssignment(CrewAssignment crewAssignment){
        crewAssignmentRepo.delete(crewAssignment);
    }


}
