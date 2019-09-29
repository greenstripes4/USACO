/*
ID: strongh2
LANG: JAVA
PROG: pprime
TASK: pprime
 */

import java.io.*;
import java.util.*;

public class pprime{
    public static boolean isPrime(int n){
        int root = (int) Math.ceil(Math.sqrt(n));
        for(int i = 2; i <= root; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        for(int i = 5; i < 10; i++){
            if(i >= a && i <= b && isPrime(i)){
                out.println(i);
            }
        }
        for(int j = 1; j < 10; j++){
            int n = j*10+j;
            if(n >= a && n <= b && isPrime(n)){
                out.println(n);
            }
        }
        for(int k = 10; k < 100; k++){
            int first = k/10;
            int last = k%10;
            int n = first*100 + last*10 + first;
            if(n >= a && n <= b && isPrime(n)){
                out.println(n);
            }
        }
        for(int l = 10;  l < 100; l++){
            int first = l/10;
            int last = l%10;
            int n = first*1000 + last*100 + last*10 + first;
            if(n >= a && n <= b && isPrime(n)){
                out.println(n);
            }
        }
        for(int m = 100; m < 1000; m++){
            int first = m/100;
            int second = (m/10)%10;
            int third = m%10;
            int n = first*10000 + second*1000 + third*100 + second*10 + first;
            if(n >= a && n <= b && isPrime(n)){
                out.println(n);
            }
        }
        for(int o = 100; o < 1000; o++){
            int first = o/100;
            int second = (o/10)%10;
            int third = o%10;
            int n = first*100000 + second*10000 + third*1000 + third*100 + second*10 + first;
            if(n >= a && n <= b && isPrime(n)){
                out.println(n);
            }
        }
        for(int p = 1000; p < 10000; p++){
            int first = p/1000;
            int second = (p/100)%10;
            int third = (p/10)%10;
            int fourth = p%10;
            int n = first*1000000 + second*100000 + third*10000 + fourth*1000 + third*100 + second*10 + first;
            if(n >= a && n <= b && isPrime(n)){
                out.println(n);
            }
        }
        for(int p = 1000; p < 10000; p++){
            int first = p/1000;
            int second = (p/100)%10;
            int third = (p/10)%10;
            int fourth = p%10;
            int n = first*10000000 + second*1000000 + third*100000 + fourth*10000 + fourth*1000 + third*100 + second*10 + first;
            if(n >= a && n <= b && isPrime(n)){
                out.println(n);
            }
        }
        out.close();
        f.close();
    }
}
