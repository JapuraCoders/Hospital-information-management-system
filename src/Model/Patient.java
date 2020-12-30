package Model;

import java.util.Date;

public class Patient extends User {

    private BloodType bloodType;
    private String allergies;

    public Patient(String name, String phone, String nIC , String userName, Gender gender, Date dob, String address, MaritalStatus maritalStatus, BloodType bloodType, String allergies){
        super(name, phone, nIC, userName, gender,dob,address,maritalStatus);
        this.setBloodType(bloodType);
        this.setAllergies(allergies);
    }

    public void setBloodType(BloodType bloodType){
        this.bloodType=bloodType;
    }

    public void setAllergies(String allergies){
        this.allergies=allergies;
    }


    public BloodType getBloodType()	{
        return this.bloodType;
    }

    public String getAllergies(){
        return this.allergies;
    }


    @Override
    public String toString(){
        return super.toString() + "," + this.getBloodType() + "," + this.getAllergies();
    }
}