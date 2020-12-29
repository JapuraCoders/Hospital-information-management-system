package Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Staff extends User{
    private String staffID;
    private String staffEmailAddress;
    private Date dateJoining;
    private Image staffPhotograph;
    private Document cv;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public Staff(String name,String phone, String nIC, String userName, Gender gender, Date dOB, String address, MaritalStatus maritalStatus,String staffID,String staffEmailAddress,Date dateJoining,Image staffPhotograph) {
        super(name, phone, nIC, userName, gender, dOB, address, maritalStatus);
        this.setStaffID(staffID);
        this.setStaffEmailAddress(staffEmailAddress);
        this.setDateJoining(dateJoining);
        this.setStaffPhotograph(staffPhotograph);
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

    @Override
    public String toString(){
        return super.toString() + "," + this.getStaffID() + "," + this.getStaffEmailAddress() + "," + this.getDateJoining() + "," + this.getStaffPhotograph();
    }

}