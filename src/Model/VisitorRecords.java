package Model;

import java.io.*;
class
VisitorRecords
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addRecords() throws IOException
    {
        // Create or Modify a file for Database
        PrintWriter pw = new PrintWriter(new BufferedWriter(new
                FileWriter("Records.txt",true)));
        String name, nIC, note, inTime, date,outTime;
        long telephoneNo;
        String s;
        boolean addMore = false;
        // Read Data
        do
        {
            System.out.print("\nEnter name: ");
            name = br.readLine();

            System.out.print("nIC: ");
            nIC = br.readLine();

            System.out.print("note: ");
            note = br.readLine();

            System.out.print("inTime: ");
            inTime = br.readLine();

            System.out.print("outTime: ");
            outTime = br.readLine();



            System.out.print("Date(dd/mm/yy) : ");
            date = br.readLine();


            System.out.print("Telephone No.: ");
            telephoneNo = Long.parseLong(br.readLine());
            // Print to File
            pw.println(name);
            pw.println(nIC);
            pw.println(note);
            pw.println(inTime);
            pw.println(outTime);
            pw.println(date);
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
                    FileReader("Records.txt"));
            String name;
            int i=1;
            // Read records from the file
            while((name = file.readLine()) != null)
            {
                System.out.println("S.No. : " +(i++));
                System.out.println("-------------");
                System.out.println("\nName: " +name);
                System.out.println("nIC : "+file.readLine());
                System.out.println("note: "+file.readLine());
                System.out.println("inTime: "+file.readLine());
                System.out.println("outTime: "+file.readLine());
                System.out.println("Date: "+file.readLine());
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
                FileWriter("Records.txt")));
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
        VisitorRecords call = new VisitorRecords();
        call.showMenu();
    }
}
