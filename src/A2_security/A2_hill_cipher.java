/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2_security;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author dell
 */
public class A2_hill_cipher {

    static char[] alphabet = new char[26];

    static JTextArea Area;

    public static void main_hill(ArrayList<ArrayList<Character>> plain, ArrayList<ArrayList<Integer>> key, int choose_number, JTextArea jTextArea1) {
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet[c - 'a'] = c;
        }
        Area = jTextArea1;

        if (choose_number == 1) {
            char[][] c = Encryption(key, plain);
        } else if (choose_number == 2) {
            char[][] plain1 = new char[plain.size()][plain.get(0).size()];
            for (int i = 0; i < plain.size(); i++) {
                for (int j = 0; j < plain.get(i).size(); j++) {
                    plain1[i][j] = plain.get(i).get(j);
                }
            }
            System.out.println(" plain text = " + Decryption(key, plain1));
        } else if (choose_number == 3) {
            char[][] c = Encryption(key, plain);
           // Area.append(" cipher text = " +dec+"\n");
            String dec=Decryption(key, c);
            System.out.println(" plain text = " +dec );
            Area.append(" plain text = " +dec+"\n");
        } else {
            System.out.println("wrong entry.");
            Area.append("wrong entry." + "\n");
        }

    }

    public static char[][] Encryption(ArrayList<ArrayList<Integer>> key, ArrayList<ArrayList<Character>> plain) {
        // ArrayList<ArrayList<Integer>> plain_values=new ArrayList<>();
        int[][] plain_values = new int[plain.size()][plain.get(0).size()];

        /**
         * **********create plain matrix*********************
         */
        for (int i = 0; i < plain.size(); i++) {
            for (int j = 0; j < plain.get(i).size(); j++) {

                for (int s = 0; s < alphabet.length; s++) {
                    if (plain.get(i).get(j) == alphabet[s]) {
                        plain_values[i][j] = s;
                        // System.out.println(s+"   ");
                        break;
                    }
                }
            }
            System.out.println("");
        }

        /**
         * ***************** multiple matrix*****************
         */
        //new matrix to hold result
        int[][] myMatrixC = new int[plain.size()][key.get(0).size()];
        //start across rows of A
        for (int i = 0; i < plain.size(); i++) {
            //work across cols of B
            for (int j = 0; j < key.get(0).size(); j++) {
                //now complete the addition and multiplication
                for (int k = 0; k < plain.get(0).size(); k++) {
                    myMatrixC[i][j] += plain_values[i][k] * key.get(j).get(k);
                    System.out.println(plain_values[i][k] + " * " + key.get(j).get(k) + " = " + myMatrixC[i][j] + " +=");
                }
                System.out.println("\nfinal = " + myMatrixC[i][j]);
            }
            System.out.println("-------------------------------------------------");
        }

        /**
         * ****display *******************
         */
        System.out.println("*****************************************");
        for (int i = 0; i < plain.size(); i++) {
            for (int j = 0; j < key.get(0).size(); j++) {
                System.out.print(myMatrixC[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("*****************************************");

        /**
         * ****take mod 26****************
         */
        for (int i = 0; i < plain.size(); i++) {
            for (int j = 0; j < key.get(0).size(); j++) {
                myMatrixC[i][j] %= 26;
            }
        }
        /**
         * ****display *******************
         */
        Area.append("cipher matrix :");
        for (int i = 0; i < plain.size(); i++) {
            for (int j = 0; j < key.get(0).size(); j++) {
                System.out.print(myMatrixC[i][j] + "  ");
                Area.append(myMatrixC[i][j] + "  ");
            }
            System.out.println("");
            Area.append("\n");
        }

        /**
         * ***********************************
         */
        char[][] cipher = new char[plain.size()][plain.get(0).size()];
        String cipher_text = "";
        /**
         * **********create plain matrix*********************
         */
        for (int i = 0; i < plain.size(); i++) {
            for (int j = 0; j < plain.get(i).size(); j++) {
                cipher[i][j] = alphabet[myMatrixC[i][j]];
                cipher_text += alphabet[myMatrixC[i][j]];
            }
        }

        System.out.println("cipher_text  is : " + cipher_text);
        Area.append("cipher_text  is : " + cipher_text+"\n");
        return cipher;
    }

    public static String Decryption(ArrayList<ArrayList<Integer>> key, char[][] cipher) {

        int[][] cipher_values = new int[cipher.length][cipher[0].length];

        /**
         * **********create plain matrix*********************
         */
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < cipher[i].length; j++) {

                for (int s = 0; s < alphabet.length; s++) {
                    if (cipher[i][j] == alphabet[s]) {
                        cipher_values[i][j] = s;
                        System.out.println(s);
                        break;
                    }
                }
            }
        }

        int[][] key_values = new int[key.size()][key.get(0).size()];
        for (int i = 0; i < key.size(); i++) {
            for (int j = 0; j < key.get(i).size(); j++) {

                key_values[i][j] = key.get(i).get(j);
            }
        }

        //*****************determined matrix*****/
        int D = determinant(key_values, key_values.length)%26;
        if (D < 0) {
            D += 26;
        }
        System.out.println("D= " + D);
        Area.append("D= " + D+"\n");
        /**
         * ************get d inverse***********************
         */
        int num = 26;
        if (GCD(num, D) != 1) {
            System.out.println("Sorry can't decrption this key because gcd = " + GCD(num, D));
            Area.append("Sorry can't decrption this key because gcd = " + GCD(num, D)+"\n");
            return "";
        }

        int D_inverse = 1;
        for (int i = 0; i < 26; i++) {
            if ((D * i) % 26 == 1) {
                D_inverse = i;
                break;
            }

        }
        System.out.println("D-1 = " + D_inverse);
        Area.append("D-1 = " + D_inverse+"\n");

        int[][] k_inverse;
        if (key_values.length == 2) {//case of 2*2 matrix.
            k_inverse = new int[2][2];
            k_inverse[0][0] = key_values[1][1];
            k_inverse[0][1] = -1 * key_values[0][1];
            k_inverse[1][0] = -1 * key_values[1][0];
            k_inverse[1][1] = key_values[0][0];
        } else {//case 3*3 matrix.
            k_inverse = Adjugate_matrix(key_values);
        }

        /**
         * ***take mod *****************
         */
        Area.append("k_inverse matrix :");
        for (int i = 0; i < k_inverse.length; i++) {
            for (int j = 0; j < k_inverse[i].length; j++) {
                k_inverse[i][j] *= D_inverse;
                k_inverse[i][j] %= 26;
                if (k_inverse[i][j] < 0) {
                    k_inverse[i][j] += 26;
                }
                System.out.println(k_inverse[i][j] + "   ");
                Area.append(k_inverse[i][j] + "   ");
            }
            System.out.println("");
            Area.append("\n");
        }

        /**
         * ************multiply *********************
         */
        int[][] myMatrixC = new int[cipher_values.length][k_inverse[0].length];
        //start across rows of A
        for (int i = 0; i < cipher_values.length; i++) {
            //work across cols of B
            for (int j = 0; j < k_inverse[0].length; j++) {
                //now complete the addition and multiplication
                for (int k = 0; k < cipher_values[0].length; k++) {
                    myMatrixC[i][j] += cipher_values[i][k] * k_inverse[j][k];
                    System.out.println(cipher_values[i][k] + " * " + k_inverse[j][k] + " = " + myMatrixC[i][j] + " +=");
                }
                System.out.println("\nfinal = " + myMatrixC[i][j]);
            }
            System.out.println("++++++++++++++++++++++++");
        }
        /**
         * ****display *******************
         */
        System.out.println("*****************************************");
        for (int i = 0; i < myMatrixC.length; i++) {
            for (int j = 0; j < myMatrixC[0].length; j++) {
                System.out.print(myMatrixC[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("*****************************************");

        /**
         * ***********return true values*****************
         */
        /**
         * ****take mod 26****************
         */
        for (int i = 0; i < cipher_values.length; i++) {
            for (int j = 0; j < key.get(0).size(); j++) {
                myMatrixC[i][j] %= 26;
            }
        }

        /**
         * ***********************************
         */
        char[][] pl_txt = new char[cipher_values.length][cipher_values[0].length];
        //String cipher_text = "";
        String plain_text = "";
        /**
         * **********create plain matrix*********************
         */
        for (int i = 0; i < cipher_values.length; i++) {
            for (int j = 0; j < cipher_values[0].length; j++) {
                pl_txt[i][j] = alphabet[myMatrixC[i][j]];
                plain_text += alphabet[myMatrixC[i][j]];
            }
        }

        System.out.println("cipher_text  is : " + plain_text);

        return plain_text;
    }

    public static int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }

    public static int determinant(int A[][], int N) {
        int det = 0;
        if (N == 1) {
            det = A[0][0];
        } else if (N == 2) {
            det = A[0][0] * A[1][1] - A[1][0] * A[0][1];
        } else {
            det = 0;
            for (int j1 = 0; j1 < N; j1++) {
                int[][] m = new int[N - 1][];
                for (int k = 0; k < (N - 1); k++) {
                    m[k] = new int[N - 1];
                }
                for (int i = 1; i < N; i++) {
                    int j2 = 0;
                    for (int j = 0; j < N; j++) {
                        if (j == j1) {
                            continue;
                        }
                        m[i - 1][j2] = A[i][j];
                        j2++;
                    }
                }
                det += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1] * determinant(m, N - 1);
            }
        }
        return det;
    }

    public static int[][] Adjugate_matrix(int[][] matrix) {
        int rows = 3, cols = 3;
        int[][] cofactor = new int[rows][cols];
        int[][] minor = new int[rows][cols];
        // long determinant = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cofactor[row][col] = matrix[(row + 1) % rows][(col + 1) % cols] * matrix[(row + 2) % rows][(col + 2) % cols] - matrix[(row + 1) % rows][(col + 2) % cols] * matrix[(row + 2) % rows][(col + 1) % cols];
                minor[row][col] = cofactor[row][col];
            }
        }

        int[][] temp = new int[minor[0].length][minor.length];
        for (int i = 0; i < minor.length; i++) {
            for (int j = 0; j < minor[0].length; j++) {
                temp[j][i] = minor[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(minor[i][j] + "  ");
            }
            System.out.println("");
        }

        //int[][] p = transposeMatrix(minor);
        System.out.println("_________________________________________________________");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(temp[i][j] + "  ");
            }
            System.out.println("");
        }
        return temp;
    }

}
