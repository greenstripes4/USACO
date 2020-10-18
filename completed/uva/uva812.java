import java.io.*;
import java.util.*;

public class Main{
    private static TreeSet<Integer> possibleOptimalPurchases;
    private static void getPossibleOptimalPurchases(ArrayList<Integer>[] optimalPurchases, int workyard, int currentPurchases) {
        if(workyard == optimalPurchases.length) {
            possibleOptimalPurchases.add(currentPurchases);
            return;
        }
        for(int i: optimalPurchases[workyard]) {
            getPossibleOptimalPurchases(optimalPurchases, workyard+1, currentPurchases+i);
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int testcase = 1;
        while(!(input = f.readLine()).equals("0")) {
            if(testcase > 1) {
                out.println();
            }
            int w = Integer.parseInt(input);
            ArrayList<Integer>[] optimalPurchases = new ArrayList[w];
            int maximumProfit = 0;
            for(int i = 0; i < w; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                int b = Integer.parseInt(st.nextToken());
                ArrayList<Integer> workyardOptimalPurchases = new ArrayList<>();
                workyardOptimalPurchases.add(0);
                int maximumWorkyardProfit = 0;
                int currentWorkyardProfit = 0;
                for(int j = 0; j < b; j++) {
                    currentWorkyardProfit += 10-Integer.parseInt(st.nextToken());
                    if(currentWorkyardProfit > maximumWorkyardProfit) {
                        workyardOptimalPurchases.clear();
                        maximumWorkyardProfit = currentWorkyardProfit;
                    }
                    if(currentWorkyardProfit >= maximumWorkyardProfit) {
                        workyardOptimalPurchases.add(j+1);
                    }
                }
                optimalPurchases[i] = workyardOptimalPurchases;
                maximumProfit += maximumWorkyardProfit;
            }
            possibleOptimalPurchases = new TreeSet<>();
            getPossibleOptimalPurchases(optimalPurchases, 0, 0);
            out.println("Workyards " + testcase);
            out.println("Maximum profit is " + maximumProfit + ".");
            out.print("Number of pruls to buy:");
            int alreadyPrinted = 0;
            for(int i: possibleOptimalPurchases) {
                if(alreadyPrinted == 10) {
                    break;
                }
                out.print(" " + i);
                alreadyPrinted++;
            }
            out.println();
            testcase++;
        }
        f.close();
        out.close();
    }
}
