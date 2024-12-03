/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a1_security;

import static a1_security.Q2.Area;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author dell
 */
public class Q1 {
    static JTextArea Area;
     public  void main_Q1(int choose,ArrayList<Integer> list,int num_operation,int id,JTextArea jTextArea) {
         Area=jTextArea;
      //  java.util.Scanner input = new java.util.Scanner(System.in);
        //System.out.println("Enter a a way to enter the number 1)Z-field 2)list . else consider exit  : ");
        //int choose = input.nextInt();
       // ArrayList<Integer> list = new ArrayList<>();

       /* if (choose == 1) {
            System.out.println("Enter length of the array : ");
            int num = input.nextInt();

            for (int i = 0; i < num; i++) {
                list.add(i);
            }

        } else if (choose == 2) {
            System.out.println("Enter length of the array : ");
            int num = input.nextInt();
            System.out.println("Enter elements in array where it is less than  " + num);
            for (int i = 0; i < num; i++) {
                System.out.println("Enter element number " + i + " in array : ");
                int value = input.nextInt();
                while (value >= num) {
                    System.out.println("Wrong Entery.");
                    System.out.println("Enter element number " + i + " in array : ");
                    value = input.nextInt();
                }
                list.add(value);
            }

        } else {
            System.out.println("Now you will exit.");
            return;
        }
     */
       // System.out.println("Enter Group operation (  1)Addition, 2)subtraction, 3)Multiplication) else cosider exit. : ");
        //int num_operation = input.nextInt();
        //System.out.println("Enter Identity element : ");
        //int id = input.nextInt();
        if (num_operation == 1) {

            if (Addition(list, id)) {
                System.out.println("It's Group.");
                Area.append("It's Group.\n");
            } else {
                System.out.println("It's not Group.");
                Area.append("It's not Group.\n");
            }

        } else if (num_operation == 2) {

            if (Subtraction(list, id)) {
                System.out.println("It's Group.");
                Area.append("It's Group.\n");
            } else {
                System.out.println("It's not Group.");
                 Area.append("It's not Group\n");
            }
        } else if (num_operation == 3) {
            if (Multiplication(list, id)) {
                System.out.println("It's Group.");
                Area.append("It's Group.\n");
            } else {
                System.out.println("It's not Group.");
                Area.append("It's not Group\n");
            }
        } else {
            System.out.println("Now you will exit.");
             Area.append("Now you will exit.\n");
            return;
        }

    }

    public static boolean Addition(ArrayList<Integer> list, int id) {

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
             Area.append(list.get(i)+"\n");
        }
        /**
         * ****cummulative***
         */
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int n1 = list.get(i) + list.get(j);
                int n2 = list.get(j) + list.get(i);
                if (n1 != n2) {
                    System.out.println(" not group -->not cummulative case becuse  " + n1 + "  !=" + n2);
                    Area.append(" not group -->not cummulative case becuse  " + n1 + "  !=" + n2+"\n");
                    return false;
                }

            }
        }

        /**
         * **** Asscoiative ***
         */
        for (int i = 0; i < list.size() - 2; i++) {
            int n1 = (list.get(i) + list.get(i + 1)) + list.get(i + 2);
            int n2 = list.get(i) + (list.get(i + 1) + list.get(i + 2));
            if (n1 != n2) {
                System.out.println("not group ----> not Asscoiative case becuse  " + n1 + "  !=" + n2);
                 Area.append("not group ----> not Asscoiative case becuse  " + n1 + "  !=" + n2+"\n");
                return false;
            }
        }

        /**
         * ************closed*********************
         */
        boolean found;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                found = false;
                int n1 = (list.get(i) + list.get(j)) % list.size();
                //System.out.println("i =  "+ i+" , j = "+ j);
                //System.out.println("list.get(i) = "+list.get(i)+"list.get(j) "+list.get(j)+"n1 = "+n1);
                for (int s = 0; s < list.size(); s++) {
                    if (n1 == list.get(s)) {
                        // System.out.println("error");
                        found = true;
                        break;
                    }
                }
                if (found == false) {
                    System.out.println(" not group -->not closedcase becuse  " + n1 + "  ! in array.");
                    Area.append(" not group -->not closedcase becuse  " + n1 + "  ! in array."+"\n");
                    return false;
                }

            }
        }

        /**
         * ************Identity *****************************
         */
        for (int i = 0; i < list.size(); i++) {
            int n1 = (list.get(i) + id) % list.size();
            if (n1 != list.get(i)) {
                System.out.println(" not group -->not  Identiety case becuse  " + n1 + "  ! in array.");
                Area.append(" not group -->not  Identiety case becuse  " + n1 + "  ! in array."+"\n");
                return false;
            }
        }

        /**
         * *****************************inverse **********************
         */
        boolean found1;
       
        
         int[][] table = new int[list.size()][list.size()];
         for(int i=0;i<list.size();i++){System.out.print(list.get(i)+"   ");}
         System.out.println("\n-----------------------------------------------------------------------------");
         Area.append("\n-----------------------------------------------------------------------------"+"\n");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
               // System.out.println("i = "+i+", j = "+ j+ ", (i + j) % length  = "+ (i + j) % length);
                table[i][j] = (list.get(i) + list.get(j)) % list.size();
                System.out.print(table[i][j]+"    ");
                Area.append(table[i][j]+"    ");
            }
            System.out.println("");
            Area.append("\n");

        }
       // ArrayList<Integer> addtive_inv = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            found1=false;
            int count=0;
            for (int j = 0; j < list.size(); j++) {
                
                if (table[i][j] == 0) {
                    
                    count++;
                    if(count==list.size()){
                        found1=true;
                    }
                }else{
                    break;
                }
            }
            for (int j = 0; j < list.size()&&found1!=true; j++) {
                
                if (table[i][j] == id) {
                    //addtive_inv.add(j);//row isindex . col is j.
                    //System.out.println(j);
                    found1=true;
                    break;
                    
                }else{
                    found1=false;
                }
            }
            if(found1==false){
                 System.out.println(" not group -->not  Inverse case becuse  inverse  ! in array.");
                 Area.append(" not group -->not  Inverse case becuse  inverse  ! in array."+"\n");
                return false;
            }

        }
        
       /* for (int i = 0; i < list.size(); i++) {
            int n1 = (id - list.get(i)) % list.size();
            found1 = false;
            if (n1 < 0) {
                n1 += list.size();
            }
            for (int j = 0; j < list.size(); j++) {
                if (n1 == list.get(j)) {
                    found1 = true;
                    break;
                }
            }
            if (found1 == false) {
                System.out.println(" not group -->not  Inverse case becuse  " + n1 + "  ! in array.");
                return false;
            }

        }*/

        return true;
    }

    public static boolean Subtraction(ArrayList<Integer> list, int id) {
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        /**
         * ****cummulative***
         */
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int n1 = list.get(i) - list.get(j);
                int n2 = list.get(j) - list.get(i);
                /*if(n1<0){n1+=list.size();}
                if(n2<0){n2+=list.size();}*/
                if (n1 != n2) {
                    System.out.println(" not group -->not cummulative case becuse  " + n1 + "  !=" + n2);
                    Area.append(" not group -->not cummulative case becuse  " + n1 + "  !=" + n2+"\n");
                    return false;
                }

            }
        }

        /**
         * **** Asscoiative ***
         */
        for (int i = 0; i < list.size() - 2; i++) {
            int n1 = (list.get(i) - list.get(i + 1)) - list.get(i + 2);
            int n2 = list.get(i) - (list.get(i + 1) - list.get(i + 2));
            if(n1<0){n1+=list.size();}
            if(n2<0){n2+=list.size();}
            if (n1 != n2) {
                System.out.println("not group ----> not Asscoiative case becuse  " + n1 + "  !=" + n2);
                
                
                return false;
            }
        }

        /**
         * ************closed*********************
         */
        boolean found;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                found = false;
                int n1 = (list.get(i) - list.get(j)) % list.size();
                if(n1<0){n1+=list.size();}
                //System.out.println("i =  "+ i+" , j = "+ j);
                //System.out.println("list.get(i) = "+list.get(i)+"list.get(j) "+list.get(j)+"n1 = "+n1);
                for (int s = 0; s < list.size(); s++) {
                    if (n1 == list.get(s)) {
                        // System.out.println("error");
                        found = true;
                        break;
                    }
                }
                if (found == false) {
                    System.out.println(" not group -->not closedcase becuse  " + n1 + "  ! in array.");
                    Area.append(" not group -->not closedcase becuse  " + n1 + "  ! in array."+"\n");
                    return false;
                }

            }
        }

        /**
         * ************Identity *****************************
         */
        for (int i = 0; i < list.size(); i++) {
            int n1 = (list.get(i) - id) % list.size();
            if(n1<0){n1+=list.size();}
            if (n1 != list.get(i)) {
                System.out.println(" not group -->not  Identiety case becuse  " + n1 + "  ! in array.");
                Area.append(" not group -->not  Identiety case becuse  " + n1 + "  ! in array."+"\n");
                return false;
            }
        }

        /**
         * *****************************inverse **********************
         */
        /**
         * *****************************inverse **********************
         */
        boolean found1;
       
        
         int[][] table = new int[list.size()][list.size()];
         for(int i=0;i<list.size();i++){System.out.print(list.get(i)+"   ");}
         System.out.println("\n-----------------------------------------------------------------------------");
         Area.append("\n-----------------------------------------------------------------------------"+"\n");
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
               // System.out.println("i = "+i+", j = "+ j+ ", (i + j) % length  = "+ (i + j) % length);
                table[i][j] = (list.get(i) - list.get(j)) % list.size();
                System.out.print(table[i][j]+"    ");
                Area.append(table[i][j]+"    ");
            }
            System.out.println("");
            Area.append("\n");

        }
       // ArrayList<Integer> addtive_inv = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            found1=false;
            int count=0;
            for (int j = 0; j < list.size(); j++) {
                
                if (table[i][j] == 0) {
                    
                    count++;
                    if(count==list.size()){
                        found1=true;
                    }
                }else{
                    break;
                }
            }
            for (int j = 0; j < list.size()&&found1!=true; j++) {
                
                if (table[i][j] == id) {
                    //addtive_inv.add(j);//row isindex . col is j.
                    //System.out.println(j);
                    found1=true;
                    break;
                    
                }else{
                    found1=false;
                }
            }
            if(found1==false){
                 System.out.println(" not group -->not  Inverse case becuse  inverse  ! in array.");
                 Area.append(" not group -->not  Inverse case becuse  inverse  ! in array."+"\n");
                return false;
            }

        }
        
       /* boolean found1;
        for (int i = 0; i < list.size(); i++) {
            int n1 = (id + list.get(i)) % list.size();
            found1 = false;
            if (n1 < 0) {
                n1 += list.size();
            }
            for (int j = 0; j < list.size(); j++) {
                if (n1 == list.get(j)) {
                    found1 = true;
                    break;
                }
            }
            if (found1 == false) {
                System.out.println(" not group -->not  Inverse case becuse  " + n1 + "  ! in array.");
                return false;
            }

        }*/

        return true;
    }

    public static boolean Multiplication(ArrayList<Integer> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            Area.append(list.get(i)+"\n");
        }
        /**
         * ****cummulative***
         */
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int n1 = list.get(i) * list.get(j);
                int n2 = list.get(j) * list.get(i);
                if (n1 != n2) {
                    System.out.println(" not group -->not cummulative case becuse  " + n1 + "  !=" + n2);
                    Area.append(" not group -->not cummulative case becuse  " + n1 + "  !=" + n2+"\n");
                    return false;
                }

            }
        }

        /**
         * **** Asscoiative ***
         */
        for (int i = 0; i < list.size() - 2; i++) {
            int n1 = (list.get(i) * list.get(i + 1)) * list.get(i + 2);
            int n2 = list.get(i) * (list.get(i + 1) * list.get(i + 2));
            if (n1 != n2) {
                System.out.println("not group ----> not Asscoiative case becuse  " + n1 + "  !=" + n2);
                Area.append("not group ----> not Asscoiative case becuse  " + n1 + "  !=" + n2+"\n");
                return false;
            }
        }

        /**
         * ************closed*********************
         */
        boolean found;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                found = false;
                int n1 = (list.get(i) * list.get(j)) % list.size();
                //System.out.println("i =  "+ i+" , j = "+ j);
                //System.out.println("list.get(i) = "+list.get(i)+"list.get(j) "+list.get(j)+"n1 = "+n1);
                for (int s = 0; s < list.size(); s++) {
                    if (n1 == list.get(s)) {
                        // System.out.println("error");
                        found = true;
                        break;
                    }
                }
                if (found == false) {
                    System.out.println(" not group -->not closedcase becuse  " + n1 + "  ! in array.");
                    Area.append(" not group -->not closedcase becuse  " + n1 + "  ! in array."+"\n");
                    return false;
                }

            }
        }

        /**
         * ************Identity *****************************
         */
        for (int i = 0; i < list.size(); i++) {
            int n1 = (list.get(i) * id) % list.size();
            if (n1 != list.get(i)) {
                System.out.println(" not group -->not  Identiety case becuse  " + n1 + "  ! in array.");
                 Area.append(" not group -->not  Identiety case becuse  " + n1 + "  ! in array."+"\n");
                return false;
            }
        }

        /**
         * *****************************inverse **********************
         */
        boolean found1;
        
         int[][] table = new int[list.size()][list.size()];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
               // System.out.println("i = "+i+", j = "+ j+ ", (i + j) % length  = "+ (i + j) % length);
                table[i][j] = (list.get(i) * list.get(j)) % list.size();
                System.out.print(table[i][j]+"    ");
                 Area.append(table[i][j]+"    ");
            }
            System.out.println("");
             Area.append("\n");
        }
       // ArrayList<Integer> addtive_inv = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            found1=false;
            int count=0;
            for (int j = 0; j < list.size(); j++) {
                
                if (table[i][j] == 0) {
                    
                    count++;
                    if(count==list.size()){
                        found1=true;
                    }
                }else{
                    break;
                }
            }
            for (int j = 0; j < list.size()&&found1!=true; j++) {
                
                if (table[i][j] == id) {
                    //addtive_inv.add(j);//row isindex . col is j.
                    //System.out.println(j);
                    found1=true;
                    break;
                    
                }else{
                    found1=false;
                }
            }
            if(found1==false){
                 System.out.println(" not group -->not  Inverse case becuse  inverse  ! in array.");
                 Area.append(" not group -->not  Inverse case becuse  inverse  ! in array."+"\n");
                return false;
            }

        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      /*  for (int i = 0; i < list.size(); i++) {
           found1=false;
           // System.out.println("*******************************************************");
            for (int j = 0; j < list.size(); j++) {
                if((list.get(i)==0)&&(list.get(j)==0)){
                    found1=true;
                    break;
                }
               System.out.println("herer         ="+list.get(i)*list.get(j));
                 if(((list.get(i)*list.get(j))%list.size()==id)){
                   System.out.println("herer         ="+list.get(i)*list.get(j));
                   found1=true;
                   break;
               }
            }
            if (found1 == false) {
                System.out.println(" not group -->not  Inverse case becuse  inverse  ! in array.");
                return false;
            }

        }*/
        return true;
    }
    
}
