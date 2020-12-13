package Model;


import java.util.Date;


public class DispachedMailRecord extends PostalMail {

    private String fileName;

    //constructor
    public DispachedMailRecord(String toName, String fromName, String refNo, String address, String note, Date date, String fileName){
        super(toName,fromName,refNo,address,note,date);
        this.setFileName(fileName);
    }

    //setters

    public void setFileName(String fileName){
        this.fileName=fileName;
    }

    //getters
    public String getFileName(){
        return this.fileName;
    }

    @Override
    public String toString(){
        return super.toString()+"\n"+getFileName();
    }

    public String DispachedMailRecord(){
        return null;
    }

}