import logic.StringLogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringView {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        StringLogic stringLogic = new StringLogic(new File("text.txt"));

        System.out.println("Hello! It is a program. You have 5 commands: ");
        System.out.println("1 - It is for check FIRST task");
        System.out.println("2 - It is for check SECOND task");
        System.out.println("3 - It is for check THIRD task");
        System.out.println("4 - It is for check FOURTH task");
        System.out.println("5 - It is for check EXIT task");

        while (true) {
            System.out.println("What do you need? Please, enter of number: ");
            char c = ' ';
            c = sc.next().charAt(0);
            switch (c) {
                case '1':
                    System.out.println("---   Task #1   ---");
                    stringLogic.countAllSymbolsAndSortAscending();
                    break;
                case '2':
                    System.out.println("---   Task #2   ---");
                    stringLogic.countAllWordsAndSortAscending();
                    break;
                case '3':
                    System.out.println("---   Task #3   ---");
                    stringLogic.reverseAllWordsInEachSentence();
                    break;
                case '4':
                    System.out.println("---   Task #4   ---");
                    stringLogic.countAllTheRootsInTextAndSortWithWriteInFile();
                    break;
                case '5': System.exit(0);
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
    }
}
