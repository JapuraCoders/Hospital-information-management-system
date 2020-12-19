package Model;

import java.util.Date;

public abstract class MedicalOfficer extends Staff {
    protected String specialtyArea;

    public MedicalOfficer(String name, String phone, String nIC, Gender gender, Date dOB, String address, MaritalStatus maritalStatus, String staffID, String staffEmailAddress, Date dateJoining, Image staffPhotograph, String specialtyArea) {
        super(name, phone, nIC, gender, dOB, address, maritalStatus, staffID, staffEmailAddress, dateJoining, staffPhotograph);
        this.specialtyArea = specialtyArea;
    }

    //setters
    public void setSpecialtyArea (String specialtyArea){ this.specialtyArea = specialtyArea; }

    //getters
    public String getSpecialtyArea(){
        return this.specialtyArea;
    }

    //Methods
    public abstract Image defaultStaffPhotograph();

    public String toString(){
        return super.toString() + "\n" + this.getSpecialtyArea();
    }
}
