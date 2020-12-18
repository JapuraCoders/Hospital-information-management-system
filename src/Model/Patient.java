package Model;

import java.util.Date;
public class Patient extends user  {

    private BloodType bloodType;
    private String allergies;


    Patient( String userName, Gender gender, Date dOB, String address, MaritalStatus maritalStatus,Account account,BloodType bloodType,String allergies){
        super(userName,gender,dOB,address,maritalStatus,account);
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





    public static void main(String[] args)  {



    }




}