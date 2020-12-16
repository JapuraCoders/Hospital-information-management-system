package Model;

import java.io.*;
import java.util.StringTokenizer;

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

    //View all details
    public void viewAllAccounts() throws IOException{
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            String record,ID,password,image,user,userType;

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer accountDetail = new StringTokenizer(record,",");

                ID = accountDetail.nextToken();
                password = accountDetail.nextToken();
                image =accountDetail.nextToken();
                user = accountDetail.nextToken();
                userType = accountDetail.nextToken();

                System.out.println("AccountID : "+ID+"\nPassword : "+password+"\nImage : "+image+"\nUserDetails : "+user+"\nUserType : "+userType+"\n");

            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error : " + e);
        }
    }

    //return details of Account by It's ID
    public void viewByID(String accountID) throws IOException{
        try{
            String record, ID = accountID,password,image,user,userType;

            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t\t Search Account Record\n");

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer accountDetail = new StringTokenizer(record,",");
                if( record.contains(ID) ) {
                    //return AccountDetails
                    password = accountDetail.nextToken();
                    image =accountDetail.nextToken();
                    user = accountDetail.nextToken();
                    userType = accountDetail.nextToken();
                    System.out.println("AccountID : "+ID+"\nPassword : "+password+"\nImage : "+image+"\nUserDetails : "+user+"\nUserType : "+userType);
                }

            }
            br.close();
        }
        catch (IOException e){
        System.out.println("Error : "+e);
        }
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
                if (record.contains(ID))
                    continue;
                bw.write(record);
                bw.flush();
                bw.newLine();
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
