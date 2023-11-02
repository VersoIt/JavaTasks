package practic13.task2;

import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (FileReader reader = new FileReader("C:\\Users\\user\\IdeaProjects\\JavaTasks\\output1.txt")) {
            int symbol;
            while ((symbol = reader.read()) != -1) {
                System.out.print((char)symbol);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
