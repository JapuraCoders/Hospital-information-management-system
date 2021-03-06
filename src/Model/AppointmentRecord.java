package Model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AppointmentRecord {
    private String fileName;

    public AppointmentRecord(String fileName){
        this.setFileName(fileName);
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }

    //------------------------------This will return all the appointment details----------------------------------------------
    public ArrayList<Appointment> viewAllAppointments() throws IOException, NoSuchElementException {

        ArrayList<Appointment> appointmentRecordList = new ArrayList<>();
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );
            String record;
            while( ( record = br.readLine() ) != null ) {
                Appointment appointmentRecord = new Appointment();
                StringTokenizer appointmentDetail = new StringTokenizer(record,",");

                appointmentRecord.setAppointmentID(appointmentDetail.nextToken());
                appointmentRecord.setPatientName(appointmentDetail.nextToken());
                appointmentRecord.setAppointmentDateAndTime(formatter.parse(appointmentDetail.nextToken()));
                appointmentRecord.setSymptoms(appointmentDetail.nextToken());
                appointmentRecord.setAppointmentNo(appointmentDetail.nextToken());
                appointmentRecord.setAppointmentStatus(AppointmentStatus.valueOf(appointmentDetail.nextToken()));
                appointmentRecord.setMedicalOfficerName(appointmentDetail.nextToken());
                appointmentRecord.setMedicalOfficerSpeciality(appointmentDetail.nextToken());
                appointmentRecord.setAppointmentDate(appointmentDetail.nextToken());
                appointmentRecord.setAppointmentTime(appointmentDetail.nextToken());

                appointmentRecordList.add(appointmentRecord);
            }
            br.close();
        }
        catch (IOException | NoSuchElementException | ParseException e){
            System.out.println("Error : " + e);
        }
        return appointmentRecordList;
    }

    //-----------------------------Return appointment object by patient Name-------------------------------------------------------
    public Appointment viewByAppointmentID(String appointmentID) throws IOException{
        String record;
        Appointment appointmentRecord = new Appointment();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t Search Appointment Record of appointmentID : " + appointmentID);

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer appointmentDetail = new StringTokenizer(record,",");
                //Check whether that the login record looking for
                if( record.contains(appointmentID) ) {
                    //set data to loginRecordObject
                    appointmentRecord.setAppointmentID(appointmentDetail.nextToken());
                    appointmentRecord.setPatientName(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentDateAndTime(formatter.parse(appointmentDetail.nextToken()));
                    appointmentRecord.setSymptoms(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentNo(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentStatus(AppointmentStatus.valueOf(appointmentDetail.nextToken()));
                    appointmentRecord.setMedicalOfficerName(appointmentDetail.nextToken());
                    appointmentRecord.setMedicalOfficerSpeciality(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentDate(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentTime(appointmentDetail.nextToken());
                }
            }
            br.close();
        }
        catch (IOException | ParseException | NullPointerException e){
            System.out.println("Error : "+e);
        }
        if(appointmentRecord==null){
            System.out.println("There is no record contained " + appointmentID);
        }
        return appointmentRecord;
    }
    //-----------------------------Return appointment object by AppointmentStatus-------------------------------------------------------
    public Appointment viewByAppointmentStatus(String appointmentStatus) throws IOException{
        String record;
        Appointment appointmentRecord = new Appointment();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t Search Appointment Record of AppointmentStatus : " + appointmentStatus);

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer appointmentDetail = new StringTokenizer(record,",");

                if( record.contains(appointmentStatus) ) {

                    appointmentRecord.setAppointmentID(appointmentDetail.nextToken());
                    appointmentRecord.setPatientName(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentDateAndTime(formatter.parse(appointmentDetail.nextToken()));
                    appointmentRecord.setSymptoms(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentNo(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentStatus(AppointmentStatus.valueOf(appointmentDetail.nextToken()));
                    appointmentRecord.setMedicalOfficerName(appointmentDetail.nextToken());
                    appointmentRecord.setMedicalOfficerSpeciality(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentDate(appointmentDetail.nextToken());
                    appointmentRecord.setAppointmentTime(appointmentDetail.nextToken());
                }
            }
            br.close();
        }
        catch (IOException | ParseException | NullPointerException e){
            System.out.println("Error : "+e);
        }
        if(appointmentRecord==null){
            System.out.println("There is no record contained " + appointmentStatus);
        }
        return appointmentRecord;
    }

    //--------------------------------------Add new appointment record to the file--------------------------------------------
    public void add(Appointment appointment) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));
            //write on file according to Object's toString format
            bw.write(appointment.toString());
            bw.flush();
            bw.newLine();
            bw.close();
            System.out.println("\"" + appointment.toString() + "\" record added to " + this.getFileName() + "successfully");
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }

    //--------------------------------Delete login details according to patientName-----------------------------------------
    public void dlt(String appointmentID) throws IOException {
        try {
            String record, ID = appointmentID;

            //open Login details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDB = new File("appointment_db_temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            while ((record = br.readLine()) != null) {
                if (!record.contains(ID)) {
                    bw.write(record);
                    bw.flush();
                    bw.newLine();
                }
            }
            br.close();
            bw.close();

            db.delete();
            tempDB.renameTo(db);
            System.out.println("\t Delete Account Record of appointment ID : " + appointmentID + "is successfully");
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }//-----------------------------------------------------------------------------------------------------------------


    //--------------------------------Edit single data in a file--------------------------------------------------------
    public void editLoginData(String appointmentID, String editfield, String updatedData) throws IOException{
        String ID,  patientName, appointmentDateAndTime, symptoms,appointmentNo,medicalOfficerName,medicalOfficerSpeciality,appointmentStatus ,record,appointmentDate,appointmentTime;
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            //open Login details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDb = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDb));

            //Load data line by line
            while( ( record = br.readLine() ) != null ) {
                StringTokenizer appointmentDetail = new StringTokenizer(record,",");

                ID = appointmentDetail.nextToken();
                patientName = appointmentDetail.nextToken();
                appointmentDateAndTime = appointmentDetail.nextToken();
                symptoms = appointmentDetail.nextToken();
                appointmentNo =appointmentDetail.nextToken();
                appointmentStatus = appointmentDetail.nextToken();
                medicalOfficerName = appointmentDetail.nextToken();
                medicalOfficerSpeciality = appointmentDetail.nextToken();
                appointmentDate = appointmentDetail.nextToken();
                appointmentTime =appointmentDetail.nextToken();


                Appointment appointmentRec = new Appointment(ID,patientName,formatter.parse(appointmentDateAndTime),symptoms,appointmentNo,AppointmentStatus.valueOf(appointmentStatus),medicalOfficerName,medicalOfficerSpeciality,appointmentDate,appointmentTime);
                //Check whether that the visitor record to be edited... if it is then replace that record field according to given data
                if(patientName.equals(appointmentID)){
                    switch (editfield) {
                        case "patientName":
                            appointmentRec.setPatientName(updatedData);
                            break;
                        case "appointmentDateAndTime":
                            appointmentRec.setAppointmentDateAndTime(formatter.parse(updatedData));
                            break;
                        case "symptoms":
                            appointmentRec.setSymptoms(updatedData);
                            break;
                        case "appointmentNo":
                            appointmentRec.setAppointmentNo(updatedData);
                            break;
                        case "appointmentStatus":
                            appointmentRec.setAppointmentStatus(AppointmentStatus.valueOf(updatedData));
                            break;
                        case "medicalOfficerName":
                            appointmentRec.setMedicalOfficerName(updatedData);
                            break;
                        case "medicalOfficerSpeciality":
                            appointmentRec.setMedicalOfficerSpeciality(updatedData);
                            break;
                        case "appointmentDate":
                            appointmentRec.setAppointmentDate(updatedData);
                            break;
                        case "appointmentTime":
                            appointmentRec.setAppointmentTime(updatedData);
                            break;

                        default:
                            System.out.println("Invalid Editfield");
                    }
                }
                // add appointmentRec object to the temporary file
                bw.write(appointmentRec.toString());
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();
            db.delete();
            tempDb.renameTo(db);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}