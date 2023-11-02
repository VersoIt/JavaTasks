package practic17.task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите инн: ");
            String inn = scanner.nextLine();
            process(inn);
        } catch (IncorrectInnException e) {
            System.out.println(e.getMessage());
        }
    }

    static void process(String inn) {
        if (inn.length() != 10) {
            throw new IncorrectInnException("Inn length is not equal to 10");
        }

        System.out.println("inn: " + inn);
    }
}
