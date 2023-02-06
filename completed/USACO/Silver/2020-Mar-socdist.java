/*
ID: strongh2
LANG: JAVA
PROG: socdist
TASK: socdist
 */

import java.io.*;
import java.util.*;

public class Main{
    private static long getNextPosition(long[][] intervals, long curPos, int ind, long D){
        while(ind < intervals.length){
            if(curPos+D >= intervals[ind][0] && curPos+D <= intervals[ind][1]){
                return curPos+D;
            }
            if(curPos+D <= intervals[ind][0]){
                return intervals[ind][0];
            }
            ind++;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[][] intervals = new long[M][2];
        for(int i = 0; i < M; i++){
            StringTokenizer interval = new StringTokenizer(f.readLine());
            intervals[i][0] = Long.parseLong(interval.nextToken());
            intervals[i][1] = Long.parseLong(interval.nextToken());
        }
        Arrays.sort(intervals, new Comparator<long[]>() {
            @Override
            public int compare(long[] longs, long[] t1) {
                if(longs[0] == t1[0]){
                    return 0;
                }
                return longs[0] > t1[0] ? 1:-1;
            }
        });
        long D = (intervals[M-1][1]-intervals[0][0]+1)/(N-1);
        while(D > 0){
            long curPos = intervals[0][0];
            long prevPos;
            int ind = 0;
            int peopleSeparated = 1;
            while(peopleSeparated < N){
                prevPos = curPos;
                curPos = getNextPosition(intervals,curPos,ind,D);
                if(curPos == -1 || curPos - prevPos < D){
                    break;
                }
                if(curPos > intervals[ind][1]){
                    ind++;
                }
                peopleSeparated++;
            }
            if(peopleSeparated == N){
                out.println(D);
                break;
            }
            D--;
        }
        f.close();
        out.close();
    }
}
