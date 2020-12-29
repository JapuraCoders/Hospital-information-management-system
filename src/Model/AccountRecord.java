package Model;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class AccountRecord {
    private String fileName;

    public AccountRecord(String fileName){
        this.setFileName(fileName);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName(){
        return this.fileName;
    }

    //methods
    //------------------------------This will return all the account details----------------------------------------------
    public List<Account> viewAllAccounts() throws IOException, NoSuchElementException {
        String record, userType;
        Account accountRecord = new Account();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        List<Account> accountRecordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer accountDetail = new StringTokenizer(record,",");
                //set data to accountRecord Object
                accountRecord.setAccountID(accountDetail.nextToken());
                accountRecord.setPassword(accountDetail.nextToken());
                accountRecord.setImage(new Image(Integer.parseInt(accountDetail.nextToken()),Integer.parseInt(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken()));

                userType = accountDetail.nextToken();
                switch (userType){
                    case "ADMIN":
                        accountRecord.setUserType(UserType.ADMIN);
                        //create a user object according to the format of User(String name, String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus)
                        accountRecord.setUser(new User(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken())));
                        break;
                    case "MEDICALOFFICER":
                        accountRecord.setUserType(UserType.MEDICALOFFICER);
                        //create a medical officer object according to the format of MedicalOfficer(String name, String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus, String staffID, String staffEmailAddress, String dateJoining, Image staffPhotograph, String specialtyArea)
                        accountRecord.setUser(new MedicalOfficer(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),(new Image(Integer.parseInt(accountDetail.nextToken()),Integer.parseInt(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken())),accountDetail.nextToken()));
                        break;
                    case "RECEPTIONIST":
                        accountRecord.setUserType(UserType.RECEPTIONIST);
                        // create a staff object for receptionist according to the format of Staff(String name,String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus,String staffID,String staffEmailAddress,String dateJoining,Image staffPhotograph)
                        accountRecord.setUser(new Staff(accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), Gender.valueOf(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken(), MaritalStatus.valueOf(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), (new Image(Integer.parseInt(accountDetail.nextToken()), Integer.parseInt(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken()))));
                        break;
                    case "PATIENT":
                        accountRecord.setUserType(UserType.PATIENT);
                        //create a patient object according to the format of Patient(String name, String phone, String nIC , String userName, Gender gender, String dob, String address, MaritalStatus maritalStatus,BloodType bloodType, String allergies)
                        accountRecord.setUser(new Patient(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken()),BloodType.valueOf(accountDetail.nextToken()),accountDetail.nextToken()));
                        break;
                }
                accountRecordList.add(accountRecord);
            }
            br.close();
        }

        catch (IOException | NoSuchElementException e){
            System.out.println("Error : " + e);
        }
        return accountRecordList;
    }

    //-----------------------------Return Account object by It's ID-------------------------------------------------------
    public Account viewByID(String accountID) throws IOException{
        String record,userType;
        Account accountRecord = new Account();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t Search Account Record of AccountID : " + accountID);

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer accountDetail = new StringTokenizer(record,",");
                //Check whether that the account record looking for
                if( record.contains(accountID) ) {
                    //set data to accountRecordObject
                    accountRecord.setAccountID(accountDetail.nextToken());
                    accountRecord.setPassword(accountDetail.nextToken());
                    accountRecord.setImage(new Image(Integer.parseInt(accountDetail.nextToken()),Integer.parseInt(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken()));
                    userType = accountDetail.nextToken();
                    switch (userType){
                        case "ADMIN":
                            accountRecord.setUserType(UserType.ADMIN);
                            //create a user object according to the format of User(String name, String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus)
                            accountRecord.setUser(new User(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken())));
                            break;
                        case "MEDICALOFFICER":
                            accountRecord.setUserType(UserType.MEDICALOFFICER);
                            //create a medical officer object according to the format of MedicalOfficer(String name, String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus, String staffID, String staffEmailAddress, String dateJoining, Image staffPhotograph, String specialtyArea)
                            accountRecord.setUser(new MedicalOfficer(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),(new Image(Integer.parseInt(accountDetail.nextToken()),Integer.parseInt(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken())),accountDetail.nextToken()));
                            break;
                        case "RECEPTIONIST":
                            accountRecord.setUserType(UserType.RECEPTIONIST);
                            // create a staff object for receptionist according to the format of Staff(String name,String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus,String staffID,String staffEmailAddress,String dateJoining,Image staffPhotograph)
                            accountRecord.setUser(new Staff(accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), Gender.valueOf(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken(), MaritalStatus.valueOf(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), (new Image(Integer.parseInt(accountDetail.nextToken()), Integer.parseInt(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken()))));
                            break;
                        case "PATIENT":
                            accountRecord.setUserType(UserType.PATIENT);
                            //create a patient object according to the format of Patient(String name, String phone, String nIC , String userName, Gender gender, String dob, String address, MaritalStatus maritalStatus,BloodType bloodType, String allergies)
                            accountRecord.setUser(new Patient(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken()),BloodType.valueOf(accountDetail.nextToken()),accountDetail.nextToken()));
                            break;
                    }
                }
            }
            br.close();
        }
        catch (IOException | NullPointerException e){
            System.out.println("Error : "+e);
        }
        if(accountRecord==null){
            System.out.println("There is no record contained " + accountID);
        }
        return accountRecord;
    }

    //--------------------------------------Add new Account record to the file--------------------------------------------
    public void add(Account account) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));
            //write on file according to Object's toString format
            bw.write(account.toString());
            bw.flush();
            bw.newLine();
            bw.close();
            System.out.println("\"" + account.toString() + "\" record added to \" " + this.getFileName() + " \" successfully");
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }

    //--------------------------------Delete account details according to accountID-----------------------------------------
    public void dlt(String accountID) throws IOException {
        try {
            String record;

            //open Login details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDB = new File("account_db_temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            while ((record = br.readLine()) != null) {
                if (!record.contains(accountID)) {
                    bw.write(record);
                    bw.flush();
                    bw.newLine();
                }
            }
            br.close();
            bw.close();

            db.delete();
            tempDB.renameTo(db);
            System.out.println("\t Delete Record of account ID : " + accountID + "is successfully");
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }

    //--------------------------------Edit single data in a file--------------------------------------------------------
    public void editAccountData(String accountID, String editfield, String updatedData) throws IOException{
        String record, userType;
        //String userType, loginId, typedUserName, typedPassword, loginDateNTime, loginStatus, record;
        //SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            //open Account details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDb = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDb));

            //Load data line by line
            while( ( record = br.readLine() ) != null ) {
                StringTokenizer accountDetail = new StringTokenizer(record,",");

                //create accountRec Objects by reading data of the file
                Account accountRecord = new Account();

                accountRecord.setAccountID(accountDetail.nextToken());
                accountRecord.setPassword(accountDetail.nextToken());
                accountRecord.setImage(new Image(Integer.parseInt(accountDetail.nextToken()),Integer.parseInt(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken()));
                userType = accountDetail.nextToken();
                switch (userType){
                    //------------if the user type is admin--------------------------------------------
                    case "ADMIN":
                        accountRecord.setUserType(UserType.ADMIN);
                        //create a user object according to the format of User(String name, String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus)
                        User admin = new User(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken()));
                        //Check whether that the account record to be edited... if it is then replace that record field according to given data
                        if(accountRecord.getAccountID().equals(accountID)){
                            switch (editfield) {
                                case "password":
                                    accountRecord.setPassword(updatedData);
                                    break;
                                case "image":
                                    accountRecord.getImage().addNewImage(updatedData);
                                    break;
                                case "userName":
                                    admin.setUserName(updatedData);
                                    break;
                                case "gender":
                                    admin.setGender(Gender.valueOf(updatedData));
                                    break;
                                case "dOB":
                                    admin.setDOB(updatedData);
                                    break;
                                case "address":
                                    admin.setAddress(updatedData);
                                    break;
                                case "maritalStatus":
                                    admin.setMaritalStus(MaritalStatus.valueOf(updatedData));
                                    break;
                                default:
                                    System.out.println("Invalid Editfield");
                                    break;
                            }
                        }
                        accountRecord.setUser(admin);
                        break;
                        //-------------------If the user type is a medical officer-----------------
                    case "MEDICALOFFICER":
                        accountRecord.setUserType(UserType.MEDICALOFFICER);
                        //create a medical officer object according to the format of MedicalOfficer(String name, String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus, String staffID, String staffEmailAddress, String dateJoining, Image staffPhotograph, String specialtyArea)
                        MedicalOfficer medicalOfficer = new MedicalOfficer(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),(new Image(Integer.parseInt(accountDetail.nextToken()),Integer.parseInt(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken())),accountDetail.nextToken());
                        //Check whether that the account record to be edited... if it is then replace that record field according to given data
                        if(accountRecord.getAccountID().equals(accountID)){
                            switch (editfield) {
                                case "password":
                                    accountRecord.setPassword(updatedData);
                                    break;
                                case "image":
                                    accountRecord.getImage().addNewImage(updatedData);
                                    break;
                                case "userName":
                                    medicalOfficer.setUserName(updatedData);
                                    break;
                                case "gender":
                                    medicalOfficer.setGender(Gender.valueOf(updatedData));
                                    break;
                                case "dOB":
                                    medicalOfficer.setDOB(updatedData);
                                    break;
                                case "address":
                                    medicalOfficer.setAddress(updatedData);
                                    break;
                                case "maritalStatus":
                                    medicalOfficer.setMaritalStus(MaritalStatus.valueOf(updatedData));
                                    break;
                                case "staffID":
                                    medicalOfficer.setStaffID(updatedData);
                                    break;
                                case "staffEmailAddress":
                                    medicalOfficer.setStaffEmailAddress(updatedData);
                                    break;
                                case "dateJoining":
                                    medicalOfficer.setDateJoining(updatedData);
                                    break;
                                case "staffPhotograph":
                                    medicalOfficer.getStaffPhotograph().addNewImage(updatedData);
                                    break;
                                case "specialityArea":
                                    medicalOfficer.setSpecialtyArea(updatedData);
                                    break;
                                default:
                                    System.out.println("Invalid Editfield");
                                    break;
                            }
                        }
                        accountRecord.setUser(medicalOfficer);
                        break;
                        //--------------------If the user type is a receptionist---------------
                    case "RECEPTIONIST":
                        accountRecord.setUserType(UserType.RECEPTIONIST);
                        // create a staff object for receptionist according to the format of Staff(String name,String phone, String nIC, String userName, Gender gender, String dOB, String address, MaritalStatus maritalStatus,String staffID,String staffEmailAddress,String dateJoining,Image staffPhotograph)
                        Staff receptionist = new Staff(accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), Gender.valueOf(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken(), MaritalStatus.valueOf(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken(), accountDetail.nextToken(), (new Image(Integer.parseInt(accountDetail.nextToken()), Integer.parseInt(accountDetail.nextToken()), accountDetail.nextToken(), accountDetail.nextToken())));
                        //Check whether that the account record to be edited... if it is then replace that record field according to given data
                        if(accountRecord.getAccountID().equals(accountID)){
                            switch (editfield) {
                                case "password":
                                    accountRecord.setPassword(updatedData);
                                    break;
                                case "image":
                                    accountRecord.getImage().addNewImage(updatedData);
                                    break;
                                case "userName":
                                    receptionist.setUserName(updatedData);
                                    break;
                                case "gender":
                                    receptionist.setGender(Gender.valueOf(updatedData));
                                    break;
                                case "dOB":
                                    receptionist.setDOB(updatedData);
                                    break;
                                case "address":
                                    receptionist.setAddress(updatedData);
                                    break;
                                case "maritalStatus":
                                    receptionist.setMaritalStus(MaritalStatus.valueOf(updatedData));
                                    break;
                                case "staffID":
                                    receptionist.setStaffID(updatedData);
                                    break;
                                case "staffEmailAddress":
                                    receptionist.setStaffEmailAddress(updatedData);
                                    break;
                                case "dateJoining":
                                   receptionist.setDateJoining(updatedData);
                                    break;
                                case "staffPhotograph":
                                    receptionist.getStaffPhotograph().addNewImage(updatedData);
                                    break;
                                default:
                                    System.out.println("Invalid Editfield");
                                    break;
                            }
                        }
                        accountRecord.setUser(receptionist);
                        break;
                        //-------------------If the user type is a patient-----------------------
                    case "PATIENT":
                        accountRecord.setUserType(UserType.PATIENT);
                        //create a patient object according to the format of Patient(String name, String phone, String nIC , String userName, Gender gender, String dob, String address, MaritalStatus maritalStatus,BloodType bloodType, String allergies)
                        Patient patient = new Patient(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken(),Gender.valueOf(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken(),MaritalStatus.valueOf(accountDetail.nextToken()),BloodType.valueOf(accountDetail.nextToken()),accountDetail.nextToken());
                        //Check whether that the account record to be edited... if it is then replace that record field according to given data
                        if(accountRecord.getAccountID().equals(accountID)){
                            switch (editfield) {
                                case "password":
                                    accountRecord.setPassword(updatedData);
                                    break;
                                case "image":
                                    accountRecord.getImage().addNewImage(updatedData);
                                    break;
                                case "userName":
                                    patient.setUserName(updatedData);
                                    break;
                                case "gender":
                                    patient.setGender(Gender.valueOf(updatedData));
                                    break;
                                case "dOB":
                                    patient.setDOB(updatedData);
                                    break;
                                case "address":
                                    patient.setAddress(updatedData);
                                    break;
                                case "maritalStatus":
                                    patient.setMaritalStus(MaritalStatus.valueOf(updatedData));
                                    break;
                                case "bloodType" :
                                    patient.setBloodType(BloodType.valueOf(updatedData));
                                    break;
                                case "allergies" :
                                    patient.setAllergies(updatedData);
                                default:
                                    System.out.println("Invalid Editfield");
                                    break;
                            }
                        }
                        accountRecord.setUser(patient);
                        break;
                }
                //add accountRec object to the temporary file
                bw.write(accountRecord.toString());
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();
            db.delete();
            tempDb.renameTo(db);
        } catch (IOException e) {
            System.out.println("Error :" + e);
        }
    }
}