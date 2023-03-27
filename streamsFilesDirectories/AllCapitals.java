package streamsFilesDirectories;

import java.io.*;
import java.util.Locale;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        BufferedReader br = new BufferedReader(new FileReader("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
        br.lines().forEach(line -> pw.println(line.toUpperCase()));
        br.close();
        pw.close();
    }
}
