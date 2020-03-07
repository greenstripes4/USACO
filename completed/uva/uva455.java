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
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++){
            f.readLine();
            String str = f.readLine();
            for(int j = 1; j <= str.length(); j++){
                String tar = str.substring(0,j);
                if(str.replaceAll(tar,"").equals("")){
                    out.println(j);
                    break;
                }
            }
            if(i != N-1){
                out.println();
            }
        }
        out.close();
        f.close();
    }
}
