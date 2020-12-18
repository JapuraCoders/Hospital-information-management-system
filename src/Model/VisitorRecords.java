package Model;

import java.io.*;
import java.time.LocalDate;
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

    //This will return all the visitor details
    public List<String> viewAllRecords() throws IOException, NoSuchElementException {
        String name,phone,nIC,date,inTime,outTime,note,record,visitorRecord;
        List<String> visitorRecordList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            while( ( record = br.readLine() ) != null ) {

                StringTokenizer visitorDetail = new StringTokenizer(record,",");

                name = visitorDetail.nextToken();
                phone = visitorDetail.nextToken();
                nIC =visitorDetail.nextToken();
                date = visitorDetail.nextToken();
                inTime = visitorDetail.nextToken();
                outTime = visitorDetail.nextToken();
                note = visitorDetail.nextToken();

                visitorRecord = "\nName : " + name + "\nPhone number : " + phone + "\nNIC : " +nIC + "\nDate : " + date + "\nInTime : " + inTime + "\nOutTime : " +outTime +  "\nNote : " + note+"\n----------------------";

                visitorRecordList.add(visitorRecord);
            }
            br.close();
        }
        catch (IOException e){
            System.out.println("Error : " + e);
        }
        catch (NoSuchElementException e){
            System.out.println("Error : " + e);
        }
        return visitorRecordList;
    }
public static void main(String []args)throws IOException{
        Visitor vis1=new Visitor("taniya","0987654","56789043", LocalDate.now(), LocalTime.now(),LocalTime.now(),"ggggggggggggg");
        Visitor vis2=new Visitor("Anne","9876654","456778990",LocalDate.now(),LocalTime.now(),LocalTime.now(),"yyyyyyyyyyyy");
        Visitor  vis3=new Visitor("ganiya","8976547","54321679",LocalDate.now(),LocalTime.now(),LocalTime.now(),"tttttttttt");

        Visitor [] visArray=new Visitor[4];

        visArray[0]=vis1;
        visArray[1]=vis2;
        visArray[2]=vis3;
        for( int  i=0;i<visArray.length; i++){
            String outputText=visArray[i].getName()+"|"+visArray[i].getPhone()+"|"+visArray[i].getNIC()+"|"+visArray[i].getDate()+"|"+visArray[i].getInTime()+"|"+visArray[i].getOutTime()+"|"+visArray[i].getNote();
            AddRecord("C:\\Users\\thiruthisara\\Desktop\\New folder (2)\\VisitorRecord.txt",outputText,true);
    }

}

    //add new visitor record
 public static void AddRecord(String fileName,String text,boolean append)throws IOException{
        File file1=new File(fileName);
        FileWriter fw=new FileWriter(file1,append);
        PrintWriter pw=new PrintWriter(fw);
        pw.println(text);
        pw.close();

 }
    //Delete visitor details according to nIC
    public void dlt(String nIC) throws IOException {
        try {
            String record, ID = nIC;

            File tempDB = new File("visitor_db_temp.txt");
            File db = new File(this.getFileName());

            BufferedReader br = new BufferedReader(new FileReader(db));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempDB));

            System.out.println("\t Delete Account Record of nIC : " + nIC);

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