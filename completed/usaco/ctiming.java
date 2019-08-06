/*
ID: strongh2
LANG: JAVA
PROG: ctiming
TASK: ctiming
*/

import java.io.*;
import java.util.StringTokenizer;
/*
O(1)
12 13 14
11 0 0
14 23 59
*/

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("ctiming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ctiming.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int diff1 = d-11;
        int diff2 = h-11;
        int diff3 = m-11;
        if(diff3 < 0){
            diff2--;
            diff3 += 60;
        }
        if(diff2 < 0){
            diff1--;
            diff2 += 24;
        }
        int total = diff1 * 1440 + diff2 * 60 + diff3;
        if(total < 0){
            out.println(-1);
        }
        else{
            out.println(total);
        }
        out.close();
        f.close();
    }
}
