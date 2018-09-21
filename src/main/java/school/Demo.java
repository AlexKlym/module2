package school;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get("src/main/java/school.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SchoolDB.createTable();

        for (String line : lines) {
            SchoolDB.addRow(line.split(","));
        }

        System.out.println("Enter class name: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println(SchoolDB.getClassInfo(scanner.nextLine()));

    }
}