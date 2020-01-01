import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("learning.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("learning.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] cows = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer cow = new StringTokenizer(f.readLine());
            String s = cow.nextToken();
            int w = Integer.parseInt(cow.nextToken());
            cows[i] = new int[]{w,s.equals("S") ? 1:0};
        }
        Arrays.sort(cows, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return 0;
                }
                return o1[0] > o2[0] ? 1:-1;
            }
        });
        int count = 0;
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < cows.length - 1; i++){
            int rightBorder;
            if((cows[i+1][0] + cows[i][0])%2 == 0){
                if(cows[i][1] == 0) {
                    rightBorder = (cows[i + 1][0] + cows[i][0]) / 2 - 1;
                } else {
                    rightBorder = (cows[i + 1][0] + cows[i][0]) / 2;
                }
            } else {
                rightBorder = (cows[i+1][0] + cows[i][0])/2;
            }
            if(cows[i][1] == 1){
                count += Math.max(0,Math.min(B,rightBorder) - Math.max(A,prev) + 1);
            }
            prev = rightBorder + 1;
        }
        count += Math.max(0,Math.min(B,Integer.MAX_VALUE) - Math.max(A,prev) + 1);
        out.println(count);
        f.close();
        out.close();
    }
}
