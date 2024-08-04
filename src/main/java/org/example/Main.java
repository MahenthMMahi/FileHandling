package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final String pathName = "C:\\Users\\SALES\\Downloads\\sample.txt";

        // create a file
        File file = new File(pathName);
        try {

            boolean status = file.createNewFile();
            if (status) {
                System.out.println("New file created");
            } else {
                System.out.println("File name already exists");
            }

            String message = "Simple Java Writing";
            FileWriter fileWriter = new FileWriter(pathName);
            fileWriter.write(message);
            fileWriter.close();

            System.out.println("New file Written");

            // Read the file content as a String
            String fileContent = Files.readString(Paths.get(pathName));

//            // Or Add to a character array
//            List<Character> charList = new ArrayList<>();
//            for (char ch : fileContent.toCharArray()) {
//                charList.add(ch);
//            }
            System.out.println("File content: " + fileContent);

            // delete file
            if (file.delete()) {
                System.out.println("File deleted successfully");
            } else {
                System.out.println("Failed to delete the file");
            }
        } catch (Exception exception) {
            System.out.println("An error occurred");
        }
    }
}