/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int l = Integer.parseInt(f.readLine());
        for(int k = 0; k < l; k++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int D = Integer.parseInt(st.nextToken());
            int I = Integer.parseInt(st.nextToken());
            int curNode = 1;
            for(int i = 0; i < D-1; i++){
                if(I%2 == 0){
                    curNode = curNode*2+1;
                } else {
                    curNode = curNode*2;
                }
                I = (I+1)/2;
            }
            out.println(curNode);
        }
        out.close();
        f.close();
    }
}
