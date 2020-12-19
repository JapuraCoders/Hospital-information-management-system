package Model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Login {
    private String loginID;
    private String typedUserName; //this user name will be entered by the user at login time
    private String typedPassword;
    private LocalDate loginDate;
    private LocalTime loginTime;
    private Boolean loginStatus;

    private static int loginCounter = 0;

    public Login(){
        this.setLoginID(loginIDGenerator());
        this.setTypedUserName(typedUserName);
        this.setTypedPassword(typedPassword);
        this.setLoginDate(java.time.LocalDate.now());
        this.setLoginTime(java.time.LocalTime.now());
        this.setLoginStatus(false);

        loginCounter++;
    }

    //setters
    public void setLoginID(String loginID){
        this.loginID = loginID;
    }
    public void setTypedUserName (String typedUserName){
        this.typedUserName = typedUserName;
    }
    public void setTypedPassword (String typedPassword){
        this.typedPassword = typedPassword;
    }
    public void setLoginDate(LocalDate loginDate){
        this.loginDate = loginDate;
    }
    public void setLoginTime (LocalTime loginTime){
        this.loginTime = loginTime;
    }
    public void setLoginStatus(Boolean loginStatus){
        this.loginStatus = loginStatus;
    }
    public void setLoginCounter(int loginCounter){
        Login.loginCounter = loginCounter;
    }
    //getters
    public String getTypedUserName(){
        return this.typedUserName;
    }
    public String getTypedPassword(){
        return this.typedPassword;
    }
    public LocalDate getLoginDate(){
        return this.loginDate;
    }
    public LocalTime getLoginTime(){
        return this.loginTime;
    }
    public Boolean getLoginStatus(){
        return this.loginStatus;
    }
    public String getLoginID(){
        return this.loginID;
    }
    public int getLoginCounter(){
        return Login.loginCounter;
    }

    public String loginIDGenerator(){

        String date, time, loginNumber, generatedLoginID;

        date = String.valueOf(this.getLoginDate());
        time = String.valueOf(this.getLoginTime());
        loginNumber = String.valueOf(this.getLoginCounter());

        generatedLoginID = date + "|" + time + "|" +  loginNumber;

        return generatedLoginID;
    }


    @Override
    public String toString(){
        return this.getLoginID() + "," + this.getTypedUserName() + "," + this.getTypedPassword() + "," + this.getLoginDate() + "," + this.getLoginTime() + "," + this.getLoginStatus();
    }

}
