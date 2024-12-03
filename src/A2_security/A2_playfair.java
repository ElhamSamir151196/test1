/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2_security;

import java.awt.geom.Area;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author dell
 */
public class A2_playfair {

    static char[] alphabet = new char[26];
    static JTextArea Area;
    public static void main_playfair(String plain_text,String key_word,int  choose_number,JTextArea jTextArea1) {
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet[c - 'a'] = c;
        }

       // String key_word = "playfairexample";
        String key_word1 = key_word.replaceAll("j", "i");
        System.out.println("key_word1 = " + key_word1);

       // String plain_text = "gftesxcnkjkxfxdzf";
        String plain_text1 = plain_text.replaceAll("j", "i");
        System.out.println("plain_text = " + plain_text1);
        String str = "";
        System.out.println("size = " + plain_text1.length());
        for (int i = 0; i < plain_text1.length() - 1; i++) {
            str += plain_text1.charAt(i);
            if (plain_text1.charAt(i) == plain_text1.charAt(i + 1)) {
                str += "x";
            }
        }
        str += plain_text1.charAt(plain_text1.length() - 1);
        System.out.println("str = " + str);
        Area=jTextArea1;
        Area.append("You string is : "+str+"\n");
        if(choose_number==1){
            String cipher = Encryption(str, key_word1);
            System.out.println("Cipher text= "+cipher);
           Area.append("Cipher text= "+cipher+"\n");
        }
        else if(choose_number==2){
            String cipher=Decryption(str, key_word);
            System.out.println("plain text= "+cipher);
           Area.append("plain text= "+cipher+"\n");
        }
        else if(choose_number==3){
            String cipher = Encryption(str, key_word1);
             System.out.println("Cipher text= "+cipher);
           Area.append("Cipher text= "+cipher+"\n");
        String plain1=Decryption(cipher, key_word);
         System.out.println("plain text= "+plain1);
           Area.append("plain text= "+plain1+"\n");
        }
        else{
             System.out.println("Wrong entry.");
           Area.append("Wrong Entry \n");
        }
        

    }

    public static String Encryption(String plain_text, String key_word) {
        String cipher_text = "";

        char[][] matrix = new char[5][5];
        int count = 0;//count string key.
        int count1 = 0;//count alphapitic character.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (count < key_word.length()) {

                    while (key_word.length() > count) {
                        String str = key_word.substring(0, count);
                        String c = "" + key_word.charAt(count);
                        if (!str.contains(c)) {
                            matrix[i][j] = key_word.charAt(count);
                            count++;
                            break;
                        } else {
                            count++;
                        }
                    }
                }
                if (key_word.length() <= count) {//not else becaue last char is repetited.

                    // System.out.println("count1 = "+count1);
                    while (exist(matrix, alphabet[count1]) || alphabet[count1] == 'j') {
                        count1++;
                    }
                    matrix[i][j] = alphabet[count1];
                    count1++;
                }

            }
        }

        /**
         * ********display table**********
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println("");
        }

        /**
         * ********** split plain text***********
         */
        ArrayList<ArrayList<Character>> plain = new ArrayList<>();
        int count2 = 0;
        if (plain_text.length() % 2 != 0) {
            plain_text += "x";
        }
        for (int i = 0; i < plain_text.length() / 2; i++) {
            ArrayList<Character> p = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                char x = plain_text.charAt(count2);
                p.add(x);
                count2++;
            }
            plain.add(p);
        }
        /**
         * ******* display array******************
         */
        for (int i = 0; i < plain.size(); i++) {
            ArrayList<Character> A = plain.get(i);
            for (int j = 0; j < 2; j++) {
                System.out.print(A.get(j) + "  ");
            }
            System.out.println("");
        }

        ArrayList<ArrayList<Integer>> list_index = new ArrayList<>();
        /**
         * ******** get indeces of elements***************
         */
        for (int s = 0; s < plain.size(); s++) {
            ArrayList<Integer> A = new ArrayList<>();
            int i1 = -1, i2 = -1, j1 = -1, j2 = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (plain.get(s).get(0) == matrix[i][j]) {
                        i1 = i;
                        j1 = j;
                        System.out.println("char =" + plain.get(s).get(0) + " , i1 " + i1 + " , j1 =" + j1);
                    }
                    if (plain.get(s).get(1) == matrix[i][j]) {
                        i2 = i;
                        j2 = j;
                        System.out.println("char =" + plain.get(s).get(1) + " , i2 " + i2 + " , j2 =" + j2);
                    }
                }
            }
            A.add(i1);
            A.add(j1);
            A.add(i2);
            A.add(j2);
            list_index.add(A);
        }

        /**
         * *********** case to encrypt**********
         */
        ArrayList<ArrayList<Character>> Array_Cipher = new ArrayList<>();
        String str = "";
        for (int s = 0; s < list_index.size(); s++) {
            ArrayList<Integer> A = list_index.get(s);
            ArrayList<Character> B = new ArrayList<>();
            int i1 = -1, i2 = -1, j1 = -1, j2 = -1;

            if (A.get(0) == A.get(2)) {//equal rows index 
                i1 = A.get(0);
                i2 = A.get(2);
                j1 = A.get(1) + 1;
                j2 = A.get(3) + 1;

                if (j1 == 5) {
                    j1 = 0;
                }
                if (j2 == 5) {
                    j2 = 0;
                }
                B.add(matrix[i1][j1]);
                B.add(matrix[i2][j2]);
                str += matrix[i1][j1];
                str += matrix[i2][j2];

            } else if (A.get(1) == A.get(3)) {
                i1 = A.get(0) + 1;
                i2 = A.get(2) + 1;
                j1 = A.get(1);
                j2 = A.get(3);

                if (i1 == 5) {
                    i1 = 0;
                }
                if (i2 == 5) {
                    i2 = 0;
                }
                B.add(matrix[i1][j1]);
                B.add(matrix[i2][j2]);
                str += matrix[i1][j1];
                str += matrix[i2][j2];
            } else {
                i1 = A.get(0);
                j1 = A.get(3);

                i2 = A.get(2);
                j2 = A.get(1);
                B.add(matrix[i1][j1]);
                B.add(matrix[i2][j2]);
                str += matrix[i1][j1];
                str += matrix[i2][j2];
            }

            Array_Cipher.add(B);
        }

        System.out.println("Cipher = " + str);
        return str;
    }

    public static String Decryption(String plain_text, String key_word) {
        String cipher_text = "";

        char[][] matrix = new char[5][5];
        int count = 0;//count string key.
        int count1 = 0;//count alphapitic character.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                if (count < key_word.length()) {

                    while (key_word.length() > count) {
                        String str = key_word.substring(0, count);
                        String c = "" + key_word.charAt(count);
                        if (!str.contains(c)) {
                            matrix[i][j] = key_word.charAt(count);
                            count++;
                            break;
                        } else {
                            count++;
                        }
                    }
                }
                if (key_word.length() <= count) {//not else becaue last char is repetited.

                    // System.out.println("count1 = "+count1);
                    while (exist(matrix, alphabet[count1]) || alphabet[count1] == 'j') {
                        count1++;
                    }
                    matrix[i][j] = alphabet[count1];
                    count1++;
                }

            }
        }

        /**
         * ********display table**********
         */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println("");
        }

        /**
         * ********** split plain text***********
         */
        ArrayList<ArrayList<Character>> plain = new ArrayList<>();
        int count2 = 0;
        if (plain_text.length() % 2 != 0) {
            plain_text += "x";
        }
        for (int i = 0; i < plain_text.length() / 2; i++) {
            ArrayList<Character> p = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                char x = plain_text.charAt(count2);
                p.add(x);
                count2++;
            }
            plain.add(p);
        }
        /**
         * ******* display array******************
         */
        for (int i = 0; i < plain.size(); i++) {
            ArrayList<Character> A = plain.get(i);
            for (int j = 0; j < 2; j++) {
                System.out.print(A.get(j) + "  ");
            }
            System.out.println("");
        }

        ArrayList<ArrayList<Integer>> list_index = new ArrayList<>();
        /**
         * ******** get indeces of elements***************
         */
        for (int s = 0; s < plain.size(); s++) {
            ArrayList<Integer> A = new ArrayList<>();
            int i1 = -1, i2 = -1, j1 = -1, j2 = -1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (plain.get(s).get(0) == matrix[i][j]) {
                        i1 = i;
                        j1 = j;
                        System.out.println("char =" + plain.get(s).get(0) + " , i1 " + i1 + " , j1 =" + j1);
                    }
                    if (plain.get(s).get(1) == matrix[i][j]) {
                        i2 = i;
                        j2 = j;
                        System.out.println("char =" + plain.get(s).get(1) + " , i2 " + i2 + " , j2 =" + j2);
                    }
                }
            }
            A.add(i1);
            A.add(j1);
            A.add(i2);
            A.add(j2);
            list_index.add(A);
        }

        /**
         * *********** case to decrypt**********
         */
        ArrayList<ArrayList<Character>> Array_Cipher = new ArrayList<>();
        String str = "";
        for (int s = 0; s < list_index.size(); s++) {
            ArrayList<Integer> A = list_index.get(s);
            ArrayList<Character> B = new ArrayList<>();
            int i1 = -1, i2 = -1, j1 = -1, j2 = -1;

            if (A.get(0) == A.get(2)) {//equal rows index 
                i1 = A.get(0);
                i2 = A.get(2);
                j1 = A.get(1) - 1;
                j2 = A.get(3) - 1;

                if (j1 == -1) {
                    j1 = 4;
                }
                if (j2 == -1) {
                    j2 = 4;
                }
                B.add(matrix[i1][j1]);
                B.add(matrix[i2][j2]);
                str += matrix[i1][j1];
                str += matrix[i2][j2];

            } else if (A.get(1) == A.get(3)) {
                i1 = A.get(0) - 1;
                i2 = A.get(2) - 1;
                j1 = A.get(1);
                j2 = A.get(3);

                if (i1 == -1) {
                    i1 = 4;
                }
                if (i2 == -1) {
                    i2 = 4;
                }
                B.add(matrix[i1][j1]);
                B.add(matrix[i2][j2]);
                str += matrix[i1][j1];
                str += matrix[i2][j2];
            } else {
                i1 = A.get(0);
                j1 = A.get(3);

                i2 = A.get(2);
                j2 = A.get(1);
                B.add(matrix[i1][j1]);
                B.add(matrix[i2][j2]);
                str += matrix[i1][j1];
                str += matrix[i2][j2];
            }

            Array_Cipher.add(B);
        }

        System.out.println("Cipher = " + str);
        return str;
    }

    public static boolean exist(char[][] x, char y) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (y == x[i][j]) {
                    return true;
                }
            }

        }
        return false;

    }

}
