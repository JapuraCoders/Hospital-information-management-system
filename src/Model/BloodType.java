package Model;

enum BloodType {
    A_PLUS("A+", 1),
    A_MINUS("A-",2),
    B_PLUS("B+", 3),
    B_MINUS("B-",4 ),
    O_PLUS("O+",5 ),
    O_MINUS("O-", 6),
    AB_PLUS("AB+",7 ),
    AB_MINUS("AB-",8 );

    String value;
    int code;


    BloodType(String value, int code) {
        this.value = value;
        this.code = code;
    }
    void BloodInformation() {

        switch (code) {
            case 1:
                System.out.println("Blood Type A+");
                break;
            case 2:
                System.out.println("Blood Type A-");
                break;
            case 3:
                System.out.println("Blood Type B+");
                break;
            case 4:
                System.out.println("Blood Type B-");
                break;
            case 5:
                System.out.println("Blood Type O+");
                break;
            case 6:
                System.out.println("Blood Type O-");
                break;
            case 7:
                System.out.println("Blood Type AB+");
                break;
            case 8:
                System.out.println("Blood Type AB-");
                break;


            default:
                System.out.println("There is no code for the type you write !!");
        }
    }



}





















