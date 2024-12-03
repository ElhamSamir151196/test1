package A3_security;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author samar sabry
 */
public class A3_Security_DES {

    static JTextArea Area;

    public static void main_Des(String Hex, String key, int choose, JTextArea Area1) {
        Area = Area1;
        array_s_boxs.add(S1);
        array_s_boxs.add(S2);
        array_s_boxs.add(S3);
        array_s_boxs.add(S4);
        array_s_boxs.add(S5);
        array_s_boxs.add(S6);
        array_s_boxs.add(S7);
        array_s_boxs.add(S8);
        /* String str1="133457799BBCDFF1";
       int decimal = Integer.parseInt(str1, 16);
        String hexStr = Integer.toString(decimal, 4);

        System.out.println("old hexa" + hexStr);
         */
        //String s="2";
        // int x=2;
        // String decimal = Integer.toBinaryString(x);//(s, 10);
        // System.out.println(decimal);
        // String Hex = "133457799BBCDFF1";
        String key_bin = "";
        for (int d = 0; d < key.length(); d++) {
            String str_hex = "" + key.charAt(d);
            int i = Integer.parseInt(str_hex, 16);
            String Bin = Integer.toBinaryString(i);
            if (Bin.length() < 2) {
                Bin = "000" + Bin;
            } else if (Bin.length() < 3) {
                Bin = "00" + Bin;
            } else if (Bin.length() < 4) {
                Bin = "0" + Bin;
            }
            key_bin += Bin;
            System.out.println("Bin = " + Bin);
        }
        String bin = "";
        for (int d = 0; d < Hex.length(); d++) {
            String str_hex = "" + Hex.charAt(d);
            int i = Integer.parseInt(str_hex, 16);
            String Bin = Integer.toBinaryString(i);
            if (Bin.length() < 2) {
                Bin = "000" + Bin;
            } else if (Bin.length() < 3) {
                Bin = "00" + Bin;
            } else if (Bin.length() < 4) {
                Bin = "0" + Bin;
            }
            bin += Bin;
            System.out.println("Bin = " + Bin);
        }
        System.out.println("bin = " + bin);
        String M = "0000000100100011010001010110011110001001101010111100110111101111";
        System.out.println("M    ="+M);
        System.out.println("key_bin = "+key_bin);
        String intial_key = "0001001100110100010101110111100110011011101111001101111111110001";
        System.out.println("bin =     " + intial_key);
        // String intial_key = "0001001100110100010101110111100110011011101111001101111111110001";
        //System.out.println("bin = " + intial_key);
        String[] pc2_keys = CreateKey(key_bin);

        if (choose == 1) {
            String hexa_cipher = Encryption(bin, pc2_keys);
            System.out.println("hexa_cipher = " + hexa_cipher);
            Area.append("Cipher text= " + hexa_cipher + "\n");
        } else if (choose == 2) {
            String hexa_plain = Decryption(bin, pc2_keys);
            System.out.println("hexa_cipher = " + hexa_plain);
            Area.append("Cipher text= " + hexa_plain + "\n");
        } else if (choose == 3) {

            String hexa_cipher = Encryption(bin, pc2_keys);
            System.out.println("hexa_cipher = " + hexa_cipher);
            Area.append("Cipher text= " + hexa_cipher + "\n");
            String binary_cipher = "";
            for (int d = 0; d < hexa_cipher.length(); d++) {
                String str_hex = "" + hexa_cipher.charAt(d);
                int i = Integer.parseInt(str_hex, 16);
                String Bin = Integer.toBinaryString(i);
                if (Bin.length() < 2) {
                    Bin = "000" + Bin;
                } else if (Bin.length() < 3) {
                    Bin = "00" + Bin;
                } else if (Bin.length() < 4) {
                    Bin = "0" + Bin;
                }
                binary_cipher += Bin;

                System.out.println("Bin = " + Bin);
            }
           String hexa_plain = Decryption(binary_cipher, pc2_keys);
             System.out.println("hexa_cipher = " + hexa_plain);
            Area.append("plain text= " + hexa_plain + "\n");
        } else {
            System.out.println("Wrong entry.");
            Area.append("Wrong entry." + "\n");
        }
        System.out.println("________________________________________________________________");

    }

    private static Integer[][] S1 = {
        {14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
        {0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
        {4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
        {15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
    };
    private static Integer[][] S2 = {
        {15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
        {3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
        {0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
        {13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}
    };
    private static Integer[][] S3 = {
        {10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
        {13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
        {13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
        {1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
    };
    private static Integer[][] S4 = {
        {7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
        {13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
        {10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
        {3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14},};
    private static Integer[][] S5 = {
        {2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
        {14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
        {4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
        {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
    };
    private static Integer[][] S6 = {
        {12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
        {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
        {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
        {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13},};
    private static Integer[][] S7 = {
        {4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
        {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
        {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
        {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
    };
    private static Integer[][] S8 = {
        {13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
        {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
        {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
        {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}
    };

    private static ArrayList<Integer[][]> array_s_boxs = new ArrayList<>();//puting all s in 
    private static byte[] P = {
        16, 7, 20, 21,
        29, 12, 28, 17,
        1, 15, 23, 26,
        5, 18, 31, 10,
        2, 8, 24, 14,
        32, 27, 3, 9,
        19, 13, 30, 6,
        22, 11, 4, 25
    };
    private static byte[] E = {
        32, 1, 2, 3, 4, 5,
        4, 5, 6, 7, 8, 9,
        8, 9, 10, 11, 12, 13,
        12, 13, 14, 15, 16, 17,
        16, 17, 18, 19, 20, 21,
        20, 21, 22, 23, 24, 25,
        24, 25, 26, 27, 28, 29,
        28, 29, 30, 31, 32, 1
    };
    /**
     * * Values for the Final Permutation (FP) step.
     */
    private final static byte[] FP
            = {
                40, 8, 48, 16, 56, 24, 64, 32,
                39, 7, 47, 15, 55, 23, 63, 31,
                38, 6, 46, 14, 54, 22, 62, 30,
                37, 5, 45, 13, 53, 21, 61, 29,
                36, 4, 44, 12, 52, 20, 60, 28,
                35, 3, 43, 11, 51, 19, 59, 27,
                34, 2, 42, 10, 50, 18, 58, 26,
                33, 1, 41, 9, 49, 17, 57, 25
            };
    private static byte[] pc1 = {
        (byte) 56, (byte) 48, (byte) 40, (byte) 32, (byte) 24, (byte) 16, (byte) 8,
        (byte) 0, (byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17,
        (byte) 9, (byte) 1, (byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26,
        (byte) 18, (byte) 10, (byte) 2, (byte) 59, (byte) 51, (byte) 43, (byte) 35,
        (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14,
        (byte) 6, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21,
        (byte) 13, (byte) 5, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 28,
        (byte) 20, (byte) 12, (byte) 4, (byte) 27, (byte) 19, (byte) 11, (byte) 3
    };
    private static byte[] pc2 = {
        (byte) 13, (byte) 16, (byte) 10, (byte) 23, (byte) 0, (byte) 4,
        (byte) 2, (byte) 27, (byte) 14, (byte) 5, (byte) 20, (byte) 9,
        (byte) 22, (byte) 18, (byte) 11, (byte) 3, (byte) 25, (byte) 7,
        (byte) 15, (byte) 6, (byte) 26, (byte) 19, (byte) 12, (byte) 1,
        (byte) 40, (byte) 51, (byte) 30, (byte) 36, (byte) 46, (byte) 54,
        (byte) 29, (byte) 39, (byte) 50, (byte) 44, (byte) 32, (byte) 47,
        (byte) 43, (byte) 48, (byte) 38, (byte) 55, (byte) 33, (byte) 52,
        (byte) 45, (byte) 41, (byte) 49, (byte) 35, (byte) 28, (byte) 31,};
    private static int[] Round = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
    private final static byte[] IP
            = {
                58, 50, 42, 34, 26, 18, 10, 2,
                60, 52, 44, 36, 28, 20, 12, 4,
                62, 54, 46, 38, 30, 22, 14, 6,
                64, 56, 48, 40, 32, 24, 16, 8,
                57, 49, 41, 33, 25, 17, 9, 1,
                59, 51, 43, 35, 27, 19, 11, 3,
                61, 53, 45, 37, 29, 21, 13, 5,
                63, 55, 47, 39, 31, 23, 15, 7
            };

    public static String[] CreateKey(String intial_key) {

        String Key_After_pc1 = "";
        /**
         * ****looping to preumitation 1*************
         */
        for (int i = 0; i < pc1.length; i++) {
            Key_After_pc1 += intial_key.charAt(pc1[i]);
        }
        System.out.println("Key_After_pc1 = " + Key_After_pc1);

        /**
         * *******split left and right *********************
         */
        String key_left = Key_After_pc1.substring(0, (Key_After_pc1.length() / 2));
        String key_right = Key_After_pc1.substring((Key_After_pc1.length() / 2), Key_After_pc1.length());
        System.out.println(" length of key_rigth = " + key_right.length());

        /**
         * ****round keys************
         */
        /**
         * **** round left kay*****************
         */
        String[] left_keys = new String[16];
        for (int i = 0; i < Round.length; i++) {
            int temp = Round[i];
            //String temp_key_left="";
            String str = "";
            if (i != 0) {
                str = left_keys[i - 1];
            }
            while (temp > 0) {

                if (i == 0) {
                    System.out.println(" length of key_left = " + key_left.length());
                    str = key_left.substring(1, key_left.length()) + key_left.charAt(0);

                } else {
                    str = str.substring(1, str.length()) + str.charAt(0);
                }
                temp--;
            }

            left_keys[i] = str;
        }
        for (int i = 0; i < 16; i++) {
            System.out.println("left_keys[" + i + "] =" + left_keys[i] + " , " + left_keys[i].length());
        }

        /**
         * *************round right key *******************
         */
        String[] right_keys = new String[16];
        for (int i = 0; i < Round.length; i++) {
            int temp = Round[i];
            //String temp_key_left="";
            String str = "";
            if (i != 0) {
                str = right_keys[i - 1];
            }
            while (temp > 0) {

                if (i == 0) {
                    System.out.println(" length of key_left = " + key_right.length());
                    str = key_right.substring(1, key_right.length()) + key_right.charAt(0);

                } else {
                    str = str.substring(1, str.length()) + str.charAt(0);
                }
                temp--;
            }

            right_keys[i] = str;
        }
        for (int i = 0; i < 16; i++) {
            System.out.println("right_keys[" + i + "] =" + right_keys[i] + " , " + right_keys[i].length());
        }

        /**
         * ************ contact ***********************
         */
        String[] concatinait_keys = new String[16];

        for (int i = 0; i < 16; i++) {
            concatinait_keys[i] = left_keys[i] + right_keys[i];
            System.out.println("concat_keys[" + i + "] =" + concatinait_keys[i] + " , " + concatinait_keys[i].length());
        }

        String[] pc2_keys = new String[16];
        /**
         * ***************** prumation pc2********************
         */
        for (int i = 0; i < 16; i++) {
            pc2_keys[i] = "";
            for (int j = 0; j < pc2.length; j++) {
                pc2_keys[i] += concatinait_keys[i].charAt(pc2[j]);
            }
            System.out.println("pc2_keys[i] = " + pc2_keys[i] + "length = " + pc2_keys[i].length());
        }
        return pc2_keys;
    }

    public static String Encryption(String plain, String[] pc2_keys) {

        ArrayList<String> plain_list = new ArrayList<>();
        /**
         * *********creating blocks of 64 bits of plain
         * *****************************
         */
        String str = "";
        for (int i = 0; i < plain.length(); i++) {
            if (i % 64 == 0 && i != 0) {
                plain_list.add(str);
                str = "";
            }
            str += plain.charAt(i);

        }
        /**
         * *********** case not end of block*******************************
         */
        if (str.length() != 0) {
            while (str.length() != 64) {
                str += "0";
            }
            plain_list.add(str);
        }
        /**
         * ************** subsitute from ip on plain
         * text***************************
         */

        ArrayList<String> plain_list_ip = new ArrayList<>();

        for (int i = 0; i < plain_list.size(); i++) {
            String str1 = "";
            for (int j = 0; j < IP.length; j++) {
                str1 += plain_list.get(i).charAt(IP[j] - 1);

            }
            plain_list_ip.add(str1);
        }

        /**
         * **************display******************
         */
        for (int i = 0; i < plain_list_ip.size(); i++) {
            System.out.println("ip plain [" + i + "]" + plain_list_ip.get(i));
        }

        /**
         * ******split to left and right *************************
         */
        ArrayList<String> plain_list_ip_right = new ArrayList<>();
        ArrayList<String> plain_list_ip_left = new ArrayList<>();
        for (int i = 0; i < plain_list_ip.size(); i++) {
            System.out.println("ip plain [" + i + "]" + plain_list_ip.get(i));

            String plain_left = plain_list_ip.get(i).substring(0, (plain_list_ip.get(i).length() / 2));
            String plain_right = plain_list_ip.get(i).substring((plain_list_ip.get(i).length() / 2), plain_list_ip.get(i).length());

            plain_list_ip_left.add(plain_left);
            plain_list_ip_right.add(plain_right);
            System.out.println(" plain left = " + plain_list_ip_left.get(i) + " , " + plain_list_ip_left.get(i).length());
            System.out.println(" plain right = " + plain_list_ip_right.get(i) + " , " + plain_list_ip_right.get(i).length());

        }
        /**
         * *********************** rounds ********************************
         */
        System.out.println("*********************************************************************************************");
        ArrayList<String> plain_list_ip_round = new ArrayList<>();
        String temp_left = "";
        String temp_right = "";
        for (int i = 0; i < plain_list_ip.size(); i++) {
            System.out.println("size = " + plain_list_ip.size());
            System.out.println(" plain left = " + plain_list_ip_left.get(i) + " , " + plain_list_ip_left.get(i).length());
            System.out.println(" plain right = " + plain_list_ip_right.get(i) + " , " + plain_list_ip_right.get(i).length());
            for (int j = 0; j < 16; j++) {
                if (j == 0) {
                    temp_left = plain_list_ip_right.get(i);
                    temp_right = "";
                    String temp_left1 = plain_list_ip_left.get(i);
                    String temp_string = s_boxes(fun_x_or(plain_list_ip_right.get(i), pc2_keys[j]));
                    // System.out.println("left part = "+plain_list_ip_left.get(i)+"\n  right part = "+plain_list_ip_right.get(i));
                    //System.out.println("-------------------------------------------------------------------");
                    //System.out.println("l0000000000000000000000000 = " + temp_left + " , " + temp_left.length() + "\nr000000000000000000 = " + temp_string + " , " + temp_string.length());
                    //System.out.println("-------------------------------------------------------------------");
                    // temp_right=plain_list_ip_left.get(i)+s_boxes(fun_x_or(plain_list_ip_right.get(i),pc2_keys[j]));
                    // String temp_string=s_boxes(fun_x_or(temp_right,pc2_keys[j]));
                    for (int k = 0; k < 32; k++) {
                        if (temp_left1.charAt(k) == temp_string.charAt(k)) {
                            temp_right += "0";
                        } else {
                            temp_right += "1";
                        }
                    }

                } else {
                    System.out.println("j = " + j);
                    String tempp = temp_left;
                    temp_left = temp_right;

                    System.out.println("pc2_keys[j] = " + pc2_keys[j] + " , " + pc2_keys[j].length());
                    String temp_string = s_boxes(fun_x_or(temp_right, pc2_keys[j]));
                    temp_right = "";
                    for (int k = 0; k < 32; k++) {
                        //System.out.println(" k = " + k);
                        if (tempp.charAt(k) == temp_string.charAt(k)) {
                            temp_right += "0";
                        } else {
                            temp_right += "1";
                        }
                    }
                    // System.out.println("j = " + j + "-------------------------------------------------------------------");
                    //System.out.println("l0 = " + temp_left + " , " + temp_left.length() + "\nr0 = " + temp_string + " , " + temp_string.length());
                    // System.out.println("-------------------------------------------------------------------");

                }
                if (j == 15) {
                    plain_list_ip_round.add(temp_right + temp_left);
                }
                System.out.println("temp_left [" + (j + 1) + "] = " + temp_left);
                System.out.println("temp_right[" + (j + 1) + "] = " + temp_right);
            }
        }
        System.out.println("*********************************************************************************************");
        /**
         * ****************************************************
         */
        /**
         * ************** subsitute from ip inverse on plain
         * text***************************
         */
        ArrayList<String> final_ip_plain_list = new ArrayList<>();

        String strin = "";
        for (int i = 0; i < plain_list_ip_round.size(); i++) {
            String str1 = "";
            for (int j = 0; j < FP.length; j++) {
                str1 += plain_list_ip_round.get(i).charAt(FP[j] - 1);

            }
            strin += str1;
            final_ip_plain_list.add(str1);
        }
        // System.out.println("cipher text = " + strin + " , " + strin.length());

        /**
         * **********convert to hexa*************************
         */
        String hex = "";
        for (int i = 0; i < strin.length(); i += 4) {
            String st = strin.substring(i, i + 4);
            int decimal = Integer.parseInt(st, 2);
            String hexStr = Integer.toString(decimal, 16);
            hex += hexStr;
            //System.out.println("old hexa" + hexStr);
        }
        System.out.println("String  === " + hex);
        return hex;
    }

    public static String Decryption(String cipher, String[] pc2_keys) {
        System.out.println("cipher = "+cipher);
        System.out.println("--------------------------------------\n \n\n\ndecryption\n\n\n**************************");
        ArrayList<String> cipher_list = new ArrayList<>();
        /**
         * *********creating blocks of 64 bits of plain
         * *****************************
         */
        String str = "";
        for (int i = 0; i < cipher.length(); i++) {
            if (i % 64 == 0 && i != 0) {
                cipher_list.add(str);
                str = "";
            }
            str += cipher.charAt(i);

        }
        /**
         * *********** case not end of block*******************************
         */
        if (str.length() != 0) {
            while (str.length() != 64) {
                str += "0";
            }
            cipher_list.add(str);
        }
        /**
         * ************** subsitute from ip on plain
         * text***************************
         */

        ArrayList<String> cipher_list_ip = new ArrayList<>();

        for (int i = 0; i < cipher_list.size(); i++) {
            String str1 = "";
            for (int j = 0; j < IP.length; j++) {
                str1 += cipher_list.get(i).charAt(IP[j] - 1);
            }
            cipher_list_ip.add(str1);
        }

        /**
         * **************display******************
         */
        for (int i = 0; i < cipher_list_ip.size(); i++) {
            System.out.println("ip cipher [" + i + "] = " + cipher_list_ip.get(i));
        }

        /**
         * ******split to left and right *************************
         */
        ArrayList<String> cipher_list_ip_right = new ArrayList<>();
        ArrayList<String> cipher_list_ip_left = new ArrayList<>();
        for (int i = 0; i < cipher_list_ip.size(); i++) {
            System.out.println("ip cipher[" + i + "] = " + cipher_list_ip.get(i));

            String plain_left = cipher_list_ip.get(i).substring(0, (cipher_list_ip.get(i).length() / 2));
            String plain_right = cipher_list_ip.get(i).substring((cipher_list_ip.get(i).length() / 2), cipher_list_ip.get(i).length());

            cipher_list_ip_left.add(plain_left);
            cipher_list_ip_right.add(plain_right);
            System.out.println(" cipher left = " + cipher_list_ip_left.get(i) + " , " + cipher_list_ip_left.get(i).length());
            System.out.println(" copher right = " + cipher_list_ip_right.get(i) + " , " + cipher_list_ip_right.get(i).length());

        }
        /**
         * *********************** rounds ********************************
         */
        System.out.println("*********************************************************************************************");
        ArrayList<String> plain_list_ip_round = new ArrayList<>();
        String temp_left = "";
        String temp_right = "";
        for (int i = 0; i < cipher_list_ip.size(); i++) {
            System.out.println("size = " + cipher_list_ip.size());
            System.out.println(" plain left = " + cipher_list_ip_left.get(i) + " , " + cipher_list_ip_left.get(i).length());
            System.out.println(" plain right = " + cipher_list_ip_right.get(i) + " , " + cipher_list_ip_right.get(i).length());
            for (int j = 0; j < 16; j++) {
                if (j == 0) {
                    temp_left = cipher_list_ip_right.get(i);
                    temp_right = "";
                    String temp_left1 = cipher_list_ip_left.get(i);
                    String temp_string = s_boxes(fun_x_or(cipher_list_ip_right.get(i), pc2_keys[15 - j]));
                    // System.out.println("left part = "+plain_list_ip_left.get(i)+"\n  right part = "+plain_list_ip_right.get(i));
                    //System.out.println("-------------------------------------------------------------------");
                    //System.out.println("l0000000000000000000000000 = " + temp_left + " , " + temp_left.length() + "\nr000000000000000000 = " + temp_string + " , " + temp_string.length());
                    //System.out.println("-------------------------------------------------------------------");
                    // temp_right=plain_list_ip_left.get(i)+s_boxes(fun_x_or(plain_list_ip_right.get(i),pc2_keys[j]));
                    // String temp_string=s_boxes(fun_x_or(temp_right,pc2_keys[j]));
                    for (int k = 0; k < 32; k++) {
                        if (temp_left1.charAt(k) == temp_string.charAt(k)) {
                            temp_right += "0";
                        } else {
                            temp_right += "1";
                        }
                    }

                } else {
                    System.out.println("j = " + j);
                    String tempp = temp_left;
                    temp_left = temp_right;

                    System.out.println("pc2_keys[j] = " + pc2_keys[j] + " , " + pc2_keys[j].length());
                    String temp_string = s_boxes(fun_x_or(temp_right, pc2_keys[15 - j]));//start from end
                    temp_right = "";
                    for (int k = 0; k < 32; k++) {
                        //System.out.println(" k = " + k);
                        if (tempp.charAt(k) == temp_string.charAt(k)) {
                            temp_right += "0";
                        } else {
                            temp_right += "1";
                        }
                    }
                    // System.out.println("j = " + j + "-------------------------------------------------------------------");
                    //System.out.println("l0 = " + temp_left + " , " + temp_left.length() + "\nr0 = " + temp_string + " , " + temp_string.length());
                    // System.out.println("-------------------------------------------------------------------");

                }
                if (j == 15) {
                    plain_list_ip_round.add(temp_right + temp_left);
                }
                System.out.println("temp_left [" + (j + 1) + "] = " + temp_left);
                System.out.println("temp_right[" + (j + 1) + "] = " + temp_right);
            }
        }
        System.out.println("*********************************************************************************************");
        /**
         * ****************************************************
         */
        /**
         * ************** subsitute from ip inverse on plain
         * text***************************
         */
        ArrayList<String> final_ip_plain_list = new ArrayList<>();

        String strin = "";
        for (int i = 0; i < plain_list_ip_round.size(); i++) {
            String str1 = "";
            for (int j = 0; j < FP.length; j++) {
                str1 += plain_list_ip_round.get(i).charAt(FP[j] - 1);

            }
            strin += str1;
            final_ip_plain_list.add(str1);
        }
        // System.out.println("cipher text = " + strin + " , " + strin.length());

        /**
         * **********convert to hexa*************************
         */
        String hex = "";
        for (int i = 0; i < strin.length(); i += 4) {
            String st = strin.substring(i, i + 4);
            int decimal = Integer.parseInt(st, 2);
            String hexStr = Integer.toString(decimal, 16);
            hex += hexStr;
            //System.out.println("old hexa" + hexStr);
        }
        System.out.println("String  === " + hex);
        return hex;
    }

    public static String fun_x_or(String plain_right, String key) {
        String new_right = "";
        for (int i = 0; i < 48; i++) {
            new_right += plain_right.charAt(E[i] - 1);
        }
        String str = "";
        for (int i = 0; i < 48; i++) {
            if (new_right.charAt(i) == key.charAt(i)) {
                str += "0";
            } else {
                str += "1";
            }
        }
        System.out.println("fun res = " + str + " , " + str.length());
        return str;
    }

    public static String s_boxes(String fun_x_or_result) {
        String str = "";
        /**
         * *****splet to 8 blocks of 6 bits**********
         */
        System.out.println("fun_x_or_result = " + fun_x_or_result + " , " + fun_x_or_result.length());
        ArrayList<String> blocks_plain_fun = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < 8; i++) {
            String plain_left = fun_x_or_result.substring(i * 6, 6 + count);
            count += 6;
            /**
             * ***** or multiplied in i+1;***
             */
            blocks_plain_fun.add(plain_left);
            System.out.println("plain_left =[" + i + " ]= " + plain_left);
        }
        //System.out.println("blocks_plain_fun.size() = " + blocks_plain_fun.size());
        for (int i = 0; i < blocks_plain_fun.size(); i++) {
            System.out.println("i ======================================" + i);
            String s = "" + blocks_plain_fun.get(i).charAt(0) + blocks_plain_fun.get(i).charAt(5);
            String s1 = "" + blocks_plain_fun.get(i).substring(1, 5);
            int decimal = Integer.parseInt(s, 2);//row number
            //System.out.println("decimal = " + decimal);

            int decimal1 = Integer.parseInt(s1, 2);// coulumn number
            // System.out.println("decimal1 = " + decimal1);
            Integer[][] mat = array_s_boxs.get(i);
            //int [][] mat1=mat;
            int var = mat[decimal][decimal1];
            System.out.println("mat[" + decimal + " ][ " + decimal1 + "] = " + var);
            String s_res = Integer.toBinaryString(var);
            //System.out.println("s_res = " + s_res + " , " + s_res.length());
            if (var < 2) {
                s_res = "000" + s_res;
            } else if (var < 4) {
                s_res = "00" + s_res;
            } else if (var < 8) {
                s_res = "0" + s_res;
            }
            System.out.println("s_res = " + s_res + " , " + s_res.length());
            str += s_res;
        }
        String y = "";
        for (int i = 0; i < P.length; i++) {
            y += str.charAt(P[i] - 1);

        }
        System.out.println("sboxs res  = " + y + " , " + y.length());
        return y;
    }
}
