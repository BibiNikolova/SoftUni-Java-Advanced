package streamsFilesDirectories;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NestedFolders {
    public static void main(String[] args) {

        File file = new File("E:\\Java\\Advanced\\src\\streamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        List<File> nestedFolders = new ArrayList<>();

        if (file.exists()) {
            if (file.isDirectory()) {
                nestedFolders.add(file);
                File[] files = file.listFiles();
                for (File f : files) {
                    if (f.isDirectory()) {
                        nestedFolders.add(f);
                    }
                }
                for (File f : files) {
                    if (f.isDirectory()) {
                        File[] files1 = f.listFiles();
                        for (File fd : files1) {
                            if (fd.isDirectory()) {
                                nestedFolders.add(fd);
                            }
                        }
                        for (File fd : files1) {
                            if (fd.isDirectory()) {
                                File[] files2 = fd.listFiles();
                                for (File fd1 : files2) {
                                    if (fd1.isDirectory()) {
                                        nestedFolders.add(fd1);
                                    }
                                }
                                for (File fd1 : files2) {
                                    if (fd1.isDirectory()) {
                                        File[] files3 = fd1.listFiles();
                                        for (File fd2 : files3) {
                                            if (fd2.isDirectory()) {
                                                nestedFolders.add(fd2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (File folder : nestedFolders) {
                System.out.println(folder.getName());
            }
            System.out.println(nestedFolders.size() + " folders");
        }
    }
}
