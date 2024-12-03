/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A2_security;

import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author dell
 */
public class A2_Caser_cipher {

    public static String alphaptic = "abcdefghijklmnopqrstuvwxyz";

    public static String encryption(String plaintext, int key) {

        plaintext = plaintext.toLowerCase();
        String cipher_text = "";
        for (int i = 0; i < plaintext.length(); i++) {
            int position = alphaptic.indexOf(plaintext.charAt(i));
            int c = (position + key) % 26;
            char x = alphaptic.charAt(c);
            cipher_text += x;

        }
        return cipher_text;
    }

    public static String decryption(String ciphertext, int key) {
        ciphertext = ciphertext.toLowerCase();
        String plain_text = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            int position = alphaptic.indexOf(ciphertext.charAt(i));
            int c = (position - key) % 26;
            if (c < 0) {
                c = c + alphaptic.length();
            }
            char x = alphaptic.charAt(c);
            plain_text += x;

        }
        return plain_text;
    }

    static JTextArea Area;

    public static void main_Caser(String x, int k, int choose, JTextArea Area1) {// x plain text.
        Scanner in = new Scanner(System.in);
        // System.out.println("please enter plaintext and key");
        // String x=in.next();
        // int k=in.nextInt();

        Area = Area1;
        if (choose == 1) {
            String text = encryption(x, k);
            System.out.println("ciphertext is" + " " + text);
            Area.append("ciphertext is" + " " + text+"\n");
        } else if (choose == 2) {
            String text2 = decryption(x, k);
            System.out.println("plaintext is" + " " + text2);
            Area.append("plaintext is" + " " + text2+"\n");
        } else if (choose == 3) {
            String text = encryption(x, k);
            System.out.println("ciphertext is" + " " + text);
            Area.append("ciphertext is" + " " + text+"\n");
            String text2 = decryption(text, k);
            System.out.println("plaintext is" + " " + text2);
            Area.append("plaintext is" + " " + text2+"\n");
        } else {
            System.out.println(" wrong entry.");
            Area.append(" wrong entry."+"\n");
        }
        /*   cipher_test t = new cipher_test();
        for(String pt : t.producePlaintext("abc")) {
            System.out.println(pt);
        }*/
        // TODO code application logic here
    }

}
