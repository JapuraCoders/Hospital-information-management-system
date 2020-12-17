package Model;

import java.io.*;
import java.util.*;

public class LoginRecord {
    private String fileName;

    public LoginRecord(String fileName){
        this.setFileName(fileName);
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }

    //This will return all the login details
    public List<String> viewAllLogins() throws IOException, NoSuchElementException {
        String loginId, typedUserName, typedPassword, loginDate, loginTime, loginStatus, record, loginRecord;
        List<String> loginRecordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer loginDetail = new StringTokenizer(record,",");

                loginId = loginDetail.nextToken();
                typedUserName = loginDetail.nextToken();
                typedPassword =loginDetail.nextToken();
                loginDate = loginDetail.nextToken();
                loginTime = loginDetail.nextToken();
                loginStatus = loginDetail.nextToken();

                loginRecord = "\nLoginId : " + loginId + "\nTyped User Name : " + typedUserName + "\nTyped Password : " + typedPassword + "\nLogin Date : " + loginDate + "\nLogin Time : " + loginTime + "\nLogin Status : " + loginStatus + "\n----------------------";

                loginRecordList.add(loginRecord);
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error : " + e);
        }
        catch (NoSuchElementException e){
            System.out.println("Error : " + e);
        }
        return loginRecordList;
    }

    //return details of Login by It's ID
    public String viewByID(String loginID) throws IOException{
        String loginId = loginID,typedUserName, typedPassword, loginDate, loginTime, loginStatus, record, loginRecord = "Null";
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t\t Search Login Record\n");

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer loginDetail = new StringTokenizer(record,",");
                if( record.contains(loginID) ) {
                    loginId = loginDetail.nextToken();
                    typedUserName = loginDetail.nextToken();
                    typedPassword =loginDetail.nextToken();
                    loginDate = loginDetail.nextToken();
                    loginTime = loginDetail.nextToken();
                    loginStatus = loginDetail.nextToken();

                    loginRecord = "\nLoginId : " + loginId + "\nTyped User Name : " + typedUserName + "\nTyped Password : " + typedPassword + "\nLogin Date : " + loginDate + "\nLogin Time : " + loginTime + "\nLogin Status : " + loginStatus;
                }
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
        return loginRecord;
    }

    //add new login record
    public void add(Login login) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));

            String loginID,typedUserName, typedPassword, loginDate, loginTime, loginStatus, loginRecord;

            loginID = login.getLoginID();
            typedUserName = login.getTypedUserName();
            typedPassword = login.getTypedPassword();
            loginDate = login.getLoginDate().toString();
            loginTime = login.getLoginTime().toString();
            loginStatus= login.getLoginStatus().toString();

            loginRecord = loginID + "," + typedUserName + "," + typedPassword + "," + loginDate + "," + loginTime + "," + loginStatus;
            bw.write(loginRecord);
            System.out.println(loginRecord);
            bw.flush();
            bw.newLine();
            bw.close();
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }

    //Delete login details according to loginID
    public void dlt(String loginID) throws IOException {
        try {
            String record, ID = loginID;

            File tempDB = new File("login_db_temp.txt");
            File db = new File(this.getFileName());

            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            System.out.println("\t\t Delete Account Record\n");

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
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }

}