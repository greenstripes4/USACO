import org.jfree.chart.labels.IntervalCategoryItemLabelGenerator;

import java.util.*;
import java.io.*;

public class Main{
    static ArrayList<Integer> possibleValues = new ArrayList<>();
    public static void generateSubsets(int[][] liquids, int ind, int totalVal, int totalVol, int allowedVolume){
        for(int i = ind+1; i < liquids.length; i++) {
            if (totalVol + liquids[i][0] > allowedVolume) {
                possibleValues.add(totalVal);
            } else {
                generateSubsets(liquids, i, totalVal + liquids[i][1], totalVol + liquids[i][0], allowedVolume);
                generateSubsets(liquids, i, totalVal, totalVol, allowedVolume);
            }
        }
        possibleValues.add(totalVal);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("mixing.txt"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixing.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int totalVolume = l*w*h;
        StringTokenizer testSets = new StringTokenizer(f.readLine());
        int sets = Integer.parseInt(testSets.nextToken());
        int lines = Integer.parseInt(testSets.nextToken());
        for(int i = 0; i < sets; i++){
            int[][] liquids = new int[lines][2];
            for(int j = 0; j < lines; j++){
                StringTokenizer liquid = new StringTokenizer(f.readLine());
                liquids[j][0] = Integer.parseInt(liquid.nextToken());
                liquids[j][1] = Integer.parseInt(liquid.nextToken());
            }
            generateSubsets(liquids,-1,0,0,totalVolume);
            int max = 0;
            for(int j: possibleValues){
                if(j > max){
                    max = j;
                }
            }
            out.println(max);
            possibleValues.clear();
        }
        f.close();
        out.close();
    }
}
