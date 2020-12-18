package Model;

import java.time.LocalTime;
import java.time.LocalDate;


public  class  Visitor extends Person{




    private LocalDate date;
    private LocalTime inTime;
    private LocalTime outTime;
    private String note;


    private static int visitorCounter;




    //this constructor valid when creating a visitor by admin and receptionist
    public Visitor(String name, String phone, String nIC,LocalDate date,LocalTime inTime,LocalTime outTime,String note) {
        super(name, phone, nIC);
        this.setDate(java.time.LocalDate.now());
        this.setInTime(java.time.LocalTime.now());
        this.setOutTime(java.time.LocalTime.now());
        this.setNote(note);
        visitorCounter++;

    }

    //when no note is added
    public Visitor(String name, String phone, String nIC){
        super(name, phone, nIC);
        visitorCounter++;
    }

    public Visitor(){
        super("","","");
    }



    public void setDate(LocalDate date){
        this.date =LocalDate.now();
    }

    public void setInTime(LocalTime inTime) {
        this.inTime=LocalTime.now();
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


    public LocalDate getDate(){
        return this.date;
    }

    public LocalTime getInTime(){
        return this.inTime;
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
        return this.getName()+ "," + this.getPhone()+ "," + this.getNIC()+ "," + this.getDate() + "," + this.getInTime() + "," + this.getOutTime()+","+this.getNote();
    }

}
