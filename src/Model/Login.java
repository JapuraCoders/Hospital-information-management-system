package Model;


import java.util.Date;

public class Login {
    private String loginID;
    private String typedUserName; //this user name will be entered by the user at login time
    private String typedPassword;
    private Date loginDateAndTime;
    private Boolean loginStatus;
    private static int loginCounter;

    public Login(){
        this.setLoginID(null);
        this.setTypedUserName(null);
        this.setTypedPassword(null);
        this.setLoginDateAndTime(null);
        this.setLoginStatus(null);
    }

    //this constructor will be use when passing old details
    public Login(String loginID, String typedUserName, String typedPassword,Date loginDateAndTime,boolean loginStatus){
        this.setLoginID(loginID);
        this.setTypedUserName(typedUserName);
        this.setTypedPassword(typedPassword);
        this.setLoginDateAndTime(loginDateAndTime);
        this.setLoginStatus(loginStatus);
    }
    //this constructor will be use when new login
    public Login (String typedUserName, String typedPassword,Date loginDateAndTime){
        this.setLoginID(loginIDGenerator());
        this.setTypedUserName(typedUserName);
        this.setTypedPassword(typedPassword);
        this.setLoginDateAndTime(loginDateAndTime);
        this.setLoginStatus(false);
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
    public void setLoginDateAndTime(Date loginDateAndTime){
        this.loginDateAndTime = loginDateAndTime;
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
    public Date getLoginDateAndTime(){
        return this.loginDateAndTime;
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

        String generatedLoginID;
        int loginNumber;

        loginNumber = this.getLoginCounter();

        generatedLoginID = String.format("#%05d", loginNumber);
        loginCounter++;

        return generatedLoginID;
    }

    @Override
    public String toString(){
        return this.getLoginID() + "," + this.getTypedUserName() + "," + this.getTypedPassword() + "," + this.getLoginDateAndTime() + "," + this.getLoginStatus();
    }

}
