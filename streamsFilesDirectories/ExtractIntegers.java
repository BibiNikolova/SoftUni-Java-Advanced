package streamsFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String pathIn = "E:\\Java\\Advanced\\src\\streamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "E:\\Java\\Advanced\\src\\streamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter out = new PrintWriter(new FileOutputStream(pathOut));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                int myNum = scanner.nextInt();
                System.out.println(myNum);
                out.println(myNum);
            }
            scanner.next();
        }
        out.close();
    }
}
