package streamsFilesDirectories;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        course.name = "Java Advanced September 2022";
        course.numberOfStudents = 250;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/streamsFilesDirectories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/courses.ser"));

        output.writeObject(course); //serialize -> write to file

        Course courseFromFile = (Course) input.readObject(); //deserialize, -> read from file
        System.out.println(courseFromFile.numberOfStudents);
        System.out.println(courseFromFile.name);
    }
}
