package Model;
import java.util.Date;
public class Patient extends User {

    private BloodType bloodType;
    private String allergies;
    private PatientRecords patientRecords;

    public Patient(){
        super(null,null,null,null,null,null,null,null);
        this.setBloodType(null);
        this.setAllergies(null);

    }


    public Patient(String s, String name, String phone, String nIC, Gender gender, Date dOB, String address, MaritalStatus maritalStatus, BloodType bloodType, String allergies, PatientRecords patientRecords) {
        super(s, name, phone, nIC, gender, dOB, address, maritalStatus);
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.patientRecords = patientRecords;
    }

    public void setBloodType(BloodType bloodType){
        this.bloodType=bloodType;
    }

    public void setAllergies(String allergies){
        this.allergies=allergies;
    }

    public void setPatientRecords(PatientRecords patientRecords){this.patientRecords=patientRecords;}


    public BloodType getBloodType()	{
        return this.bloodType;
    }


    public String getAllergies(){
        return this.allergies;
    }

    public PatientRecords getPatientRecords(){return this.patientRecords;}

    void getBloodInformation(BloodType type) {
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





    public static void main(String[] args)  {

        BloodType type=BloodType.AB_PLUS;
        System.out.println(type);

    }




}


