package practic13.task3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (FileWriter writer = new FileWriter("C:\\Users\\user\\IdeaProjects\\JavaTasks\\output1.txt", false)) {
            writer.write(scanner.nextLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
