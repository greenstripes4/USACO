import java.io.*;
import java.util.*;

public class Main{
    private static int[] bestOrder;
    private static int[] timeMissed;
    private static void solve(int[] programmes,int[][] alignmentPoints, boolean[] used, int[] order, int index) {
        if(index == order.length) {
            int[] curMissed = new int[alignmentPoints.length];
            for(int i = 0; i < alignmentPoints.length; i++) {
                curMissed[i] = Math.abs(alignmentPoints[i][1]);
            }
            int time = 0;
            for(int i: order) {
                time += i;
                for(int j = 0; j < alignmentPoints.length; j++) {
                    curMissed[j] = Math.min(curMissed[j], Math.abs(alignmentPoints[j][1]-time));
                }
            }
            int[] levelsMissed = new int[timeMissed.length];
            int ind = 0;
            for(int i = 0; i < alignmentPoints.length; i++) {
                if(i == 0) {
                    levelsMissed[0] += curMissed[i];
                    continue;
                }
                if(alignmentPoints[i][0] > alignmentPoints[i-1][0]) {
                    ind++;
                }
                levelsMissed[ind] += curMissed[i];
            }
            boolean better = false;
            for(int i = 0; i < levelsMissed.length; i++) {
                if(levelsMissed[i] < timeMissed[i]) {
                    better = true;
                } else if(levelsMissed[i] > timeMissed[i] && !better) {
                    break;
                }
            }
            if(better) {
                bestOrder = order.clone();
                timeMissed = levelsMissed;
            }
            return;
        }
        for(int i = 0; i < programmes.length; i++) {
            if(!used[i]) {
                order[index] = programmes[i];
                used[i] = true;
                solve(programmes, alignmentPoints, used, order, index+1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(true) {
            int p = f.nextInt();
            if(p == 0) {
                break;
            }
            int[] programmes = new int[p];
            for(int i = 0; i < p; i++) {
                programmes[i] = f.nextInt();
            }
            int a = f.nextInt();
            int[][] alignmentPoints = new int[a][2];
            for(int i = 0; i < a; i++) {
                alignmentPoints[i][0] = f.nextInt();
                alignmentPoints[i][1] = f.nextInt();
            }
            Arrays.sort(alignmentPoints, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            int distinct = 1;
            for(int i = 1; i < a; i++) {
                if(alignmentPoints[i][0] > alignmentPoints[i-1][0]) {
                    distinct++;
                }
            }
            bestOrder = new int[p];
            timeMissed = new int[distinct];
            Arrays.fill(timeMissed, Integer.MAX_VALUE);
            solve(programmes, alignmentPoints, new boolean[p], new int[p], 0);
            out.println("Data set " + testcase);
            out.print("Order:");
            for(int i = 0; i < p; i++) {
                out.print(" " + bestOrder[i]);
            }
            out.println();
            int sum = 0;
            for(int i: timeMissed) {
                sum += i;
            }
            out.println("Error: " + sum);
            testcase++;
        }
        f.close();
        out.close();
    }
}
