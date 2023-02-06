/*
ID: strongh2
LANG: JAVA
PROG: milk3
TASK: milk3
 */

import java.io.*;
import java.util.*;

public class milk3{
    static int aLimit, bLimit, cLimit;
    static HashSet<String> beenTo = new HashSet<>();
    static ArrayList<Integer> validValues = new ArrayList<>();
    public static void recur(int a, int b, int c){
        if(beenTo.contains(a + " " + b + " " + c)){
            return;
        }
        beenTo.add(a + " " + b + " " + c);
        if(a == 0){
            validValues.add(c);
        }
        recur(Math.max(0,a - (bLimit - b)), Math.min(bLimit, a + b), c);
        recur(Math.max(0,a - (cLimit - c)), b, Math.min(cLimit, a + c));
        recur(Math.min(aLimit,a + b), Math.max(0, b - (aLimit - a)), c);
        recur(a, Math.max(0, b - (cLimit - c)), Math.min(cLimit, b + c));
        recur(Math.min(aLimit,a + c), b, Math.max(0, c- (aLimit - a)));
        recur(a, Math.min(bLimit, b + c), Math.max(0, c - (bLimit - b)));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        aLimit = Integer.parseInt(st.nextToken());
        bLimit = Integer.parseInt(st.nextToken());
        cLimit = Integer.parseInt(st.nextToken());
        recur(0,0,cLimit);
        Collections.sort(validValues);
        String inBetween = "";
        for(int i: validValues){
            out.print(inBetween + i);
            inBetween = " ";
        }
        out.println();
        out.close();
        f.close();
    }
}
