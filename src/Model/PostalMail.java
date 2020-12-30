package Model;

import java.time.LocalDateTime;
import java.util.Date;

public class PostalMail {

    private String refNo;
    private MailType mailType;//add a new attribute to display extends classes. because extended classes also have these attributes nothing else.// mail type means either received mail or dispatched mail.
    private String toName;
    private String fromName;
    private String address;
    private String note;
    private Document document; //put here document data type and update constructor,getters setters and toString method
    private Date date;//assign here current date

    public PostalMail(){
        this.setRefNo(null);
    }

    //constructer
    public PostalMail(String refNo,MailType mailType,String toName,String fromName,String address,String note,Date date){
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
    public void setMailType(MailType mailType){this.mailType=mailType; }
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
    public void setDate(Date date){
        this.date=date;
    }


    //getters
    public String getRefNo(){return this.refNo; }
    public MailType getMailType(){
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
    public Date getDate(){
        return this.date;
    }


    @Override
    public String toString(){
        return getRefNo()+","+getMailType()+","+getToName()+","+getFromName()+","+getAddress()+","+getDate();
    }


}

