package java67.top21frequently;

import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        System.out.println("Input a number:");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        System.out.println(i % 2 == 0 ? "Even" : "Odd");
    }
}
