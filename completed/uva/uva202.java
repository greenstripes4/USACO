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
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            StringBuilder sb = new StringBuilder();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            out.print(a + "/" + b + " = ");
            if(a*b < 0){
                sb.append("-");
            }
            a = Math.abs(a);
            b = Math.abs(b);
            sb.append(a/b);
            a %= b;
            a *= 10;
            int lengthOfCycle = 1;
            int ind = 0;
            sb.append(".");
            if(a != 0) {
                HashMap<Integer,Integer> map = new HashMap<>();
                while(a != 0 && !map.containsKey(a)){
                    sb.append(a/b);
                    map.put(a,sb.length()-1);
                    a %= b;
                    a *= 10;
                }
                if(a != 0){
                    ind = map.get(a)+1;
                    sb.insert(map.get(a),"(");
                    sb.append(")");
                    lengthOfCycle = sb.length()-map.get(a)-2;
                } else {
                    sb.append("(0)");
                }
            } else {
                sb.append("(0)");
            }
            if(lengthOfCycle <= 50){
                out.println(sb);
            } else {
                sb.replace(ind+50,sb.length(),"...)");
                out.println(sb);
            }
            out.println("   " + lengthOfCycle + " = number of digits in repeating cycle");
            out.println();
        }
        out.close();
        f.close();
    }
}
