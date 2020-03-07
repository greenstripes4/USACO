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
        StringTokenizer st = new StringTokenizer(f.readLine());
        int p = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        HashMap<String,Double> stats = new HashMap<>();
        for(int i = 0; i < p; i++){
            StringTokenizer party = new StringTokenizer(f.readLine());
            String name = party.nextToken();
            double percent = Double.parseDouble(party.nextToken());
            stats.put(name,percent);
        }
        for(int i = 0; i < g; i++){
            StringTokenizer guess = new StringTokenizer(f.readLine());
            double totalPercentage = 0;
            while(true){
                String next = guess.nextToken();
                if(next.equals("<")){
                    int n = Integer.parseInt(guess.nextToken());
                    if(totalPercentage < n){
                        out.println("Guess #" + (i+1) + " was correct.");
                    } else {
                        out.println("Guess #" + (i+1) + " was incorrect.");
                    }
                    break;
                } else if(next.equals(">")) {
                    int n = Integer.parseInt(guess.nextToken());
                    if(totalPercentage > n){
                        out.println("Guess #" + (i+1) + " was correct.");
                    } else {
                        out.println("Guess #" + (i+1) + " was incorrect.");
                    }
                    break;
                } else if(next.equals("<=")) {
                    int n = Integer.parseInt(guess.nextToken());
                    if(totalPercentage <= n){
                        out.println("Guess #" + (i+1) + " was correct.");
                    } else {
                        out.println("Guess #" + (i+1) + " was incorrect.");
                    }
                    break;
                } else if(next.equals(">=")) {
                    int n = Integer.parseInt(guess.nextToken());
                    if(totalPercentage >= n){
                        out.println("Guess #" + (i+1) + " was correct.");
                    } else {
                        out.println("Guess #" + (i+1) + " was incorrect.");
                    }
                    break;
                } else if(next.equals("=")) {
                    int n = Integer.parseInt(guess.nextToken());
                    if(totalPercentage == n){
                        out.println("Guess #" + (i+1) + " was correct.");
                    } else {
                        out.println("Guess #" + (i+1) + " was incorrect.");
                    }
                    break;
                } else if(!next.equals("+")) {
                    totalPercentage += stats.get(next);
                    DecimalFormat nearestTenth = new DecimalFormat("0.##");
                    totalPercentage = Double.parseDouble(nearestTenth.format(totalPercentage));
                }
            }
        }
        out.close();
        f.close();
    }
}
