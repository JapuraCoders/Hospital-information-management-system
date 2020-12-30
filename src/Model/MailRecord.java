package Model;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class MailRecord {

    private String fileName;

    public MailRecord(String fileName){
        this.setFileName(fileName);
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }
    //------------------------------This will return all the mail details----------------------------------------------
    public ArrayList<PostalMail> viewAllMails() throws NoSuchElementException {
        String record;
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        ArrayList<PostalMail> postalMailRecordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                PostalMail postalMailRecord = new PostalMail();
                //separate data into tokens by ","
                StringTokenizer mailDetail = new StringTokenizer(record,",");
                //set data to loginRecordObject
                postalMailRecord.setRefNo(mailDetail.nextToken());
                postalMailRecord.setMailType(MailType.valueOf(mailDetail.nextToken()));
                postalMailRecord.setToName(mailDetail.nextToken());
                postalMailRecord.setFromName(mailDetail.nextToken());
                postalMailRecord.setAddress(mailDetail.nextToken());
                postalMailRecord.setDate(formatter.parse(mailDetail.nextToken()));

                postalMailRecordList.add(postalMailRecord);
            }
            br.close();
        }
        catch (IOException | NoSuchElementException | ParseException e){
            System.out.println("Error : " + e);
        }
        return postalMailRecordList;
    }
    //-----------------------------Return PostalMail object by It's ID-------------------------------------------------------
    public PostalMail viewByID(String mailID){
        String record;
        PostalMail postalMailRecord = new PostalMail();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t Search Postal Mail Record of mailID : " + mailID);

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer mailDetail = new StringTokenizer(record,",");
                //Check whether that the login record looking for
                if( record.contains(mailID) ) {
                    //set data to loginRecordObject
                    postalMailRecord.setRefNo(mailDetail.nextToken());
                    postalMailRecord.setMailType(MailType.valueOf(mailDetail.nextToken()));
                    postalMailRecord.setToName(mailDetail.nextToken());
                    postalMailRecord.setFromName(mailDetail.nextToken());
                    postalMailRecord.setAddress(mailDetail.nextToken());
                    postalMailRecord.setDate(formatter.parse(mailDetail.nextToken()));
                }
            }
            br.close();
        }
        catch (IOException | ParseException | NullPointerException e){
            System.out.println("Error : "+e);
        }
        if(postalMailRecord==null){
            System.out.println("There is no record contained " + mailID);
        }
        return postalMailRecord;
    }
    //--------------------------------------Add new PostalMail record to the file--------------------------------------------
    public void add(PostalMail postalMail){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));
            //write on file according to Object's toString format
            bw.write(postalMail.toString());
            bw.flush();
            bw.newLine();
            bw.close();
            System.out.println("\"" + postalMail.toString() + "\" record added to " + this.getFileName() + "successfully");
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }
    //--------------------------------Delete mail details according to loginID-----------------------------------------
    public void dlt(String mailID){
        try {
            String record, ID = mailID;

            //open Login details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDB = new File("mail_db_temp.txt");
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
            System.out.println("\t Delete Account Record of login ID : " + mailID + "is successfully");
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }
    //--------------------------------Edit single data in a file--------------------------------------------------------
    public void editMailData(String mailID, String editfield, String updatedData){
        String refNo, mailType, toName, fromName, address, note, date, record;
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        try{
            //open mail details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDb = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDb));

            //Load data line by line
            while( ( record = br.readLine() ) != null ) {
                StringTokenizer mailDetail = new StringTokenizer(record,",");
                ;
                refNo = mailDetail.nextToken();
                mailType = mailDetail.nextToken();
                toName = mailDetail.nextToken();
                fromName = mailDetail.nextToken();
                address = mailDetail.nextToken();
                note = mailDetail.nextToken();
                date = mailDetail.nextToken();

                //create mailRec Objects by reading data of the file
                PostalMail mailRec = new PostalMail(refNo,MailType.valueOf(mailType),toName,fromName,address,note,formatter.parse(date));
                //Check whether that the mail record to be edited... if it is then replace that record field according to given data
                if(refNo.equals(mailID)){
                    switch (editfield) {
                        case "mailType":
                            mailRec.setMailType(MailType.valueOf(updatedData));
                            break;
                        case "toName":
                            mailRec.setToName(updatedData);
                            break;
                        case "fromName":
                            mailRec.setFromName(updatedData);
                            break;
                        case "address":
                            mailRec.setAddress(updatedData);
                            break;
                        case "note":
                            mailRec.setNote(updatedData);
                            break;
                        case "date":
                            mailRec.setDate(formatter2.parse(updatedData));
                            break;
                        default:
                            System.out.println("Invalid Editfield");
                    }
                }
                // add mailRec object to the temporary file
                bw.write(mailRec.toString());
                bw.flush();
                bw.newLine();
            }
            br.close();
            bw.close();
            db.delete();
            tempDb.renameTo(db);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error :" + e);
        }catch (IOException e){
            System.out.println("Error :" + e);
        }
    }
}
