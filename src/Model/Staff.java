package Model;
import java.util.Date;

public abstract class Staff extends User{
    protected String staffID;
    protected String staffEmailAddress;
    protected Date dateJoining;
    protected Image staffPhotograph;

    public Staff(String name, String phone, String nIC, Gender gender, Date dOB, String address, MaritalStatus maritalStatus, String staffID, String staffEmailAddress, Date dateJoining, Image staffPhotograph) {
        super(name, phone, nIC, gender, dOB, address, maritalStatus);
        this.staffID = staffID;
        this.staffEmailAddress = staffEmailAddress;
        this.dateJoining = dateJoining;
        this.staffPhotograph = staffPhotograph;
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
    public void setStaffPhotograph (Image staffPhotograph){
        this.staffPhotograph = staffPhotograph;
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
    public Image getStaffPhotograph(){
        return this.staffPhotograph;
    }

    //Methods
    public abstract Image defaultStaffPhotograph();

    public String toString(){
        return super.toString() + "\n" + this.getStaffID() + "\n" + this.getStaffEmailAddress() + "\n" + this.getDateJoining() + this.getStaffPhotograph();
    }

}