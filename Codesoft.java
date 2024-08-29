import java.util.*;
import java.util.Scanner;
public class Codesoft {
    public static void main(String[] args) {
        int maxattempts=5;
        int score =0;
        int i=0;
        Random ra= new Random();
        int a=ra.nextInt(100);
        System.out.println(a);
     Scanner sc = new Scanner (System.in) ;

    for( i=0;i<maxattempts;i++){
        int b=sc.nextInt();
    if(a==b){
        System.err.println("correct");
        score++;
    }
    else if ( a>b){
        System.err.println("too low");
    }
    else if(a<b){
        System.err.println("too high");
    }
}
    if (i==maxattempts){
        System.out.println("attempts over");
        System.out.println("do u want to play again");
    }
   
        System.out.println(score);
    
    sc.close();
}
    }


