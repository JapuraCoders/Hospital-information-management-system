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
    }































