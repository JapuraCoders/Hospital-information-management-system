package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    private int height;
    private int width;
    private String imageID;
    private String storageFolderName;
    BufferedImage image = null;

    public Image(int height, int width, String storageFolderName, String imageID){
        this.setHeight(height);
        this.setWidth(width);
        this.setStorageFolderName(storageFolderName);
        this.setImageID(imageID);
    }

    // setters
    public void setHeight(int height){
        this.height = height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public void setImageID(String imageID){
        this.imageID=imageID;
    }
    public void setStorageFolderName(String storageFolderName){
        this.storageFolderName = storageFolderName;
    }

    //getters
    public int getHeight(){
        return this.height;
    }
    public int getWidth(){
        return this.width;
    }
    public String getImageID(){
        return this.imageID;
    }
    public String getStorageFolderName(){
        return this.storageFolderName;
    }

    //add new image method
    public void addNewImage(String inputFilename) {

        try {
            File input = new File(inputFilename); // image file path
            image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(input);

            File save = new File("Files\\"+ this.getStorageFolderName() + "\\" + this.getImageID());//output file path
            ImageIO.write(image,"jpg", save);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void openImage(){
       try{
           Desktop.getDesktop().open(new File("Files\\"+ this.getStorageFolderName() +"\\"+ this.getImageID()));
       }
       catch (Exception e){
           System.out.println("Error : " + e);
       }
    }

    @Override
    public String toString(){
        return this.getHeight() + "," + this.getWidth() + "," + this.getStorageFolderName() + this.getImageID();
    }
}