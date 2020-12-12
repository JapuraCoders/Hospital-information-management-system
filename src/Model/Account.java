package Model;

public class Account {
    private String accountID;
    private String password;
    private Image image;
    private User user;
    private UserType userType;
    private static int accountCounter = 0; //static counter variable

    //default constructor of an account can be create only for a Patient type user
    public Account(){
        this.setAccountID(accountIDGenerator());
        this.setPassword(defaultPassword());
        this.setImage(defaultImage());
        this.setUser(new Patient());
        this.setUserType(UserType.PATIENT);

        accountCounter++;
    }

    public Account(String password, Image image, User user, UserType userType){
        this.setAccountID(accountIDGenerator());
        this.setPassword(password);
        this.setImage(image);
        this.setUser(user);
        this.setUserType(userType);

        accountCounter++;
    }

    //setters
    public void setAccountID(String accountID){
        this.accountID = accountID;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setImage(Image image){
        this.image = image;
    }
    public void setUserType(UserType userType){
        this.userType = userType;
    }
    public void setAccountCounter(int accountCounter){
        Account.accountCounter = accountCounter;
    }
    public void setUser(User user){
        this.user=user;
    }

    //getters
    public String getAccountID(){
        return this.accountID;
    }
    public String getPassword(){
        return this.password;
    }
    public Image getImage(){
        return this.image;
    }
    public UserType getUserType(){
        return this.userType;
    }
    public int getAccountCounter(){
        return Account.accountCounter;
    }
    public User getUser(){
        return this.user;
    }

    //methods
    public String accountIDGenerator(){
        String accountType = "NULL";
        int accountNo = this.getAccountCounter();
        UserType thisAccountUser = this.getUserType();
        if (thisAccountUser==UserType.ADMIN){
            accountType = "AD";
        }
        else if (thisAccountUser==UserType.MEDICALOFFICER){
            accountType = "MED";
        }
        else if (thisAccountUser==UserType.RECEPTIONIST){
            accountType = "RE";
        }
        else if (thisAccountUser==UserType.PATIENT){
            accountType = "PAT";
        }
        else{
            System.out.println("Cannot generate accountID cause of Invalid User Type");
        }
        return accountType + String.valueOf(accountNo);
    }

    public String defaultPassword(){
        return user.getNIC();
    }

    public Image defaultImage(){
        String inputFileName = "Null";
        if(this.getUser().getGender()==Gender.MALE){
            inputFileName = "Files\\UserPhotos\\DefaultMale";
            //set DefaultMale image in UserPhotos folder for Male user
        }
        else if(this.getUser().getGender()==Gender.FEMALE){
           inputFileName = "Files\\UserPhotos\\DefaultFemale";
            //set DefaultMale image in UserPhotos folder for Female user
        }
        else{
            System.out.println("Cannot add defaultImage cause of Invalid Gender");
        }
        return new Image(520,520,inputFileName,"UserPhotos",this.getAccountID());
    }

    @Override
    public String toString(){
        return this.getAccountID() + "\n" + this.getPassword() + "\n" + this.getImage() + "\n" + this.getUser() + "\n" + this.getUserType();
    }

}
