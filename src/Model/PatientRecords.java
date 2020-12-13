package Model;

import java.io.*;
class PatientRecords
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addRecords() throws IOException
    {
        // Create or Modify a file for Database
        PrintWriter pw = new PrintWriter(new BufferedWriter(new
                FileWriter("patientRecords.txt",true)));
        String name, gender,address , bloodType,allergies , dob;
        int age;
        long telephoneNo;
        String s;
        boolean addMore = false;
        // Read Data
        do
        {
            System.out.print("\nEnter name: ");
            name = br.readLine();

            System.out.print("Gender: ");
            gender = br.readLine();

            System.out.print("Address: ");
            address = br.readLine();

            System.out.print("BloodType: ");
            bloodType = br.readLine();

            System.out.print("Allergies: ");
            allergies = br.readLine();

            System.out.print("Date of Birth (dd/mm/yy) : ");
            dob = br.readLine();

            System.out.print("Age: ");
            age = Integer.parseInt(br.readLine());

            System.out.print("Telephone No.: ");
            telephoneNo = Long.parseLong(br.readLine());
            // Print to File
            pw.println(name);
            pw.println(gender);
            pw.println(address);
            pw.println(bloodType);
            pw.println(allergies);
            pw.println(dob);
            pw.println(age);
            pw.println(telephoneNo);

            System.out.print("\nRecords added successfully !\n\nDo you want to add more records ? (y/n) : ");
            s = br.readLine();
            if(s.equalsIgnoreCase("y"))
            {
                addMore = true;
                System.out.println();
            }
            else
                addMore = false;
        }
        while(addMore);
        pw.close();
        showMenu();
    }
    public void readRecords() throws IOException
    {
        try
        {
            // Open the file
            BufferedReader file = new BufferedReader(new
                    FileReader("patientRecords.txt"));
            String name;
            int i=1;
            // Read records from the file
            while((name = file.readLine()) != null)
            {
                System.out.println("S.No. : " +(i++));
                System.out.println("-------------");
                System.out.println("\nName: " +name);
                System.out.println("Gender : "+file.readLine());
                System.out.println("Address : "+file.readLine());
                System.out.println("BloodType: "+file.readLine());
                System.out.println("Allergies: "+file.readLine());
                System.out.println("Date of Birth : "+file.readLine());
                System.out.println("Age: "+Integer.parseInt(file.readLine()));
                System.out.println("Tel. No.: "+Long.parseLong(file.readLine()));
                System.out.println();
            }
            file.close();
            showMenu();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("\nERROR : File not Found !!!");
        }
    }
    public void clear() throws IOException
    {
        // Create a blank file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new
                FileWriter("patientRecords.txt")));
        pw.close();
        System.out.println("\nAll Records cleared successfully !");
        for(int i=0;i<999999999;i++); // Wait for some time
        showMenu();
    }
    public void showMenu() throws IOException
    {
        System.out.print("1 : Add Records\n2 : Display Records\n3 : Clear All Records\n4 : Exit\n\nYour Choice : ");
        int choice = Integer.parseInt(br.readLine());
        switch(choice)
        {
            case 1:
                addRecords();
                break;
            case 2:
                readRecords();
                break;
            case 3:
                clear();
                break;
            case 4:
                System.exit(1);
                break;
            default:
                System.out.println("\nInvalid Choice !");
                break;
        }
    }
    public static void main(String args[]) throws IOException
    {
        PatientRecords call = new PatientRecords();
        call.showMenu();
    }
}