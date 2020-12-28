package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

        ArrayList<String> dbTypeList = new ArrayList<>();
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

}
