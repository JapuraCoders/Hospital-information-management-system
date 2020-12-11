package Model;
import java.util.Date;

public abstract class Staff extends User{
    protected String staffID;
    protected String staffEmailAddress;
    protected Date dateJoining;

    protected Staff(String staffID,String staffEmailAddress,Date dateJoining) {
        super();
        this.setStaffID(staffID);
        this.setStaffEmailAddress(staffEmailAddress);
        this.setDateJoining(dateJoining);
    }
    //setters
    public void setStaffID (String staffID){
        this.staffID = staffID;
    }
    public void setStaffEmailAddress (String staffEmailAddress){
        this.staffEmailAddress = staffEmailAddress;
    }
    public void setDateJoining (Date dateJoining){
        this.dateJoining = dateJoining;
    }
    //getters
    public String getStaffID(){
        return this.staffID;
    }
    public String getStaffEmailAddress(){
        return this.staffEmailAddress;
    }
    public Date getDateJoining(){
        return this.dateJoining;
    }

    public String toString(){
        return super.toString() + "\n" + this.getStaffID() + "\n" + this.getStaffEmailAddress() + "\n" + this.getDateJoining();
    }

}