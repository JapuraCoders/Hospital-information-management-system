package Model;

public enum UserType {

    ADMIN("Admin",1),
    MEDICALOFFICER("MedicalOfficer)",2),
    RECEPTIONIST("Receptionist",3),
    PATIENT("Patient",4);

    String value;
    int code;

    UserType(String value, int code){
        this.value = value;
        this.code = code;
    }
}
