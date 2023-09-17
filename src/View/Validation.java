/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.Scanner;

/**
 *
 * @author MINH TUAN
 */
public class Validation {

    public Validation() {
    }

    final static Scanner scanner = new Scanner(System.in);
    final static String binary = "[0-1]+";
    final static String decimal = "[0-9]+";
    final static String hexa = "[0-9A-F]+";

    //Nhap chuoi 
    public static String getString(String msg) {
        String value = null;

        while (true) {
            if (msg != null) {
                System.out.print(msg);
            }

            value = scanner.nextLine().replaceAll("\\s+", " ").trim();

            if (!value.isEmpty() && !value.isBlank()) {
                break;
            }

            System.err.println("Please enter again...");
        }

        return value;
    }


    // Kiem tra so Binary
    public static String checkBinary() {
        System.out.print("Enter number binary: ");
        String result;

        while (true) {
            result = scanner.nextLine().trim();
            if (result.matches(binary)) {
                return result;
            }
            System.out.println("Binary number must be have digit [0-1]");
            System.out.print("Enter again: ");
        }
    }
    

    // Kiem tra so Decimal
    public static String checkDecimal() {
        System.out.print("Enter number decimal: ");
        String result;

        while (true) {
            result = scanner.nextLine().trim();
            if (result.matches(decimal)) {
                return result;
            }
            System.err.println("Decimal number must be have digit [0-9]");
            System.out.print("Enter again: ");
        }
    }
    

    //  Kiem tra so Hexa
    public static String checkHex() {
        System.out.print("Enter number hexadecimal: ");
        String result;

        while (true) {
            result = scanner.nextLine().trim();
            if (result.matches(hexa)) {
                return result;
            }
            System.err.println("Hexadecimal number must be have digit [0-9] and [A-F]");
            System.out.print("Enter again: ");
        }
    }
}
