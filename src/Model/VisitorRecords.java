package Model;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class VisitorRecords {
    private String fileName;

    public VisitorRecords(String fileName){
        this.setFileName(fileName);
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }

    //------------------------------This will return all the visitor details----------------------------------------------
    public List<Visitor> viewAllLVisitorRecords() throws IOException, NoSuchElementException {
        String record;
        Visitor visitorRecord = new Visitor();
        SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        List<Visitor> visitorRecordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer visitorDetail = new StringTokenizer(record,",");

                visitorRecord.setName(visitorDetail.nextToken());
                visitorRecord.setPhone(visitorDetail.nextToken());
                visitorRecord.setNIC(visitorDetail.nextToken());
                visitorRecord.setDateAndTime(formatter.parse(visitorDetail.nextToken()));
                visitorRecord.setOutTime(LocalTime.parse(visitorDetail.nextToken()));
                visitorRecord.setNote(visitorDetail.nextToken());
                visitorRecordList.add(visitorRecord);
            }
            br.close();
        }
        catch (IOException | NoSuchElementException | ParseException e){
            System.out.println("Error : " + e);
        }
        return visitorRecordList;
    }



    //--------------------------------------Add new visitor record to the file--------------------------------------------
    public void add(Visitor visitor) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));
            //write on file according to Object's toString format
            bw.write(visitor.toString());
            bw.flush();
            bw.newLine();
            bw.close();
            System.out.println("\"" + visitor.toString() + "\" record added to " + this.getFileName() + "successfully");
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }

    //--------------------------------Delete visitor details according to nic-----------------------------------------
    public void dlt(String nIC) throws IOException {
        try {
            String record, ID = nIC;

            //open Login details file for read the data
            File db = new File(this.getFileName());
            BufferedReader br = new BufferedReader(new FileReader(db));

            //create temporary file for write updated data
            File tempDB = new File("visitor_db_temp.txt");
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
            System.out.println("\t Delete Account Record of nic : " + nIC + "is successfully");
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }

    //--------------------------------Edit single data in a file--------------------------------------------------------
    public void editLoginData(String nNIC, String editfield, String updatedData) throws IOException{
        String  name,phone,nIC,dateAndTime,outTime,note, record;
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
                StringTokenizer visitorDetail = new StringTokenizer(record,",");

                name = visitorDetail.nextToken();
                phone = visitorDetail.nextToken();
                nIC =visitorDetail.nextToken();
                dateAndTime= visitorDetail.nextToken();
                outTime = visitorDetail.nextToken();
                note = visitorDetail.nextToken();
                //create VisRec Objects by reading data of the file
                Visitor visRec = new Visitor( name,phone,nIC,formatter.parse(dateAndTime),LocalTime.parse(outTime),note );
                //Check whether that the visitor record to be edited... if it is then replace that record field according to given data
                if(nIC.equals(nNIC)){
                    switch (editfield) {
                        case "name":
                            visRec.setName(updatedData);
                            break;
                        case "phone":
                            visRec.setPhone(updatedData);
                            break;
                        case "dateAndTime":
                            visRec.setDateAndTime(formatter.parse(updatedData));
                            break;
                        case "outTime":
                            visRec.setOutTime(LocalTime.parse(updatedData));
                            break;
                        case "note":
                            visRec.setNote(updatedData);
                            break;
                        default:
                            System.out.println("Invalid Editfield");
                    }
                }
                // add loginRec object to the temporary file
                bw.write(visRec.toString());
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