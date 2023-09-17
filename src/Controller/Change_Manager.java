/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Validation;
import view.Menu;

/**
 *
 * @author MINH TUAN
 */
public class Change_Manager extends Menu<String> {

    static String[] menu = {"Convert From Binary", "Convert From Decimal", "Convert From Hex", "Exit"};
    static Change_Manager manager = new Change_Manager();
    static char[] digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public Change_Manager() {
        super("_________CHANGE BASE NUMBER SYSTEM_________", menu);
    }

    @Override
    public void execute(int choice) throws Exception {
        switch (choice) {
            case 1:
                String binary = Validation.checkBinary();
                BinaryMenu(binary);
                break;
            case 2:
                String decimal = Validation.checkDecimal();
                DecimalMenu(decimal);
                break;
            case 3:
                String hex = Validation.checkHex();
                HexMenu(hex);
                break;
            case 4:
                System.out.println("___<3___ Thank you ___<3___");
                System.out.println("Exiting......");
                System.exit(0);
            default:
                this.stop();
        }
    }

    // -------------------------------------------------
    public void BinaryMenu(String binary) throws Exception {
        String[] mBinary = {"Convert to Decimal", "Convert to Hex", "Back to Main Menu"};
        Menu menuBinary = new Menu("======= BINARY PROGRAMMING =======", mBinary) {
            @Override
            public void execute(int choice) throws Exception {
                switch (choice) {
                    case 1:
                        System.out.println("Binary -> Decimal: " + binary + " -> " + BinaryToDecimal(binary));
                        break;
                    case 2:
                        System.out.println("Binary -> Hex: " + binary + "->" + BinaryToHex(binary));
                        break;
                    case 3:
                        return;
                    default:
                        this.stop();
                }
            }
        };
        menuBinary.execute(menuBinary.getSelected());
    }

    public String BinaryToDecimal(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.toString(decimal);
    }

    public String BinaryToHex(String binary) {
        String decimal = BinaryToDecimal(binary);
        String hexa = DecimalToHexa(decimal);
        return hexa;
    }

    // -------------------------------------------------
    public void DecimalMenu(String decimal) throws Exception {
        String[] mDecimal = {"Convert to Binary", "Convert to Hexa", "Back to Main Menu"};
        Menu menuDec = new Menu("======= DECIMAL PROGRAMMING =======", mDecimal) {
            @Override
            public void execute(int choice) throws Exception {
                switch (choice) {
                    case 1:
                        System.out.println("Decimal -> Binary: " + decimal + " -> " + DecimalToBinary(decimal));
                        break;
                    case 2:
                        System.out.println("Decimal -> Hex: " + decimal + "->" + DecimalToHexa(decimal));
                        break;
                    case 3:
                        return;
                    default:
                        this.stop();
                }
            }
        };
        menuDec.execute(menuDec.getSelected());
    }

    public String DecimalToBinary(String decimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        return binary;
    }

    public String DecimalToHexa(String decimal) {
        String hexa = "";
        int deci = Integer.parseInt(decimal);
        while (deci != 0) {
            hexa = digit[deci % 16] + hexa;
            deci /= 16;
        }
        return hexa;
    }

    // -------------------------------------------------
    public void HexMenu(String hex) throws Exception {
        String[] mHex = {"Convert to Binary", "Convert to Decimal", "Back to Main Menu"};
        Menu menuHex = new Menu("======= HEX PROGRAMMING =======", mHex) {
            @Override
            public void execute(int choice) throws Exception {
                switch (choice) {
                    case 1:
                        System.out.println("Hex -> Binary: " + hex + " -> " + HexaToBinary(hex));
                        break;
                    case 2:
                        System.out.println("Hex -> Decimal: " + hex + "->" + HexaToDecimal(hex));
                        break;
                    case 3:
                        return;
                    default:
                        this.stop();
                }
            }
        };
        menuHex.execute(menuHex.getSelected());
    }

    public int HexaToDecimal(String hexadecimal) {
        int decimal = Integer.parseInt(hexadecimal, 16);
        return decimal;
    }

    public String HexaToBinary(String hexadecimal) {
        String binary = Integer.toBinaryString(HexaToDecimal(hexadecimal));
        return binary;
    }

}
