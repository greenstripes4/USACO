/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("cecs.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[] arr = f.readLine().toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i: arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            } else {
                map.put(i,1);
            }
        }
        int odd = 0;
        for(char i: map.keySet()){
            if(map.get(i) % 2 == 1){
                odd++;
            }
        }
        if(odd > 1){
            out.println("NO SOLUTION");
        } else {
            StringBuilder sb = new StringBuilder();
            for(char i: map.keySet()){
                for(int j = 0; j < map.get(i)/2; j++){
                    sb.append(i);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for(char i: map.keySet()){
                if(map.get(i) % 2 == 1){
                    sb2.append(i);
                }
            }
            out.print(sb.toString() + sb2.toString());
            sb.reverse();
            out.println(sb.toString());
        }
        f.close();
        out.close();
    }
}
