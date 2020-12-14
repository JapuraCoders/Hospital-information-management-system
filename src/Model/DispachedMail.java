package Model;

import java.util.Date;

public class DispachedMail extends PostalMail {

    public DispachedMail(String toName, String fromName, String refNo, String address, String note, Date date){
        super(toName,fromName,refNo,address,note,date);
    }

    @Override
    public String toString(){ return super.toString();}

}
