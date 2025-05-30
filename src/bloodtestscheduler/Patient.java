/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bloodtestscheduler;

/** This class defines the properties of a Patient object
 *
 * @author Leandro Crisol Lo Presti
 * NCI Student ID: 23156503
 */
public class Patient {
    private String name;
    private int age;
    private String gpName;
    private String gpLicense; // Numbers and letters
    private String priority; // "Urgent", "Medium", "Low"
    private boolean fromHospitalWard;
    
    // Constructor
    public Patient(String name, int age, String gpName, String gpLicense, String priority, boolean fromHospitalWard) {
        this.name = name;
        this.age = age;
        this.gpName = gpName;
        this.gpLicense = gpLicense;
        this.priority = priority;
        this.fromHospitalWard = fromHospitalWard;
    }
    
    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGpName() { return gpName; }
    public String getGpLicense() { return gpLicense; }
    public String getPriority() { return priority; }
    public boolean isFromHospitalWard() { return fromHospitalWard; }
    
    @Override
    public String toString() {
        String newRow;
        
        newRow = "<tr>" +
                    "<td>"+name+"</td>"+
                    "<td>"+age+"</td>"+
                    "<td>"+gpName+"</td>"+
                    "<td>"+gpLicense+"</td>"+
                    "<td>"+priority+"</td>"+
                    "<td>"+fromHospitalWard+"</td>"+
                 "</tr>";
        
        return newRow;
    }
}