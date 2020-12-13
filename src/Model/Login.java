package Model;

import java.sql.Time;
import java.util.Date;

public class Login {
    private String typedUserName; //this user name will be entered by the user at login time
    private String typedPassword;
    private Date loginDate;
    private Time loginTime;
    private Boolean loginStatus;

    public Login (String typedUserName, String typedPassword, Date loginDate, Time loginTime, Boolean loginStatus){
        this.setTypedUserName(typedUserName);
        this.setTypedPassword(typedPassword);
        this.setLoginDate(loginDate);
        this.setLoginTime(loginTime);
        this.setLoginStatus(loginStatus);
    }

    //setters
    public void setTypedUserName (String typedUserName){
        this.typedUserName = typedUserName;
    }
    public void setTypedPassword (String typedPassword){
        this.typedPassword = typedPassword;
    }
    public void setLoginDate(Date loginDate){
        this.loginDate = loginDate;
    }
    public void setLoginTime (Time loginTime){
        this.loginTime = loginTime;
    }
    public void setLoginStatus(Boolean loginStatus){
        this.loginStatus = loginStatus;
    }
    //getters
    public String getTypedUserName(){
        return this.typedUserName;
    }
    public String getTypedPassword(){
        return this.typedPassword;
    }
    public Date getLoginDate(){
        return this.loginDate;
    }
    public Time getLoginTime(){
        return this.loginTime;
    }
    public Boolean getLoginStatus(){
        return this.loginStatus;
    }

    @Override
    public String toString(){
        return this.getTypedUserName() + "\n" + this.getTypedPassword() + "\n" + this.getLoginDate() + "\n" + this.getLoginTime() + "\n" + this.getLoginStatus();
    }

}
