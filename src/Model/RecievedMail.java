package Model;

import java.util.Date;

public class RecievedMail extends PostalMail {

    public RecievedMail(String toName, String fromName, String refNo, String address, String note, Date date){
        super(toName,fromName,refNo,address,note,date);
    }

    @Override
    public String toString(){
        return super.toString();
    }

}
