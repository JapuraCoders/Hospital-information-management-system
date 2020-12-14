package Model;

public interface Record {
    public String view(); //This method could be use to view any record according to the given data
    public void add(); //This method could be use to add any record for a file
    public void edit(); //This method could be use to get and rewrite any record in a file
    public void dlt(); //This method could be use to delete any record in a file
}