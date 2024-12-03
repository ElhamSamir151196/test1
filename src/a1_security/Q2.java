/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1_security;

import static java.lang.Math.pow;
import java.util.ArrayList;
import javax.swing.JTextArea;
//import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Q2 {
    
   static  JTextArea Area;
     public  void main_Q2(int num,JTextArea jTextArea1) {
         Area=jTextArea1;
       // Scanner input = new Scanner(System.in);
        //System.out.println("Enter a power prime number ( you think ) : ");
        //int num = input.nextInt();
        // System.out.println(Power_Prime(num));
        //System.out.println(Extentision(num));
        AdditiveInverse(num);

    }

    public static boolean Prime(int num) {

        // Scanner  input = new Scanner(System.in);
        // System.out.println("Enter a prime number ( you think ) : ");
        // int num = input.nextInt();
        boolean isPrime = true;
        for (int divisor = 2; divisor < num; divisor++) {
            if (num % divisor == 0) {

                isPrime = false;
                break;
            }
            isPrime = true;
        }
        if (isPrime) {
            System.out.println("Prime");
            Area.append("Prime\n");
            return true;

        } else {
            System.out.println("Not a prime");
            Area.append("Not a prime\n");
            return false;
        }
    }

    public static boolean Power_Prime(int num) {

        // Scanner  input = new Scanner(System.in);
        //   System.out.println("Enter a power prime number ( you think ) : ");
        //   int num = input.nextInt();
        boolean isPowerPrime = false;
        for (int i = 1; i < num; i++) {
            for (int p = 1; p < num; p++) {
                if (pow(p, i) == num) {
                    boolean prim = Prime(p);
                    if (prim == true) {
                        System.out.println("power Prime");
                         Area.append("power Prime\n");
                        return true;
                    }

                }

                isPowerPrime = false;
            }
        }

        System.out.println("Not apower  prime");
        Area.append("Not apower  prime\n");
        return false;

    }

    public static boolean Extentision(int num) {

        boolean isPowerPrime = false;
        for (int i = 1; i < num; i++) {

            if (pow(2, i) == num) {
                System.out.println("extension");
                Area.append("extension\n");
                return true;
            }

            isPowerPrime = false;
        }

        System.out.println("Not extension");
        Area.append("Not extension\n");
        return false;

    }

    public static void AdditiveInverse(int length) {

        if (!(Prime(length) || Extentision(length) || Power_Prime(length))) {
            return;
        }
        int[][] table = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
               // System.out.println("i = "+i+", j = "+ j+ ", (i + j) % length  = "+ (i + j) % length);
                table[i][j] = (i + j) % length;
                System.out.print(table[i][j]+"    ");
                Area.append(table[i][j]+"    ");
            }
            System.out.println("");
            Area.append("\n");

        }
        ArrayList<Integer> addtive_inv = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (table[i][j] == 0) {
                    addtive_inv.add(j);//row isindex . col is j.
                    System.out.println(j);
                    Area.append(j+"\n");
                }
            }

        }
        /**
         * *****************************************************
         */
        ArrayList<Integer> addtive_inv_equ = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((j + i) % length == 0) {
                    addtive_inv_equ.add(j);//row isindex . col is j.
                    System.out.println("["+i+","+j+"]");
                    Area.append("["+i+","+j+"]"+"\n");

                }
            }

        }
    }
      public static void multiplicative (int length) {

        if (!(Prime(length) || Extentision(length) || Power_Prime(length))) {
            return;
        }
        int[][] table = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
               // System.out.println("i = "+i+", j = "+ j+ ", (i + j) % length  = "+ (i + j) % length);
                table[i][j] = (i * j) % length;
                System.out.print(table[i][j]+"    ");
                Area.append(table[i][j]+"    ");
            }
            System.out.println("");
            Area.append("\n");

        }
        ArrayList<Integer> addtive_inv = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (table[i][j] == 1) {
                    addtive_inv.add(j);//row isindex . col is j.
                    System.out.println(j);
                    Area.append(j+"\n");
                }
            }

        }
        /**
         * *****************************************************
         */
        ArrayList<Integer> addtive_inv_equ = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if ((j *i) % length == 1) {
                    addtive_inv_equ.add(j);//row isindex . col is j.
                    System.out.println("["+i+","+j+"]");
                    Area.append("["+i+","+j+"]"+"\n");

                }
            }

        }
    }
    
}
