package Model;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class ComplaintRecord {
    private String fileName;

    public ComplaintRecord(String fileName){
        this.setFileName(fileName);
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }

    //------------------------------This will return all the complaint details----------------------------------------------
    public List<Complaint> viewAllComplaints() throws IOException, NoSuchElementException {
        String record;
        Complaint complaintRecord = new Complaint();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        List<Complaint> complaintRecordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer complaintDetail = new StringTokenizer(record,",");

                complaintRecord.setComplaintType(complaintDetail.nextToken());
                complaintRecord.setComplaintBy(complaintDetail.nextToken());
                complaintRecord.setDate(formatter.parse(complaintDetail.nextToken()));
                complaintRecord.setDescription(complaintDetail.nextToken());
                complaintRecord.setActionTaken(complaintDetail.nextToken());
                complaintRecord.setNote(complaintDetail.nextToken());



                complaintRecordList.add(complaintRecord);
            }
            br.close();
        }
        catch (IOException | NoSuchElementException | ParseException e){
            System.out.println("Error : " + e);
        }
        return complaintRecordList;
    }

    //-----------------------------Return Complain object by complainer-------------------------------------------------------
    public Complaint viewComplain(String complaintBy) throws IOException{
        String record;
        Complaint complaintRecord = new Complaint();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            System.out.println("\t Search Complain Record of ComplaintBy : " + complaintBy);

            //read line by line from the file
            while( ( record = br.readLine() ) != null ) {
                //separate data into tokens by ","
                StringTokenizer complaintDetail = new StringTokenizer(record,",");
                //Check whether that the login record looking for
                if( record.contains(complaintBy) ) {
                    //set data to complainRecordObject
                    complaintRecord.setComplaintType(complaintDetail.nextToken());
                    complaintRecord.setComplaintBy(complaintDetail.nextToken());
                    complaintRecord.setDate(formatter.parse(complaintDetail.nextToken()));
                    complaintRecord.setDescription(complaintDetail.nextToken());
                    complaintRecord.setActionTaken(complaintDetail.nextToken());
                    complaintRecord.setNote(complaintDetail.nextToken());
                }
            }
            br.close();
        }
        catch (IOException | ParseException | NullPointerException e){
            System.out.println("Error : "+e);
        }
        if(complaintRecord==null){
            System.out.println("There is no record contained " + complaintBy);
        }
        return complaintRecord;
    }

    //--------------------------------------Add new complain record to the file--------------------------------------------
    public void add(Complaint complaint) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));
            //write on file according to Object's toString format
            bw.write(complaint.toString());
            bw.flush();
            bw.newLine();
            bw.close();
            System.out.println("\"" + complaint.toString() + "\" record added to " + this.getFileName() + "successfully");
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }

    //--------------------------------Delete login details according to complaintBy-----------------------------------------
    public void dlt(String complaintBy) throws IOException {
        try {
            String record, ID = complaintBy;

            //open Login details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDB = new File("complaint_db_temp.txt");
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
            System.out.println("\t Delete Account Record of login ID : " + complaintBy + "is successfully");
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }

    //--------------------------------Edit single data in a file--------------------------------------------------------
    public void editComplaintData(String complaintBY, String editfield, String updatedData) throws IOException{
        String complaintType,complaintBy,date,description,actionTaken,note,record;
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try{
            //open Complaint details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDb = new File("temp.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDb));

            //Load data line by line
            while( ( record = br.readLine() ) != null ) {
                StringTokenizer complaintDetail = new StringTokenizer(record,",");

                complaintType = complaintDetail.nextToken();
                complaintBy = complaintDetail.nextToken();
                date =complaintDetail.nextToken();
                description = complaintDetail.nextToken();
                actionTaken = complaintDetail.nextToken();
                note=complaintDetail.nextToken();

                //create complaintRec Objects by reading data of the file
                Complaint complaintRec = new Complaint(complaintType,complaintBy,formatter.parse(date),description,actionTaken,note);
                //Check whether that the record to be edited... if it is then replace that record field according to given data
                if(complaintBy.equals(complaintBY)){
                    switch (editfield) {
                        case "complaintType":
                            complaintRec.setComplaintType(updatedData);
                            break;
                        case "complaintBy":
                            complaintRec.setComplaintBy(updatedData);
                            break;
                        case "date":
                            complaintRec.setDate(formatter.parse(updatedData));
                            break;
                        case "description":
                            complaintRec.setDescription(updatedData);
                            break;
                        case "actionTaken":
                            complaintRec.setActionTaken(updatedData);
                            break;
                        case "note":
                            complaintRec.setNote(updatedData);
                            break;
                        default:
                            System.out.println("Invalid Editfield");
                    }
                }
                // add complaintRec object to the temporary file
                bw.write(complaintRec.toString());
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
