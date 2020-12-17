package Model;

import java.io.*;
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

    //View all login details
    public List<String> viewAllAccounts() throws IOException, NoSuchElementException {
        String record,ID,password,image,user,userType,accountRecord;
        List<String> recordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer accountDetail = new StringTokenizer(record,",");

                ID = accountDetail.nextToken();
                password = accountDetail.nextToken();
                image =accountDetail.nextToken();
                user = accountDetail.nextToken();
                userType = accountDetail.nextToken();

                accountRecord = "\nAccountID : "+ID+"\nPassword : "+password+"\nImage : "+image+"\nUserDetails : "+user+"\nUserType : "+userType+"\n----------------------------";

                recordList.add(accountRecord);
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error : " + e);
        }
        catch (NoSuchElementException e){
            System.out.println("Error : "+ e);
        }
        return recordList;
    }

    //return details of Account by It's ID
    public String viewByID(String accountID) throws IOException{
        String ID = accountID,password,image,user,userType,record, accountRecord = "Null";
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t\t Search Account Record\n");

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer accountDetail = new StringTokenizer(record,",");
                if( record.contains(ID) ) {
                    ID = accountDetail.nextToken();
                    password = accountDetail.nextToken();
                    image =accountDetail.nextToken();
                    user = accountDetail.nextToken();
                    userType = accountDetail.nextToken();

                    accountRecord = "AccountID : "+ID+"\nPassword : "+password+"\nImage : "+image+"\nUserDetails : "+user+"\nUserType : "+userType;
                }
            }
            br.close();
        }
        catch (IOException e){
         System.out.println("Error : "+e);
        }
        return accountRecord;
    }

    //add new account record
    public void add(Account account) throws IOException {
        try {

            BufferedWriter bw = new BufferedWriter( new FileWriter(this.getFileName(),true) );

            String accountID, password, image, user, userType;

            accountID = account.getAccountID();
            password = account.getPassword();
            image = account.getImage().toString();
            user = account.getUser().toString();
            userType = account.getUserType().toString();

            bw.write(accountID+","+password+","+image+","+user+","+userType);
            bw.flush();
            bw.newLine();
            bw.close();
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }

    //Delete any account
    public void dlt(String accountID) throws IOException {
        try {
            String record, ID = accountID;

            File tempDB = new File("account_db_temp.txt");
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
