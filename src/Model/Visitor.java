package Model;

import java.util.Date;
import java.sql.Time;


public  class  Visitor extends Person{
    private Date date;
    private Time inTime;
    private Time outTime;
    private String note;
    private VisitorRecords visitorRecords;

    public Visitor(String name, String phone, String nIC,Date date,Time inTime,Time outTime,String note) {
        super(name, phone, nIC);
        this.setDate(date);
        this.setInTime(inTime);
        this.setOutTime(outTime);
        this.setNote(note);
    }

    public void setDate(Date date){
        this.date=date;
    }

    public void setInTime(Time inTime) {
        this.inTime=inTime;
    }

    public void setOutTime(Time outTime) {
        this.outTime=outTime;
    }

    public void setNote(String note){
        this.note=note;
    }

    public void setVisitorRecords(VisitorRecords visitorRecords){
        this.visitorRecords=visitorRecords;
    }

    public Date getDate(){
        return this.date;
    }

    public Time getInTime(){
        return this.inTime;
    }

    public Time getOutTime(){
        return this.outTime;
    }

    public String getNote(){
        return this.note;

    }
    public VisitorRecords getVisitorRecords(){
        return this.visitorRecords;
    }



}
