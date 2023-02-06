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
        long n = Long.parseLong(f.readLine());
        long totalSum  = ((1+n)*n)/2;
        if(totalSum % 2 == 1){
            out.println("NO");
        } else {
            out.println("YES");
            long desiredSum = totalSum/2;
            long cur = 0;
            long stopNum = -1;
            StringBuilder set1 = new StringBuilder();
            for(long i = n; i > 0; i--){
                if(cur + i > desiredSum){
                    set1.append(cur == desiredSum ? "" : desiredSum - cur);
                    stopNum = i;
                    break;
                } else {
                    cur += i;
                    set1.append(cur == desiredSum ? i : i + " ");
                }
            }
            StringBuilder set2 = new StringBuilder();
            for(int i = 1; i <= stopNum; i++){
                if(i != desiredSum - cur){
                    set2.append(i == stopNum || (i == stopNum - 1 && stopNum == desiredSum - cur) ? i : i + " ");
                }
            }
            String ans1 = set1.toString();
            String ans2 = set2.toString();
            StringTokenizer st1 = new StringTokenizer(ans1);
            StringTokenizer st2 = new StringTokenizer(ans2);
            out.println(st1.countTokens());
            out.println(ans1);
            out.println(st2.countTokens());
            out.println(ans2);
        }
        f.close();
        out.close();
    }
}
