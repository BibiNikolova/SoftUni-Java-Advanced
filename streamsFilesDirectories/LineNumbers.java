package streamsFilesDirectories;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));
        PrintWriter pw = new PrintWriter(new FileWriter("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
        String line = br.readLine();
        int counter = 1;
        while(line != null){
            pw.println(counter + ". " + line);
            counter++;
            line = br.readLine();
        }
        br.close();
        pw.close();
    }
}
