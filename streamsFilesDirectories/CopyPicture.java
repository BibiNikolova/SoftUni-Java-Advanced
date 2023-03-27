package streamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/foxy.JPG");
        FileOutputStream fos = new FileOutputStream("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/foxyCopy.JPG");

        byte[] buffer = new byte[1024];
        while(fis.read(buffer) >= 0){
            fos.write(buffer);
        }

        fis.close();
        fos.close();
    }
}
