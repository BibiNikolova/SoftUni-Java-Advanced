package streamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String pathIn = "E:\\Java\\Advanced\\src\\streamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "E:\\Java\\Advanced\\src\\streamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream in = new FileInputStream(pathIn);
        FileOutputStream out = new FileOutputStream(pathOut);

        int oneByte = in.read();
        while (oneByte >= 0) {
            if (oneByte == 32 || oneByte == 10) {
                out.write(oneByte);
            } else {
                String digit = String.valueOf(oneByte);
                for (int i = 0; i < digit.length(); i++) {
                    out.write(digit.charAt(i));
                }
            }
            oneByte = in.read();
        }
    }
}
