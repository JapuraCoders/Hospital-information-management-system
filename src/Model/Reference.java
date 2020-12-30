package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Reference {
    private  String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public Reference(String fileName) {
        this.setFileName(fileName);
    }


    public List<String> view() throws IOException, NoSuchElementException {
        String line;

        List<String> dbTypeList = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader( new FileReader(this.getFileName()) );

            while( ( line = br.readLine() ) != null ) {

                dbTypeList.add(line);
            }
            br.close();
        }
        catch (IOException | NoSuchElementException e){
            System.out.println("Error : " + e);
        }
        return dbTypeList;
    }
    public void add(String referenceField){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(this.getFileName(),true));
            //write on file newly added referanceField
            bw.write(referenceField);
            bw.flush();
            bw.newLine();
            bw.close();
            System.out.println("\"" +referenceField + "\" record added to " + this.getFileName() + "successfully");
        }
        catch (IOException e){
            System.out.println("An error occurred : " + e);
            e.getStackTrace();
        }
    }
    public void dlt(String referenceField){
        try {
            String record, ID = referenceField;

            //open Reference details file for read the data
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
            System.out.println("\t Delete Reference Record : " + referenceField + "is successfully");
        }
        catch (IOException e){
            System.out.println("Error : "+e);
        }
    }

}
