package lostitemproject;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class Picture {
    private int pictureId;
    private String path;

    public Picture() {
    }

    public int getPictureId() {
        return pictureId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public Picture(String path) {
        
    }
    public static BufferedImage getImg(String imgName) throws InterruptedException{
        BufferedImage img = null;
        FTPClient ftpClient = new FTPClient();
        OutputStream ops = null;
        File downloadFile = new File("D:/Download/"+imgName);
        try {
            img = ImageIO.read(downloadFile);
            if(img==null){
                img = ImageIO.read(new File("D:/Download/expired"));
            }
        } catch (IOException ex) {
            System.out.println("image not found in local, downloading from server..");
            boolean isSuccess=true;
            while(isSuccess){
                try {
                    ftpClient.connect("93.188.160.226", 21);
                    ftpClient.login("u782694326", "kamkam1234");
                    ftpClient.enterLocalPassiveMode();
                    ftpClient.setFileType(FTP.BINARY_FILE_TYPE);            
                    ops = new BufferedOutputStream(new FileOutputStream(downloadFile));
                    if(ftpClient.retrieveFile(imgName, ops)){
                        System.out.println("Download image successful.");
                    }
                    ops.close();
                    img = ImageIO.read(downloadFile);
                    isSuccess=true;

                } catch (IOException exc) {
                    System.out.println("Full connection waiting..");
                    Thread.sleep(1000);
                    isSuccess=false;
                }
            }
        }
        

        return img;
        
    }
    
    public static String uploadImg(){
        FTPClient ftpClient = new FTPClient();
        InputStream inputStream = null;
        String pathStr=null;
        String destination=null;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            pathStr=chooser.getSelectedFile().toString();
            File picFile = new File(pathStr);
            try {
                ftpClient.connect("93.188.160.226", 21);
                ftpClient.login("u782694326", "kamkam1234");
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                inputStream = new FileInputStream(picFile);
                destination = UUID.randomUUID().toString();
                System.out.println("uploading...");
                if(ftpClient.storeFile(destination, inputStream)){
                    System.out.println("Upload image successful.");
                }else{
                    destination=null;
                }
                    
            }catch(IOException ex) {
                ex.printStackTrace();                
            }
            finally{
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return destination;
    }
}
