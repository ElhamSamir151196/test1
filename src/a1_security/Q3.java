/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1_security;

import static a1_security.Q2.Area;
import java.util.ArrayList;
import javax.swing.JTextArea;
//import java.util.Scanner;

/**
 *
 * @author dell
 */
public class Q3 {
  static  JTextArea Area;
    public  void main_Q3(ArrayList<Integer> A,ArrayList<Integer> B,ArrayList<Integer> C,int num_operation,JTextArea jTextArea1) {
        Area=jTextArea1;
      //  ArrayList<Integer> A = new ArrayList<>();
       // ArrayList<Integer> B = new ArrayList<>();
       // ArrayList<Integer> C = new ArrayList<>();
       // Scanner input = new Scanner(System.in);
       // System.out.println("Enter the number of elements in A : ");
       // int len_A = input.nextInt();
       /* for (int i = 0; i < len_A; i++) {
            System.out.println("Enter the elements in " + i + " : ");
            int value = input.nextInt();
            A.add(value);
        }
        System.out.println("Enter the number of elements in B : ");
        int len_B = input.nextInt();
        for (int i = 0; i < len_B; i++) {
            System.out.println("Enter the elements in " + i + " : ");
            int value = input.nextInt();
            B.add(value);
        }
        System.out.println("Enter the number of elements in C : ");
        int len_C = input.nextInt();
        for (int i = 0; i < len_C; i++) {
            System.out.println("Enter the elements in " + i + " : ");
            int value = input.nextInt();
            C.add(value);
        }*/

        /**
         * **********select operation********************
         */
       /* System.out.println("Enter Group operation (  1)Addition,  2)Multiplication , 3)subtraction, 4)division ,"
                + "5)inversion, else cosider exit. : ");
        int num_operation = input.nextInt();*/
        if (num_operation == 1) {
            Addition(A, B,C);
        } else if (num_operation == 2) {
            Multiplication(A, B, C);
        } else if (num_operation == 3) {
            Subtraction(A, B, C);
        } else if (num_operation == 4) {
            Division(A, B,C);
        } else if (num_operation == 5) {
            Inversion(A, C);
        } else {
            System.out.println("Now you will exit.");
            Area.append("Now you will exit.\n");
            return;
        }
    }
    
     public static ArrayList<Integer> Addition(ArrayList<Integer>l1,ArrayList<Integer>l2, ArrayList<Integer> P){
         for(int i=0;i<l1.size();i++){
             System.out.println(l1.get(i));
         }
         System.out.println("----------------------------------------");
         for(int i=0;i<l2.size();i++){
             System.out.println(l2.get(i));
         }
        ArrayList<Integer>add1=new ArrayList<Integer>();
          ArrayList<Integer>add2=new ArrayList<Integer>();
        int i=0,j=0,k=0;
        while(i<l1.size()&&j<l2.size()){
            if(l1.get(i)>l2.get(j)){
                add1.add(l1.get(i));
                i++;
            }
            else if(l1.get(i)<l2.get(j)){
                          
                add1.add(l2.get(j));
                j++;
                
            }
            else{
                k=(l1.get(i)+l2.get(j))%2;
                add2.add(k);
                i++;
                j++;
            }
        }
        if(i==l1.size()){
            while(j<l2.size()){
                add1.add(l2.get(j));
                j++;
            }
        }
        else{
              while(i<l1.size()){
                add1.add(l1.get(i));
                i++;
            }
        }
        
       
     /*   for(int i=0;i<l1.size();i++){
            for(int j=0;j<l2.size();j++){
                if(l1.get(i)==l2.get(j)){
                    int n=l1.get(i)+l2.get(j);
                    add1.add(n);
                   
                    
                }
               
            }
           
            
        }*/
        for(int s=0;s<add1.size();s++){
            System.out.print("x^"+add1.get(s));
            Area.append("x^"+add1.get(s));
            if(s!=add1.size()-1){
                System.out.print("+ ");
                Area.append("+");
            }
        }
        Area.append("\n");
        Reduced(add1,P);
        return add1;
        
    }


    public static void Multiplication(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> P) {
        ArrayList<ArrayList<Integer>> array=new ArrayList<>();
        for(int i=0;i<B.size();i++){
            ArrayList<Integer> arr=new ArrayList<>();
            for(int j=0;j<A.size();j++){
                arr.add(B.get(i)+A.get(j));
            }
            array.add(arr);
        }
        
        //int i=0;
        while(array.size()>1){
            //i++;
            
            ArrayList<Integer> x=Addition(array.get(0), array.get(1),P);
            array.set(0, x);
            array.remove(1);
        }
        for(int s=0;s<array.get(0).size();s++){
            System.out.print("x^"+array.get(0).get(s));
            Area.append("x^"+array.get(0).get(s));
            if(s!=array.get(0).size()-1){
                System.out.print("+ ");
                Area.append("+");
            }
        }
        Area.append("\n");
        Reduced(array.get(0),P);
       /* for(int i=0;i<array.get(0).size();i++){
            System.out.println("\n"+array.get(0).get(i));
        }*/
       
    }

    public static ArrayList<Integer> Subtraction(ArrayList<Integer> l1, ArrayList<Integer> l2, ArrayList<Integer> P) {

        ArrayList<Integer>add1=new ArrayList<Integer>();
          ArrayList<Integer>add2=new ArrayList<Integer>();
        int i=0,j=0,k=0;
        while(i<l1.size()&&j<l2.size()){
            if(l1.get(i)>l2.get(j)){
                add1.add(l1.get(i));
                i++;
            }
            else if(l1.get(i)<l2.get(j)){
                          
                add1.add(l2.get(j));
                j++;
                
            }
            else{
                 k=(l1.get(i)-l2.get(j))%2;
                 if(k<0){
                     k+=2;
                 }
                add2.add(k);
                i++;
                j++;
            }
        }
        if(i==l1.size()){
            while(j<l2.size()){
                add1.add(l2.get(j));
                j++;
            }
        }
        else{
              while(i<l1.size()){
                add1.add(l1.get(i));
                i++;
            }
        }
        
       
     /*   for(int i=0;i<l1.size();i++){
            for(int j=0;j<l2.size();j++){
                if(l1.get(i)==l2.get(j)){
                    int n=l1.get(i)+l2.get(j);
                    add1.add(n);
                   
                    
                }
               
            }
           
            
        }*/
        for(int s=0;s<add1.size();s++){
            System.out.print("x^"+add1.get(s));
            Area.append("x^"+add1.get(s));
            if(s!=add1.size()-1){
                System.out.print("+ ");
                Area.append("+");
            }
        }
        Area.append("\n");
        Reduced(add1,P);
       // ArrayList<Integer> arr=new ArrayList<>();
        return add1;
    }

    public static ArrayList<Integer> Division(ArrayList<Integer> A, ArrayList<Integer> B,ArrayList<Integer> P) {
        
        int maxA = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxA) {
                maxA = A.get(i);
            }
        }
        System.out.println("max A= " + maxA);
        Area.append("\n"+"max A= " + maxA+"\n");
        int maxB = B.get(0);
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) > maxB) {
                maxA = B.get(i);
            }
        }
        System.out.println("max B = " + maxB);
         Area.append("max B = " + maxB+"\n");
        
        int diff=maxA-maxB;
        int max;
        if(maxA>=maxB){
            max=maxA;
        }else{
            return A;
        }
        ArrayList<Integer> multi_arr=new ArrayList<>();
      //  addition=Addition(A,B);
        for(int i=0;i<B.size();i++){
            multi_arr.add(B.get(i)+diff);
            System.out.println("multi_arr[i]"+multi_arr.get(i));
            Area.append("multi_arr[i]"+multi_arr.get(i)+"\n");
        }
        for(int i=0;i<A.size();i++){
            System.out.println(A.get(i));
            Area.append(A.get(i)+"\n");
        }
        
       ArrayList<Integer> res=Subtraction(A,multi_arr,P);//new ArrayList<>();//Subtraction(A,multi_arr,P);
       Reduced(res,P);
       return res;
        
        
    }

    public static void Inversion(ArrayList<Integer> A, ArrayList<Integer> B) {

        String[][] s_box = {
            {"00", "01", "8D", "F6", "CB", "52", "7B", "D1", "E8", "4F", "29", "C0", "B0", "E1", "E5", "C7"},
            {"74", "B4", "AA", "4B", "99", "2B", "60", "5F", "58", "3F", "FD", "CC", "FF", "40", "EE", "B2"},
            {"3A", "6E", "5A", "F1", "55", "4D", "A8", "C9", "C1", "0A", "98", "15", "30", "44", "A2", "C2"},
            {"2C", "45", "92", "6C", "F3", "39", "66", "42", "F2", "35", "20", "6F", "77", "BB", "59", " 19"},
            {"1D", "FE", "37", "67", "2D", "31", "F5", "69", "A7", "64", "AB", "13", "54", "25", "E9", "09"},
            {"ED", "5C", "05", "CA", "4C", "24", "87", "BF", "18", "3E", "22", "F0", "51", "EC", "61", "17"},
            {"16", "5E", "AF", "D3", "49", "A6", "36", "43", "F4", "47", "91", "DF", "33", "93", "21", "3B"},
            {"79", "B7", "97", "85", "10", "B5", "BA", "3C", "B6", "70", "D0", "06", "A1", "FA", "81", "82"},
            {"83", "7E", "7F", "80", "96", "73", "BE", "56", "9B", "9E", "95", "D9", "F7", "02", "B9", "A4"},
            {"DE", "6A", "32", "6D", "D8", "8A", "84", "72", "2A", "14", "9F", "88", "F9", "DC", "89", "9A"},
            {"FB", "7C", "2E", "C3", "8F", "B8", "65", "48", "26", "C8", "12", "4A", "CE", "E7", "D2", "62"},
            {"0C", "E0", "1F", "EF", "11", "75", "78", "71", "A5", "8E", "76", "3D", "BD", "BC", "86", "57"},
            {"0B", "28", "2F", "A3", "DA", "D4", "E4", "0F", "A9", "27", "53", "04", "1B", "FC", "AC", "E6"},
            {"7A", "07", "AE", "63", "C5", "DB", "E2", "EA", "94", "8B", "C4", "D5", "9D", "F8", "90", "6B"},
            {"B1", "0D", "D6", "EB", "C6", "0E", "CF", "AD", "08", "4E", "D7", "E3", "5D", "50", "1E", "B3"},
            {"5B", "23", "38", "34", "68", "46", "03", "8C", "DD", "9C", "7D", "A0", "CD", "1A", "41", "1C"}
        };

        int maxA = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxA) {
                maxA = A.get(i);
            }
        }
        System.out.println("max = " + maxA);
        Area.append("\nmax = " + maxA+"\n");
        
        boolean found = false;
        String str = "";
        for (int i = 0; i <= maxA; i++) {
            System.out.print("i = " + i + " ,");
            Area.append("i = " + i + " ,");
            found = false;
            for (int j = 0; j < A.size(); j++) {
                if (A.get(j) == i) {
                    System.out.println("A.get(j) " + A.get(j));
                    Area.append("A.get(j) " + A.get(j));
                    str += "1";
                    found = true;
                    break;
                }

            }
            if (found == false) {
                str += "0";
            }
        }

        System.out.println("str = " + str);
        Area.append("str = " + str+"\n");
        String str1 = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            str1 += str.charAt(i);

        }
        System.out.println("str1 = " + str1);
        Area.append("str1 = " + str1+"\n");
        int decimal = Integer.parseInt(str1, 2);
        String hexStr = Integer.toString(decimal, 16);

        System.out.println("old hexa" + hexStr);
        Area.append("old hexa" + hexStr+"\n");

        char[] elements = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int row_index = 0, col_index = 0;
        for (int i = 0; i < elements.length; i++) {
            if (hexStr.charAt(0) == elements[i]) {
                row_index = i;
            }
            if (hexStr.length() != 1) {
                if (hexStr.charAt(1) == elements[i]) {
                    col_index = i;
                }
            }
        }
        String new_hexa = s_box[row_index][col_index];
        System.out.println("new_hexa = " + new_hexa);
        Area.append("new_hexa = " + new_hexa+"\n");
        
        int new_decimal = Integer.parseInt(new_hexa, 16);
        // System.out.println(Integer.toBinaryString(decimal));
        String s = Integer.toBinaryString(new_decimal);
        System.out.println("s = " + s);
        Area.append("s = " + s+"\n");
        ArrayList<Integer> new_equ = new ArrayList<>();
        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                new_equ.add(counter);
            }
            counter++;
        }

        for (int i = new_equ.size() - 1; i >= 0; i--) {
            System.out.print("x^" + new_equ.get(i));
            Area.append("x^" + new_equ.get(i));
            if (i != 0) {
                System.out.print("+");
                Area.append("+");
            }

        }
        Area.append("\n");

    }
    
    public static void Reduced(ArrayList<Integer> A,ArrayList<Integer> P){
        int maxA = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxA) {
                maxA = A.get(i);
            }
        }
        System.out.println("max = " + maxA);
        Area.append("\nmax A= " + maxA+"\n");
        int maxP = P.get(0);
        for (int i = 0; i < P.size(); i++) {
            if (P.get(i) > maxP) {
                maxP = P.get(i);
            }
        }
        System.out.println("max P = " + maxP);
        Area.append("max P = " + maxP+"\n");
        System.out.println("**********************************************************");
        Area.append("**********************************************************\n");
        if(maxA<maxP){
            System.out.println("Reduced Done.");
            Area.append("Reduced Done."+"\n");
            return;
        }
        else{
            
            ArrayList<Integer> add1=Division1(A, P,P);
             for(int s=0;s<add1.size();s++){
            System.out.print("x^"+add1.get(s));
            Area.append("x^"+add1.get(s));
            if(s!=add1.size()-1){
                System.out.print("+ ");
                Area.append("+");
            }
        }
         Area.append("\n");   
            Reduced(add1,P);
        }
        
        
    }
    public static ArrayList<Integer> Division1(ArrayList<Integer> A, ArrayList<Integer> B,ArrayList<Integer> P) {
        
        int maxA = A.get(0);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > maxA) {
                maxA = A.get(i);
            }
        }
        System.out.println("max A= " + maxA);
        Area.append("max A= " + maxA+"\n");   
        int maxB = B.get(0);
        for (int i = 0; i < B.size(); i++) {
            if (B.get(i) > maxB) {
                maxA = B.get(i);
            }
        }
        System.out.println("max B = " + maxB);
         Area.append("max B = " + maxB+"\n"); 
        
        int diff=maxA-maxB;
        int max;
        if(maxA>=maxB){
            max=maxA;
        }else{
            return A;
        }
        ArrayList<Integer> multi_arr=new ArrayList<>();
      //  addition=Addition(A,B);
        for(int i=0;i<B.size();i++){
            multi_arr.add(B.get(i  )+diff);
            System.out.println("multi_arr[i]"+multi_arr.get(i));
             Area.append("multi_arr[i]"+multi_arr.get(i)+"\n"); 
        }
        for(int i=0;i<A.size();i++){
            System.out.println(A.get(i));
            Area.append(A.get(i)+"    "); 
        }
        
       ArrayList<Integer> res=Subtraction(A,multi_arr,P);//new ArrayList<>();//Subtraction(A,multi_arr,P);
       return res;
        
        
    }

    
}
