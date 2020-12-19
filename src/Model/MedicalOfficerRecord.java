package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

class MedicalOfficerRecords {
    private String fileName;

    public MedicalOfficerRecords(String fileName){
        this.setFileName(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }

    //return all details
    public List<String> addMecicalOfficer(String StaffId, String StaffEmailAddress, String DateJoining, String Name, String Phone, String NIC, String UserName, String Gender, String DOB, String Address, MaritalStatus MaritalStatus) throws IOException, NoSuchElementException {
        String staffId , staffEmailAddress , dateJoining , name , phone , nIC , userName , gender , dOB ,address ,  record, medicalOfficerRecord;
        MaritalStatus maritalStatus;
        List<String> medicalOfficerRecordList = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer medicalOfficerDetail = new StringTokenizer(record,",");

                StaffId = medicalOfficerDetail.nextToken();
                StaffEmailAddress = medicalOfficerDetail.nextToken();
                DateJoining = medicalOfficerDetail.nextToken();
                Name = medicalOfficerDetail.nextToken();
                Phone = medicalOfficerDetail.nextToken();
                NIC = medicalOfficerDetail.nextToken();
                UserName = medicalOfficerDetail.nextToken();
                Gender = medicalOfficerDetail.nextToken();
                DOB = medicalOfficerDetail.nextToken();
                Address = medicalOfficerDetail.nextToken();


                medicalOfficerRecord = "\nStaffId : " + StaffId + "\nStaffEmailAddress : " + StaffEmailAddress + "\nDateJoining : " + DateJoining + "\nName : " + Name+ "\nPhone : " + Phone + "\nNIC : " + NIC + "\nUserName : " + UserName + "\nGender : " + Gender + "\nDOB : " + DOB + "\nAddress : " + Address + "\nMaritalStatus" + MaritalStatus;

                medicalOfficerRecordList.add(medicalOfficerRecord);
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error : " + e);
        }
        catch (NoSuchElementException e){
            System.out.println("Error : " + e);
        }
        return medicalOfficerRecordList;
    }

    //return details of medical officer
    public String viewByID(String medicalOfficerStaffId, String StaffId, String StaffEmailAddress, String DateJoining, String Name, String Phone, String NIC, String UserName, String Gender, String DOB, String Address, MaritalStatus MaritalStatus) throws IOException{
        String staffId = null, staffEmailAddress , dateJoining , name , phone , nIC , userName , gender , dOB ,address ,record, medicalOfficerRecord = "There is no record contained " + staffId;
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t Search Login Record of StaffId : " + staffId);

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer medicalOfficerDetail = new StringTokenizer(record,",");
                if( record.contains(staffId) ) {
                    StaffId = medicalOfficerDetail.nextToken();
                    StaffEmailAddress = medicalOfficerDetail.nextToken();
                    DateJoining = medicalOfficerDetail.nextToken();
                    Name = medicalOfficerDetail.nextToken();
                    Phone = medicalOfficerDetail.nextToken();
                    NIC = medicalOfficerDetail.nextToken();
                    UserName = medicalOfficerDetail.nextToken();
                    Gender = medicalOfficerDetail.nextToken();
                    DOB = medicalOfficerDetail.nextToken();
                    Address = medicalOfficerDetail.nextToken();

                    medicalOfficerRecord = "\nStaffId : " + StaffId + "\nStaffEmailAddress : " + StaffEmailAddress + "\nDateJoining : " + DateJoining + "\nName : " + Name+ "\nPhone : " + Phone + "\nNIC : " + NIC + "\nUserName : " + UserName + "\nGender : " + Gender + "\nDOB : " + DOB + "\nAddress : " + Address + "\nMaritalStatus" + MaritalStatus;
                }
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
        return medicalOfficerRecord;
    }


    //add new medical officer record
    public void add(MedicalOfficer medicalOfficer) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));

            String record, medicalOfficerRecord;

            String staffId = medicalOfficer.getStaffID();
            String staffEmailAddress = medicalOfficer.getStaffEmailAddress();
            String dateJoining = medicalOfficer.getDateJoining().toString();
            String name = medicalOfficer.getName();
            String phone = medicalOfficer.getPhone();
            String nIC = medicalOfficer.getNIC();
            String userName = medicalOfficer.getUserName();
            String gender = medicalOfficer.getGender().toString();
            String dOB = medicalOfficer.getDOB().toString();
            String address = medicalOfficer.getAddress();


            medicalOfficerRecord = staffId + "," + staffEmailAddress + "," + dateJoining;
            bw.write(medicalOfficerRecord);
            System.out.println(medicalOfficerRecord);
            bw.flush();
            bw.newLine();
            bw.close();
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }


    //Delete medical officer details according to staffId
    public void dlt(String staffId) throws IOException {
        try {
            String record, Id = staffId;

            File tempDB = new File("medicalOfficer_db_temp.txt");
            File db = new File(this.getFileName());

            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            System.out.println("\t Delete Account Record of Staff Id : " + staffId);

            while ((record = br.readLine()) != null) {
                if (!record.contains(staffId)) {
                    bw.write(record);
                    bw.flush();
                    bw.newLine();
                }
            }
            br.close();
            bw.close();

            db.delete();

            tempDB.renameTo(db);
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }


}
