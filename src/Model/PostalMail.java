package Model;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public abstract class PostalMail {
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    protected String toName;
    protected String fromName;
    protected String refNo;
    protected String address;
    protected String note;
    //protected document;
    protected Date date=calendar.getTime();


    //constructer
    protected PostalMail(String toName,String fromName,String refNo,String address,String note,Date date){
        this.setToName(toName);
        this.setFromName(fromName);
        this.setRefNo(refNo);
        this.setAddress(address);
        this.setNote(note);
        this.setDate(date);
    }


    //setters
    public void setToName(String toName){
        this.toName=toName;
    }
    public void setFromName(String fromName){
        this.fromName=fromName;
    }
    public void setRefNo(String refNo){
        this.refNo=refNo;
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
    public String getToName(){
        return this.toName;
    }
    public String getFromName(){
        return this.fromName;
    }
    public String getRefNo(){
        return this.refNo;
    }
    public String getAddress(){
        return this.note;
    }
    public Date getDate(){
        return this.date;
    }



    public String toString(){
        return getToName()+"\n"+getFromName()+"\n"+getRefNo()+"\n"+getAddress()+"\n"+getDate();
    }


}
