package Model;

import java.util.Date;

public class Complaint {
    private String complaintType;
    private String complaintBy;
    private Date date;
    private String description;
    private String actionTaken;
    private String note;


public Complaint(){
    this.setComplaintType(null);
    this.setComplaintBy(null);
    this.setDate(null);
    this.setDescription(null);
    this.setActionTaken(null);
    this.setNote(null);
}
    public Complaint(String complaintType,String complaintBy,Date date,String description,String actionTaken,String note) {
        this.setComplaintType(complaintType);
        this.setComplaintBy(complaintBy);
        this.setDate(date);
        this.setDescription(description);
        this.setActionTaken(actionTaken);
        this.setNote(note);

    }
    public void setComplaintType(String complaintType){
        this.complaintType=complaintType;
    }


    public void setComplaintBy(String complaintBy){
        this.complaintBy=complaintBy;}

    public void setDate(Date date)  {
        this.date=date;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setActionTaken(String actionTaken){
        this.actionTaken=actionTaken;
    }

    public void setNote(String note){
        this.note=note;
    }

    public String getComplaintType(){
        return this.complaintType;
    }

    public String getComplaintBy(){
        return this.complaintBy;
    }

    public Date getDate(){
        return this.date;
    }

    public String getDescription(){
        return this.description;
    }

    public String getActionTaken(){
       return this.actionTaken;
    }

    public String getNote(){
        return this.note;
    }

    @Override
    public String toString(){
        return this.getComplaintType()+ "," + this.getComplaintBy() + "," + this.getDate() + "," + this.getDescription() + "," + this.getActionTaken()+","+this.getNote();
    }

}
