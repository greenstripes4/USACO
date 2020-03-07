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
        String input;
        while(!(input = f.readLine()).equals("0")){
            int n = Integer.parseInt(input);
            TreeMap<Integer,Integer> allBills = new TreeMap<>();
            long total = 0;
            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int k = Integer.parseInt(st.nextToken());
                for(int j = 0; j < k; j++){
                    int nextBill = Integer.parseInt(st.nextToken());
                    allBills.put(nextBill,allBills.getOrDefault(nextBill,0)+1);
                }
                int least = allBills.firstKey();
                int greatest = allBills.lastKey();
                total += (greatest-least);
                if(allBills.get(least) == 1){
                    allBills.remove(least);
                } else {
                    allBills.put(least,allBills.get(least)-1);
                }
                if(allBills.get(greatest) == 1){
                    allBills.remove(greatest);
                } else {
                    allBills.put(greatest,allBills.get(greatest)-1);
                }
            }
            out.println(total);
        }
        out.close();
        f.close();
    }
}
