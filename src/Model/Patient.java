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

    public void getBloodInformation(BloodType type) {
        switch (type) {
            case A_PLUS:
                System.out.println("Blood Type A+");
                break;
            case A_MINUS:
                System.out.println("Blood Type A-");
                break;
            case B_PLUS:
                System.out.println("Blood Type B+");
                break;
            case B_MINUS:
                System.out.println("Blood Type B-");
                break;
            case O_PLUS:
                System.out.println("Blood Type O+");
                break;
            case O_MINUS:
                System.out.println("Blood Type O-");
                break;
            case AB_PLUS:
                System.out.println("Blood Type AB+");
                break;
            case AB_MINUS:
                System.out.println("Blood Type AB-");
                break;

            default:
                System.out.println("There is no code for the type you write !!");
        }
    }
    @Override
    public String toString(){
        return super.toString() + "," + this.getBloodType() + "," + this.getAllergies();
    }
}