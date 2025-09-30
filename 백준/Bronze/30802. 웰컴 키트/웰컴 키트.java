import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p_num = sc.nextInt();

        int[] shirt_list = new int[6];
        for(int i = 0; i < 6; i++){
            shirt_list[i] = sc.nextInt();   
        }

        int T, P;
        T = sc.nextInt();
        P = sc.nextInt();
        
        int t_result = 0;
        int p_set = 0, p_indv = 0;

        for(int i = 0; i < 6; i++){
            if(shirt_list[i] != 0){
                t_result += (int)Math.ceil(shirt_list[i]/(double)T);
            }
        }

        if(p_num < P){
            p_set = 0;
            p_indv = p_num;
        }else{
            p_set = p_num/P;
            p_indv = p_num % P;
        }
        
        System.out.println(t_result);
        System.out.println(p_set + " " + p_indv);
        
    }
}