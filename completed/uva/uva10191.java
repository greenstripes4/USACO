import java.io.*;
import java.util.*;

public class Main{
    private static int[][] merge(int[][] intervals) {
        if(intervals.length == 0){
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                }
                return o1[0] < o2[0] ? -1:1;
            }
        });
        ArrayList<int[]> ans = new ArrayList<int[]>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int[] i: intervals){
            if(i[0] >= start && i[0] <= end){
                end = Math.max(end,i[1]);
            } else {
                ans.add(new int[]{start,end});
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new  int[]{start,end});
        int[][] res = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        int day = 1;
        while((input = f.readLine()) != null){
            int s = Integer.parseInt(input);
            int[][] intervals = new int[s][2];
            for(int i = 0; i < s; i++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                String[] start = st.nextToken().split(":");
                String[] end = st.nextToken().split(":");
                int startToInt = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
                int endToInt = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
                intervals[i][0] = startToInt;
                intervals[i][1] = endToInt;
            }
            int[][] merged = merge(intervals);
            int lastEnd = 600;
            int maxGap = 0;
            int startNap = -1;
            for(int[] i: merged){
                if(i[0]-lastEnd > maxGap){
                    maxGap = i[0]-lastEnd;
                    startNap = lastEnd;
                }
                lastEnd = i[1];
            }
            if(1080-lastEnd > maxGap){
                maxGap = 1080-lastEnd;
                startNap = lastEnd;
            }
            out.println("Day #" + day + ": the longest nap starts at " + startNap/60 + ":" + String.format("%02d",startNap%60) + " and will last for " + (maxGap/60 > 0 ? maxGap/60 + " hours and " + maxGap%60 + " minutes." : maxGap%60 + " minutes."));
            day++;
        }
        f.close();
        out.close();
    }
}
