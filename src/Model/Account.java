package Model;

import java.io.IOException;

public class Account {
    private String accountID;
    private String password;
    private Image image;
    private UserType userType;
    private User user;
    private static int accountCounter = 0; //static counter variable

    public Account(){
        this.setAccountID("");
        this.setPassword("");
    }

        //this constructor valid when creating a user by admin
        public Account(UserType userType, User user){
            this.setUser(user);
            this.setUserType(userType);
            this.setAccountID(accountIDGenerator());
            this.setPassword(defaultPassword());
            this.setImage(new Image(520,520,"UserPhotos",this.getAccountID()));

            accountCounter++;
            this.image.addNewImage(defaultImage());
        }

        //these constructors valid when patient create own account
        public Account(String password, Image image, String imagePath, UserType userType, User user){
            this.setAccountID(accountIDGenerator());
            this.setPassword(password);
            this.setImage(image);
            this.setUser(user);
            this.setUserType(userType);

            accountCounter++;
            this.image.addNewImage(imagePath);
        }
        //this constructor valid when patient did not add a image
    public Account(String password, User user, UserType userType){
        this.setAccountID(accountIDGenerator());
        this.setPassword(password);
        this.setImage(new Image(520,520,"Files\\UserPhotos",this.getAccountID()));
        this.setUser(user);
        this.setUserType(userType);

        accountCounter++;
        this.image.addNewImage(defaultImage());
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
            String accountType = "";
            int accountCount = 0;
        try{
            //int accountNo = this.getAccountCounter();
            String thisAccountUser = String.valueOf(this.getUserType());
            if (thisAccountUser.equals("ADMIN")){
                AccountRecord adminRecord = new AccountRecord("Files\\Details\\AdminData.txt");
                accountCount = adminRecord.viewAllAccounts().size();
                accountType = "AD";
            }
            else if (thisAccountUser.equals("MEDICALOFFICER")){
                AccountRecord medOfficerRecord = new AccountRecord("Files\\Details\\MedicalOfficerData.txt");
                accountCount = medOfficerRecord.viewAllAccounts().size();
                accountType = "MED";
            }
            else if (thisAccountUser.equals("RECEPTIONIST")){
                AccountRecord receptionistRecord = new AccountRecord("Files\\Details\\ReceptionistData.txt");
                accountCount = receptionistRecord.viewAllAccounts().size();
                accountType = "RE";
            }
            else if (thisAccountUser.equals("PATIENT")){
                AccountRecord patientRecord = new AccountRecord("Files\\Details\\PatientData.txt");
                accountCount = patientRecord.viewAllAccounts().size();
                System.out.println(accountCount);
                accountType = "PAT";
            }
            else{
                System.out.println("Cannot generate accountID cause of Invalid User Type");
            }
        }catch (IOException e){
            System.out.println("Error on AccountIDGenerator : " + e);
        }
            return String.format("%s%05d",accountType,accountCount);
    }

        public String defaultPassword(){
            return user.getNIC();
        }

        //If user did not add profile image then default image would add as profile image
        public String defaultImage(){
            String inputFileName = "Null";
            if(this.getUser().getGender()==Gender.MALE){
                inputFileName = "Files\\UserPhotos\\DefaultMale.jpg";
                //set DefaultMale image in UserPhotos folder for Male user
            }
            else if(this.getUser().getGender()==Gender.FEMALE){
                inputFileName = "Files\\UserPhotos\\DefaultFemale.jpg";
                //set DefaultMale image in UserPhotos folder for Female user
            }
            else{
                System.out.println("Cannot add defaultImage cause of Invalid Gender");
            }
            return inputFileName;
        }

        @Override
        public String toString(){
            return this.getAccountID() + "," + this.getPassword() + "," + this.getImage().toString() + "," + this.getUserType() + "," + this.getUser().toString();
        }
    }
