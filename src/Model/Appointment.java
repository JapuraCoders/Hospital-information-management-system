package Model;


import java.util.Date;
public class Appointment {
    private String patientName;
    private Date appointmentDateAndTime;
    private String symptoms;
    private int appointmentNo;
    private AppointmentStatus appointmentStatus;
    private String medicalOfficerName;
    private String medicalOfficerSpeciality;
    private static int appointmentCounter;

    public Appointment(){
        this.setPatientName(null);
        this.setAppointmentDateAndTime(null);
        this.setSymptoms(null);
        this.setAppointmentNo(0);
        this.setMedicalOfficerName(null);
        this.setMedicalOfficerSpeciality(null);
        this.setAppointmentStatus(null);
        appointmentCounter++;

    }


    public Appointment(String patientName,Date appointmentDateAndTime,String symptoms,int appointmentNo,AppointmentStatus appointmentStatus,String medicalOfficerName,String medicalOfficerSpeciality){
        this.setPatientName(patientName);
        this.setAppointmentDateAndTime(appointmentDateAndTime);

        this.setSymptoms(symptoms);
        this.setAppointmentNo(appointmentNo);
        this.setAppointmentStatus(appointmentStatus);
        this.setMedicalOfficerName(medicalOfficerName);
        this.setMedicalOfficerSpeciality(medicalOfficerSpeciality);
        appointmentCounter++;
    }

    public void setPatientName(String patientName){this.patientName=patientName;}

    public void setMedicalOfficerName(String medicalOfficerName){this.medicalOfficerName=medicalOfficerName;}

    public void setMedicalOfficerSpeciality(String medicalOfficerSpeciality){this.medicalOfficerSpeciality=medicalOfficerSpeciality;}
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setAppointmentNo(int appointmentNo) {
        this.appointmentNo = appointmentNo;
    }


    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }


    public void setAppointmentDateAndTime(Date appointmentDateAndTime){
        this.appointmentDateAndTime =appointmentDateAndTime;
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





    public String getSymptoms() {
        return this.symptoms;

    }

    public int getAppointmentNo() {
        return this.appointmentNo;
    }

    public AppointmentStatus getAppointmentStatus() {
        return this.appointmentStatus;}

    public int getAppointmentCounter() {
        return Appointment.appointmentCounter;
    }

    @Override
    public String toString(){
        return this.getPatientName()+ "," + this.getAppointmentDateAndTime()+    "," + this.getSymptoms()+ "," + this.getAppointmentNo()+","+this.getAppointmentStatus()+","+this.getMedicalOfficerName()+","+this.getMedicalOfficerSpeciality();
    }
}


