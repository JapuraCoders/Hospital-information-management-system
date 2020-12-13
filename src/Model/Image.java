package Model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    private int height;
    private int width;
    private String imageID;
    BufferedImage image = null;

    public Image(int height, int width, String inputFileName, String storageFolderName, String imageID){
        this.setHeight(height);
        this.setWidth(width);
        this.setImageID(imageID);

        //image process
        addImage(inputFileName);
        saveImage(storageFolderName,imageID);
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

    //add new image method
    public void addImage(String filename) {

        try {
            File input = new File(filename); // image file path
            image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
            image = ImageIO.read(input);
        } catch (IOException e) {
            System.out.println("Error" + e);
        }
    }

    //save image method
    public void saveImage(String folderName, String imageID){
        try {
            File save = new File("Files\\"+ folderName +"\\"+ imageID);//output file path
            ImageIO.write(image,"jpg", save);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    @Override
    public String toString(){
        return this.getHeight() + "\n" + this.getWidth() + "\n" + this.getImageID();
    }
}

