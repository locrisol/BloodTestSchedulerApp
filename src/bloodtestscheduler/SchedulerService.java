/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

import java.util.*;

public class SchedulerService {
    private final PriorityQueue<Patient> patientQueue;
    private final LinkedList<Patient> noShowList;
    private static final int MAX_NO_SHOWS = 5;
    
    public SchedulerService() {
        // Defines a Patients Priority Queue and uses comparePatients method as comparisor
        this.patientQueue = new PriorityQueue<>(this::comparePatients);
        this.noShowList = new LinkedList<>();
    }
    
    /** This method returns a negative number if p1 priority is higher than p2,
     * a positive number if p2 priority is higher than p1 priority,
     * and a 0 if they are the same
     * 
     * @param p1
     * @param p2
     * @return priorityCompare
     */
    private int comparePatients(Patient p1, Patient p2) {
        // First compares by patients priority
        int priorityCompare = getPriorityValue(p1.getPriority()) - 
                              getPriorityValue(p2.getPriority());
        
        if (priorityCompare != 0) return priorityCompare;
        
        // Then by age (older first)
        int ageCompare = p2.getAge() - p1.getAge();
        if (ageCompare != 0) return ageCompare;
        
        // Then hospital patients first
        return Boolean.compare(p2.isFromHospitalWard(), p1.isFromHospitalWard());
    }
    
    private int getPriorityValue(String priority) {
        return switch (priority) {
            case "High" -> 1;
            case "Medium" -> 2;
            case "Low" -> 3;
            default -> 4;
        };
    }
    
    public void addPatient(Patient patient) {
        patientQueue.add(patient);
    }
    
    public Patient processNextPatient() {
        return patientQueue.poll();
    }
    
    public void markNoShow(Patient patient) {
        noShowList.addFirst(patient);
        if (noShowList.size() > MAX_NO_SHOWS) {
            noShowList.removeLast();
        }
    }
    
    public List<Patient> getQueueStatus() {
        return new ArrayList<>(patientQueue);
    }
    
    public List<Patient> getNoShowsStatus() {
        return new ArrayList<>(noShowList);
    }
    
    public boolean isQueueEmpty() {
        return patientQueue.isEmpty();
    }
    
    // Recursive method for checking no-shows in the LinkedList
    public boolean isPatientNoShow(String name, int index) {
        if (index >= noShowList.size()) return false;
        if (noShowList.get(index).getName().equals(name)) return true;
        return isPatientNoShow(name, index + 1);
    }
}
