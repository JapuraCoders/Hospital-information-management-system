package Model;

public abstract class Person {
    protected String name;
    protected String phone;
    protected String nIC;

    protected Person(String name,String phone, String nIC){
        this.setName(name);
        this.setPhone(phone);
        this.setNIC(nIC);
    }

    //setters
    public void setName(String name){
            this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setNIC(String nIC){
        this.nIC = nIC;
    }
    //getters
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getNIC(){
        return this.nIC;
    }
    @Override
    public String toString(){
        return this.getName() + "\n" + this.getPhone() + "\n" + this.getNIC();
    }

}
