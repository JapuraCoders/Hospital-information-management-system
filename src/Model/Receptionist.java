package Model;

import java.util.Date;

public abstract class Receptionist extends Staff{
    protected Receptionist(String name, String phone, String nIC, String userName, Gender gender, Date dOB, String address, MaritalStatus maritalStatus, String staffID, String staffEmailAddress, Date dateJoining, Image staffPhotograph) {
        super(name, phone, nIC, userName, gender, dOB, address, maritalStatus, staffID, staffEmailAddress, dateJoining, staffPhotograph);
    }

    //Methods
    public abstract Image defaultStaffPhotograph();
}
