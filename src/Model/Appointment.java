package Model;


import java.util.Date;
public class Appointment {
    private String patientName;
    private Date appointmentDateAndTime;
    private String symptoms;
    private String appointmentNo;
    private AppointmentStatus appointmentStatus;
    private String medicalOfficerName;
    private String medicalOfficerSpeciality;
    private String appointmentDate;
    private String appointmentTime;
    public static int appointmentCounter;


    public Appointment(){
        this.setPatientName(null);
        this.setAppointmentDateAndTime(null);
        this.setSymptoms(null);
        this.setAppointmentNo("");
        this.setMedicalOfficerName(null);
        this.setMedicalOfficerSpeciality(null);
        this.setAppointmentStatus(null);
        this.setAppointmentDate(null);
        this.setAppointmentTime(null);

    }


    public Appointment(String patientName,Date appointmentDateAndTime,String symptoms,AppointmentStatus appointmentStatus,String medicalOfficerName,String medicalOfficerSpeciality,String appointmentDate,String appointmentTime){
        this.setPatientName(patientName);
        this.setAppointmentDateAndTime(appointmentDateAndTime);

        this.setSymptoms(symptoms);


        this.setAppointmentStatus(appointmentStatus);
        this.setMedicalOfficerName(medicalOfficerName);
        this.setMedicalOfficerSpeciality(medicalOfficerSpeciality);
        this.setAppointmentDate(appointmentDate);
        this.setAppointmentTime(appointmentTime);
        appointmentCounter++;
        this.setAppointmentNo(appointmentNo());
    }

    public Appointment(String patientName,Date appointmentDateAndTime,String symptoms,String appointmentNo,AppointmentStatus appointmentStatus,String medicalOfficerName,String medicalOfficerSpeciality,String appointmentDate,String appointmentTime){
        this.setPatientName(patientName);
        this.setAppointmentDateAndTime(appointmentDateAndTime);
        this.setSymptoms(symptoms);
        this.setAppointmentNo(appointmentNo);
        this.setAppointmentStatus(appointmentStatus);
        this.setMedicalOfficerName(medicalOfficerName);
        this.setMedicalOfficerSpeciality(medicalOfficerSpeciality);
        this.setAppointmentDate(appointmentDate);
        this.setAppointmentTime(appointmentTime);


    }


    //setters
    public void setPatientName(String patientName){this.patientName=patientName;}

    public void setMedicalOfficerName(String medicalOfficerName){this.medicalOfficerName=medicalOfficerName;}

    public void setMedicalOfficerSpeciality(String medicalOfficerSpeciality){this.medicalOfficerSpeciality=medicalOfficerSpeciality;}
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }


    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }


    public void setAppointmentDateAndTime(Date appointmentDateAndTime){
        this.appointmentDateAndTime =appointmentDateAndTime;
    }

    public void setAppointmentDate(String appointmentDate){
        this.appointmentDate=appointmentDate;
    }

    public void setAppointmentTime(String appointmentTime){
        this.appointmentTime=appointmentTime;
    }



    public void setAppointmentCounter(int appointmentCounter) {
        Appointment.appointmentCounter = appointmentCounter;
    }

    public String getPatientName(){return this.patientName;}

    public String getMedicalOfficerName(){return this.medicalOfficerName;}

    public String getMedicalOfficerSpeciality(){return this.medicalOfficerSpeciality;}
    public Date getAppointmentDateAndTime(){
        return this.appointmentDateAndTime;
    }
    public String getAppointmentNo(){
        return this.appointmentNo;
    }


//getters
   public String getAppointmentDate(){
        return  this.appointmentDate;
   }

    public String getAppointmentTime(){
        return  this.appointmentTime;
    }

    public String getSymptoms() {
        return this.symptoms;

    }

    public AppointmentStatus getAppointmentStatus() {
        return this.appointmentStatus;}

    public int getAppointmentCounter() {

        return Appointment.appointmentCounter;
    }




    public static String appointmentNo()
    {
        return String.format("%s%05d","Apt",appointmentCounter);
    }




    @Override
    public String toString(){
        return this.getPatientName()+ "," + this.getAppointmentDateAndTime()+    "," + this.getSymptoms()+ "," + this.getAppointmentNo()+","+this.getAppointmentStatus()+","+this.getMedicalOfficerName()+","+this.getMedicalOfficerSpeciality() + ","+ this.getAppointmentDate() + ","+ this.getAppointmentTime();
    }
}


