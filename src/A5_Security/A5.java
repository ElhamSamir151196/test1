/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A5_Security;

import static A4_security.A4.Relative_prime;
import static A4_security.A4.Test_Prime;
import static A4_security.A4.phi;
import static java.lang.Math.pow;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author dell
 */
public class A5 {
    static JTextArea Area;
    public static void main_A5(JTextArea AreaText,int choose,int firstpar,int secpara,int thirdpara){
        Area=AreaText;
        if(choose==1){//task 1
            PrimitiveRoot(firstpar,secpara);
           
        }else if(choose==2){
            DiscreteLogarithm(firstpar,secpara,thirdpara);
        }else{
            Area.append("\nSorry wrong entery\n");
        }
        Area.append("\n------------------------------------------------------------------------------------------\n");
        
    }
    
    public static void DiscreteLogarithm(int a,int p,int m){
        ArrayList<Integer> Array=new ArrayList<>();
         ArrayList<Long> Array_time=new ArrayList<>();
         long endTime=0 ;
        for(int b=1;b<=m;b++){
            long startTime = System.nanoTime();
            for(int i=0;i<=p-1;i++){
              
                 BigInteger base = BigInteger.valueOf(a);
        
        
            BigInteger power =  base.pow(i);
            BigInteger n1 = BigInteger.valueOf(p);
            BigInteger mod_number = power.mod(n1);
            BigInteger res1 = BigInteger.valueOf(b);
            System.out.println("pow(a,i) = "+mod_number);
              
                if(res1.equals(mod_number))//(pow(a,i)%p))
                {
                    System.out.println("pow(a,i) = "+mod_number);
                    Array.add(i);
                     endTime   = System.nanoTime();
                      long totalTime = endTime - startTime;
                    Array_time.add(totalTime);
                }
                
            }
        }
        

        Area.append("\nindex array {");
        for(int i=1;i<=m-1;i++){
            System.out.print(i+"  ,");
            Area.append(i+" , ");
        }Area.append("}\n");
        System.out.println("");Area.append("\n");
        Area.append("\n output array {");
        for(int i=2;i<=m;i++){
            System.out.print(Array.get(i-1)+" , ");
            Area.append(Array.get(i-1)+" , ");
        }Area.append("}\n");
        System.out.println("");Area.append("\n");
        Area.append("\n time array {");
         for(int i=0;i<Array_time.size();i++){
            System.out.print(Array_time.get(i)+" , ");
            Area.append(Array_time.get(i)+" , ");
        };Area.append("}\n");
    }
    public static void  PrimitiveRoot(int g,int n){
        ArrayList<Integer> Array_relative= phi(n);
        ArrayList<Boolean> ArrayFlag=new ArrayList<>();
        //boolean flag to relative phi of n array
        for(int i=0;i<Array_relative.size();i++){
            ArrayFlag.add(false);
        }
        //
        ArrayList<BigInteger> Array_equ=new ArrayList<>();
        for(int z=0;z<n-1;z++){
            BigInteger base = BigInteger.valueOf(g);
        
        
            BigInteger power =  base.pow(z);
            BigInteger n1 = BigInteger.valueOf(n);
            BigInteger mod_number = power.mod(n1);
            //BigInteger res1 = BigInteger.valueOf(b);
           // int a=((int)(pow(g,z))%n);
                Area.append(g+" power "+z+"mod "+n+" ="+mod_number+"\n");
            Array_equ.add(mod_number);
        }System.out.println("");Area.append("\n");
        for(int i=0;i<Array_equ.size();i++){
            System.out.print(Array_equ.get(i) + "   ");Area.append(Array_equ.get(i) + "   ");
        }System.out.println("");Area.append("\n");
        for(int i=0;i<Array_equ.size();i++){
           // System.out.println(Array_equ.get(i) + "   ");
            for(int j=0;j<Array_relative.size();j++){
                BigInteger res1 = BigInteger.valueOf(Array_relative.get(j));
                if(Array_equ.get(i).equals(res1)){
                    ArrayFlag.set(j, true);
                    break;
                }
                if(j==Array_relative.size()-1){
                    System.out.println("not primitive at a = "+Array_equ.get(i));
                    Area.append("not primitive at a = "+Array_equ.get(i)+"\n");
                    return ;
                }
            }
        }
        boolean exist=false;
        for(int i=0;i<Array_relative.size();i++){
            if(ArrayFlag.get(i)==false){
                exist=true;
                System.out.println("not primitive at a = "+Array_relative.get(i));
                Area.append("not primitive at a = "+Array_relative.get(i)+"\n");
                
            }
        }
        if(exist==false){
        
            System.out.println(" okay it's primitive numbers .");
            Area.append(" okay it's primitive numbers ."+"\n");
        }
        
    }
     public static ArrayList<Integer> phi(int n) {
        int size = 1;
        
        ArrayList<Integer> Array_relative = new ArrayList<>();
        ArrayList<Integer> Array = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                Array.add(i);
            }
        }//Area.append("\n can divided by {");
        for (int i = 0; i < Array.size(); i++) {
            System.out.println(Array.get(i));
            //Area.append(Array.get(i)+"    ");
        }//Area.append("}\n");
        if( Array.size()==0){
           // Area.append("\n empty because it's prime.\n");
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
        return Array_relative;
    }
    
}
