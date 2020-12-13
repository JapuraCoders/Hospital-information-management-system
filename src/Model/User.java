package Model;

import java.util.Date;

public abstract class User extends Person {
    protected String userName;
    protected Gender gender;
    protected Date dOB;
    protected String address;
    protected MaritalStatus maritalStatus;
    //protected Account account;

    protected User(String name,String phone, String nIC, String userName, Gender gender, Date dOB, String address, MaritalStatus maritalStatus/*, Account account*/){
        super (name, phone, nIC);
        this.setUserName(userName);
        this.setGender(gender);
        this.setDOB(dOB);
        this.setAddress(address);
        this.setMaritalStus(maritalStatus);
        //this.setAccount(account);
    }

    public User(String userName, Gender gender, Date dob, String address, MartialStatus martialStatus, Account account) {
        super();
    }

    //Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }
    public void setDOB(Date dOB){
        this.dOB = dOB;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setMaritalStus(MaritalStatus maritalStatus){
        this.maritalStatus = maritalStatus;
    }
    /*public void setAccount(Account account){
        this.account = account;
    }*/
    //getters
    public String getUserName(){
        return this.userName;
    }
    public Gender getGender(){
        return this.gender;
    }
    public Date getDOB(){
        return this.dOB;
    }
    public String getAddress(){
        return this.address;
    }
    public MaritalStatus getMaritalStatus(){
        return this.maritalStatus;
    }
    /*public Account getAccount(){
        return this.account;
    }*/
    @Override
    public String toString(){
        return super.toString() + "\n" + this.getUserName() + "\n" + this.getGender() + "\n" + this.getDOB() + "\n" + this.getAddress() + "\n" + this.getMaritalStatus()/* + "\n" + this.getAccount()*/;
    }
}
