package Model;

import java.time.LocalTime;
import java.util.Date;


public  class  Visitor extends Person{




    private Date dateAndTime;

    private LocalTime outTime;
    private String note;


    private static int visitorCounter;

    public Visitor(){
        super(null,null,null);
        this.setDateAndTime(null);
        this.setOutTime(null);
        this.setNote(null);
    }


    //this constructor valid when creating a visitor by admin and receptionist
    public Visitor(String name, String phone, String nIC,Date dateAndTime,LocalTime outTime,String note) {
        super(name, phone, nIC);

        this.setDateAndTime(dateAndTime);
        this.setOutTime(java.time.LocalTime.now());
        this.setNote(note);
        visitorCounter++;

    }

    //when no note is added
    public Visitor(String name, String phone, String nIC){
        super(name, phone, nIC);
        visitorCounter++;
    }




    public void setDateAndTime(Date dateAndTime){
        this.dateAndTime =dateAndTime;
    }


    public void setOutTime(LocalTime outTime) {
        this.outTime=LocalTime.now();
    }

    public void setNote(String note){
        this.note=note;
    }
    public void setVisitorCounter(int visitorCounter){
        Visitor.visitorCounter = visitorCounter;
    }


    public Date getDateAndTime(){
        return this.dateAndTime;
    }



    public LocalTime getOutTime(){
        return this.outTime;
    }

    public String getNote(){
        return this.note;

    }
    public int getVisitorCounter(){
        return Visitor.visitorCounter;
    }
    @Override
    public String toString(){
        return this.getName()+ "," + this.getPhone()+ "," + this.getNIC()+ "," + this.getDateAndTime()   + "," + this.getOutTime()+","+this.getNote();
    }

}


