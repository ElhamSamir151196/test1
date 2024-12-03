/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A4_security;

import static java.lang.Math.pow;
import java.math.BigInteger;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author dell
 */
public class A4 {
    static JTextArea Area;
    public static void main_A4(JTextArea AreaText,int choose,int n,int a){
        Area=AreaText;
        if(choose==1){//task 1
            boolean found=Test_Prime(n);
            System.out.println("\nIs " + n + " prime ? " + found);
            Area.append("\nIs " + n + " prime ? " +found+"\n" );
        }else if(choose==2){//
            int phi_number=phi(n);
            System.out.println("\nΦ(" + n + ") = " +phi_number);
            Area.append("\nΦ(" + n + ") = " +phi_number+"\n" );
        }else if(choose==3){
            Relative_prime(a,n);
        }else{
            Area.append("\nSorry wrong entery\n");
        }
        Area.append("\n------------------------------------------------------------------------------------------\n");
        
    }
    
    

    public static boolean Test_Prime(int n) {
        boolean prime = false;
        if(n==2){
            System.out.println("\nn is prime number.");
            Area.append("\nn is  prime number.\n");
            return true;
        }
        if (n % 2 == 0) {
            System.out.println("\nn is even number.");
            Area.append("\nn is even number.\n");
            return false;
        }
        int q = n - 1, k = 0;
        System.out.println(" q= " + q + " , k = " + k);
        while (q % 2 == 0) {
            q /= 2;
            k++;
            System.out.println(" q= " + q + " , k = " + k);
        }
        prime = true;
        for (int a = 1; a <= n - 1; a++) {
           // for(int a=21;a<=21;a++){
            // System.out.println("pow(a,q)%n = "+pow(a,q)%n+"  , pow(a,q) = "+pow(a,q));
            BigInteger base = BigInteger.valueOf(a);
            BigInteger power = base.pow(q);
            BigInteger n1 = BigInteger.valueOf(n);
            BigInteger mod_number = power.mod(n1);

            BigInteger res1 = BigInteger.valueOf(1);
            BigInteger res = BigInteger.valueOf(n - 1);
            //System.out.println("mod_number = "+mod_number +" , res = "+res1 +" ,----> "+(res1.equals(mod_number)));
            if (res1.equals(mod_number) || res.equals(mod_number)) {
                System.out.println("\ncontdition 1  available at a = " + a);
                Area.append("\ncontdition 1  available at a = " + a+"\n");
                continue;
            } else {
                for (int j = 0; j <= k - 1; j++) {

                    

                    /*BigInteger base2=BigInteger.valueOf(2);
                    BigInteger power2=base.pow(j);
                    BigInteger q1=BigInteger.valueOf(q);
                    BigInteger j1=power2.multiply(q1);
                     */
                    int p = (int) pow(2, j);
                    int j1 = p * q;
                    
                    BigInteger base1 = BigInteger.valueOf(a);
                    BigInteger power1 = base.pow(j1);
                   System.out.println(" pow(a,pow(2,j)*q) = "+power1);
                    BigInteger mod_number1 = power1.mod(n1);
                    System.out.println("At a = " + a + "j = " + j + " , n = " + n + " ,q =" + q + "mod_number = " + mod_number1);
                   System.out.println(" power = " + j1);
                    if (mod_number1.equals(res))//pow(a,pow(2,j)*q)%n ==n-1)
                    {

                        break;

                    }
                    if (j == k - 1) {
                        // System.out.println("********************************************");
                        prime = false;
                    }
                }
            }
            if (prime == false) {
                System.out.println("\nBoth conditions fail at a = " + a);
                Area.append("\nBoth conditions fail at a = " + a+"\n");
                break;
            }
        }

        return prime;
    }

    public static int phi(int n) {
        int size = 1;
        ArrayList<Integer> Array_relative = new ArrayList<>();
        ArrayList<Integer> Array = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                Array.add(i);
            }
        }Area.append("\n can divided by {");
        for (int i = 0; i < Array.size(); i++) {
            System.out.println(Array.get(i));
            Area.append(Array.get(i)+"    ");
        }Area.append("}\n");
        if( Array.size()==0){
            Area.append("\n empty because it's prime.\n");
        }
        Area.append("\nThe values is : {");
        
        for (int i = 1; i < n; i++) {

            boolean found = false;
            for (int j = 0; j < Array.size(); j++) {
                if (i % Array.get(j) == 0) {
                    found = true;
                    break;
                }
            }
            if (found == false) {
                Array_relative.add(i);
                System.out.print(i + "   ");
                Area.append(i + "   ");

            }
        }Area.append(" } \n");
        size = Array_relative.size();
        Area.append("\nΦ(" + n + ") = " +size+"\n" );
        return size;
    }

    public static void Relative_prime(int a, int n) {

        int x = phi(n);
        if (pow(a, x) % n == 1) {
            System.out.println("it's relative prime .");
            Area.append("\nit's relative prime .\n");
        } else {
            System.out.println("it's not relative prime .");
            Area.append("\nit's not relative prime ---> because "+a+" pow("+x+") %"+ n+" = "+(pow(a, x) % n)+".\n");
        }
    }
    
}
