package Model;

import java.util.Date;

public class MedicalOfficer extends Staff {
    private String specialtyArea;

    public MedicalOfficer(String name, String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus, String staffID, String staffEmailAddress, String dateJoining, Image staffPhotograph, String specialtyArea) {
        super(name, phone, nIC, userName, gender, dOB, address, maritalStatus, staffID, staffEmailAddress, dateJoining, staffPhotograph);
        this.setSpecialtyArea(specialtyArea);
    }

    //setters
    public void setSpecialtyArea (String specialtyArea){
        this.specialtyArea = specialtyArea;
    }

    //getters
    public String getSpecialtyArea(){
        return this.specialtyArea;
    }

    @Override
    public String toString(){
        return super.toString() + "\n" + this.getSpecialtyArea();
    }
}
