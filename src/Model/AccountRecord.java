package Model;

import java.io.*;
import java.text.ParseException;
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
    //------------------------------This will return all the login details----------------------------------------------
    public List<Login> viewAllLogins() throws IOException, NoSuchElementException {
        String record;
        Login loginRecord = new Login();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        List<Login> loginRecordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer loginDetail = new StringTokenizer(record,",");
                //set data to loginRecordObject
                loginRecord.setLoginID(loginDetail.nextToken());
                loginRecord.setTypedUserName(loginDetail.nextToken());
                loginRecord.setTypedPassword(loginDetail.nextToken());
                loginRecord.setLoginDateAndTime(formatter.parse(loginDetail.nextToken()));
                loginRecord.setLoginStatus(Boolean.parseBoolean(loginDetail.nextToken()));

                loginRecordList.add(loginRecord);
            }
            br.close();
        }
        catch (IOException | NoSuchElementException | ParseException e){
            System.out.println("Error : " + e);
        }
        return loginRecordList;
    }

    //-----------------------------Return Login object by It's ID-------------------------------------------------------
    public Account viewByID(String accountID) throws IOException{
        String record;
        Account accountRecord = new Account();
        String userType;
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t Search Login Record of LoginID : " + accountID);

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer accountDetail = new StringTokenizer(record,",");
                //Check whether that the login record looking for
                if( record.contains(accountID) ) {
                    //set data to loginRecordObject
                    accountRecord.setAccountID(accountDetail.nextToken());
                    accountRecord.setPassword(accountDetail.nextToken());
                    accountRecord.setImage(new Image(Integer.parseInt(accountDetail.nextToken()),Integer.parseInt(accountDetail.nextToken()),accountDetail.nextToken(),accountDetail.nextToken()));
                    userType = accountDetail.nextToken();
                    switch (userType){
                        case "ADMIN":
                            accountRecord.setUserType(UserType.ADMIN);
                            //accountRecord.setUser(new User(accountDetail.nextToken(),accountDetail.nextToken(),accountDetail.nextToken());
                            break;
                        case "MEDICALOFFICER":
                            accountRecord.setUserType(UserType.MEDICALOFFICER);
                            break;
                        case "RECEPTIONIST":
                            accountRecord.setUserType(UserType.RECEPTIONIST);
                            break;
                        case "PATIENT":
                            accountRecord.setUserType(UserType.PATIENT);
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
            System.out.println("\"" + account.toString() + "\" record added to " + this.getFileName() + "successfully");
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }

    //--------------------------------Delete login details according to loginID-----------------------------------------
    public void dlt(String accountID) throws IOException {
        try {
            String record, ID = accountID;

            //open Login details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDB = new File("account_db_temp.txt");
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
            System.out.println("\t Delete Record of account ID : " + accountID + "is successfully");
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }

    //--------------------------------Edit single data in a file--------------------------------------------------------
    public void editLoginData(String loginID, String editfield, String updatedData) throws IOException{
        String loginId, typedUserName, typedPassword, loginDateNTime, loginStatus, record;
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
                StringTokenizer loginDetail = new StringTokenizer(record,",");

                loginId = loginDetail.nextToken();
                typedUserName = loginDetail.nextToken();
                typedPassword =loginDetail.nextToken();
                loginDateNTime = loginDetail.nextToken();
                loginStatus = loginDetail.nextToken();

                //create loginRec Objects by reading data of the file
                Login loginRec = new Login(loginId,typedUserName,typedPassword,formatter.parse(loginDateNTime),Boolean.parseBoolean(loginStatus));
                //Check whether that the login record to be edited... if it is then replace that record field according to given data
                if(loginId.equals(loginID)){
                    switch (editfield) {
                        case "typedUserName":
                            loginRec.setTypedUserName(updatedData);
                            break;
                        case "typedPassword":
                            loginRec.setTypedPassword(updatedData);
                            break;
                        case "loginDateNTime":
                            loginRec.setLoginDateAndTime(formatter.parse(updatedData));
                            break;
                        case "loginStatus":
                            loginRec.setLoginStatus(Boolean.parseBoolean(updatedData));
                            break;
                        default:
                            System.out.println("Invalid Editfield");
                    }
                }
                // add loginRec object to the temporary file
                bw.write(loginRec.toString());
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
