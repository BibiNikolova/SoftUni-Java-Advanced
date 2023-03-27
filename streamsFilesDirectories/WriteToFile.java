package streamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {

        String pathIn = "E:\\Java\\Advanced\\src\\streamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "E:\\Java\\Advanced\\src\\streamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> forbidden = new HashSet<>();
        Collections.addAll(forbidden, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(pathIn);
             FileOutputStream out = new FileOutputStream(pathOut)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                char byteAsChar = (char) oneByte;
                if (!forbidden.contains(byteAsChar)) {
                    out.write(oneByte);
                }
                oneByte = in.read();
            }
        } catch (
                IOException e) {
            System.out.println("Sorry");
        }
    }
}
