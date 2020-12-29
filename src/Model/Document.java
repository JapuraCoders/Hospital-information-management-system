package Model;

import java.io.*;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class Document {
    private String documentID;
    private String storageFolder;

    public Document(String documentID,String storageFolder){
        this.setDocumentID(documentID);
        this.setStorageFolder(storageFolder);
    }
    //setters
    public void setDocumentID(String documentID){
        this.documentID = documentID;
    }
    public void setStorageFolder(String storageFilePath){
        this.storageFolder = storageFilePath;
    }

    //getters
    public String getDocumentID(){
        return this.documentID;
    }
    public String getStorageFolder(){
        return this.storageFolder;
    }

    public void addNewDocument(String inputFilepath) throws IOException {
        try{
            //Loading an existing document
            File file = new File(inputFilepath);
            PDDocument document = PDDocument.load(file);

            System.out.println("PDF loaded");

            //Saving the document
            document.save("Files\\" + this.getStorageFolder() + "\\" + this.getDocumentID());

            //Closing the document
            document.close();
        }
        catch (IOException e){
            System.out.println("Error : " + e);
        }
    }

    public void createReport(String text, String reportType)throws IOException{
        try{
            String reportTemplate = "";
            switch (reportType){
                case "LoginReport":
                    reportTemplate = "Files\\ReportTemplate\\LoginReport.pdf";
                    break;
            }
            //Loading an existing document
            File file = new File(reportTemplate);
            PDDocument document = PDDocument.load(file);

            //Retrieving the pages of the document
            PDPage page = document.getPage(1);
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            //Begin the Content stream
            contentStream.beginText();

            //Setting the font to the Content stream
            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);

            //Setting the position for the line
            contentStream.newLineAtOffset(25, 500);

            //String text = "This is the sample document and we are adding content to it.";

            //Adding text in the form of string
            contentStream.showText(text);

            //Ending the content stream
            contentStream.endText();

            System.out.println("Content added");

            //Closing the content stream
            contentStream.close();

            //Saving the document
            document.save(new File("Files\\" + this.getStorageFolder() + "\\" + this.getDocumentID()));

            //Closing the document
            document.close();
        }
        catch (IOException e){
            System.out.println("Error when creating report: " + e);
        }
    }
    @Override
    public String toString(){
        return this.getDocumentID() + "," + this.getStorageFolder();
    }
}
