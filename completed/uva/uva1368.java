/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            char[][] sequences = new char[m][n];
            for(int j = 0; j < m; j++){
                sequences[j] = f.readLine().toCharArray();
            }
            StringBuilder sb = new StringBuilder();
            int difference = 0;
            for(int j = 0; j < n; j++){
                HashMap<Character,Integer> map = new HashMap<>();
                map.put('A',0);
                map.put('T',0);
                map.put('G',0);
                map.put('C',0);
                for(char[] s: sequences){
                    map.put(s[j],map.get(s[j])+1);
                }
                char val = ' ';
                int occurances = 0;
                for(char c: map.keySet()){
                    if(val == ' ' || map.get(c) > occurances || (map.get(c) == occurances && c < val)){
                        val = c;
                        occurances = map.get(c);
                    }
                }
                sb.append(val);
                difference += (m-occurances);
            }
            out.println(sb);
            out.println(difference);
        }
        out.close();
        f.close();
    }
}
