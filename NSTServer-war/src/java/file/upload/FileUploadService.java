/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file.upload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author MilicaJelica
 */
public class FileUploadService {

    public static void sacuvajFajl(UploadedFile file, String directoryPath) {
        OutputStream output = null;
        InputStream input = null;
        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            output = new FileOutputStream(directoryPath + "//" + file.getFileName());
            input = file.getInputstream();
            int data = input.read();
            while (data != -1) {
                output.write(data);
                data = input.read();
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
