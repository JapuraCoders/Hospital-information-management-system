package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class PostalMail {

    private String refNo;
    private String mailType;//add a new attribute to display extends classes.
                            // because extended classes also have these attributes nothing else.
                            // mail type means either received mail or dispatched mail.
    private String toName;
    private String fromName;
    private String address;
    private String note;
    //private document;put here document data type and update constructor,getters setters and toString method
    private LocalDateTime date;//assign here current date


    //constructer
    protected PostalMail(String refNo,String mailType,String toName,String fromName,String address,String note,LocalDateTime date){
        this.setRefNo(refNo);
        this.setMailType(mailType);
        this.setToName(toName);
        this.setFromName(fromName);
        this.setAddress(address);
        this.setNote(note);
        this.setDate(date);
    }


    //setters
    public void setRefNo(String refNo){
        this.refNo=refNo;
    }
    public void setMailType(String mailType){this.mailType=mailType; }
    public void setToName(String toName){
        this.toName=toName;
    }
    public void setFromName(String fromName){
        this.fromName=fromName;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setNote(String note){
        this.note=note;
    }
    public void setDate(LocalDateTime date){
        this.date=date;
    }


    //getters
    public String getRefNo(){return this.refNo; }
    public String getMailType(){
        return this.mailType;
    }
    public String getToName(){
        return this.toName;
    }
    public String getFromName(){
        return this.fromName;
    }
    public String getAddress(){
        return this.note;
    }
    public LocalDateTime getDate(){
        return this.date;
    }


    @Override
    public String toString(){
        return getRefNo()+getMailType()+"\n"+getToName()+"\n"+getFromName()+"\n"+"\n"+getAddress()+"\n"+getDate();
    }


}

