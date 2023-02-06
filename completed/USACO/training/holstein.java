/*
ID: strongh2
LANG: JAVA
PROG: runround
TASK: runround
 */

import java.io.*;
import java.util.*;

public class holstein {
    private static ArrayList<Integer> minimumTaken;
    private static void getMinimumSupplements(int[] vitaminsLeft, int[][] supplements, int index, ArrayList<Integer> taken) {
        if(index == supplements.length) {
            for(int i: vitaminsLeft) {
                if(i > 0) {
                    return;
                }
            }
            if(taken.size() <= minimumTaken.size()) {
                minimumTaken = new ArrayList<>(taken);
            }
            return;
        }
        getMinimumSupplements(vitaminsLeft,supplements,index+1,taken);
        for(int i = 0; i < supplements[index].length; i++) {
            vitaminsLeft[i] -= supplements[index][i];
        }
        taken.add(index+1);
        getMinimumSupplements(vitaminsLeft,supplements,index+1,taken);
        for(int i = 0; i < supplements[index].length; i++) {
            vitaminsLeft[i] += supplements[index][i];
        }
        taken.remove(taken.size()-1);
    }
    public static void main(String[] args) throws IOException{
        Scanner f = new Scanner(new File("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        int V = f.nextInt();
        int[] vitamins = new int[V];
        minimumTaken = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            vitamins[i] = f.nextInt();
            minimumTaken.add(i+1);
        }
        int G = f.nextInt();
        int[][] supplements = new int[G][V];
        for(int i = 0; i < G; i++) {
            for(int j = 0; j < V; j++) {
                supplements[i][j] = f.nextInt();
            }
        }
        getMinimumSupplements(vitamins,supplements,0,new ArrayList<>());
        out.print(minimumTaken.size());
        for(int i: minimumTaken) {
            out.print(" " + i);
        }
        out.println();
        out.close();
        f.close();
    }
}
