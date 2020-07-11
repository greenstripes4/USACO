import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken())/2;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        int M = points.length;
        for(int i = 0; i < N; i++){
            ArrayList<int[]> below = new ArrayList<>();
            ArrayList<int[]> above = new ArrayList<>();
            for(int j = 0; j < N; j++){
                if(points[i][1] > points[j][1]){
                    below.add(points[j]);
                } else {
                    above.add(points[j]);
                }
            }
            int belowIndex = 0;
            int aboveIndex = 0;
            while(belowIndex < below.size() || aboveIndex < above.size()){
                int xBorder = Integer.MAX_VALUE;
                if(belowIndex < below.size()) {
                    xBorder = Math.min(xBorder, below.get(belowIndex)[0]);
                }
                if(aboveIndex < above.size()) {
                    xBorder = Math.min(xBorder, above.get(aboveIndex)[0]);
                }
                while(belowIndex < below.size() && below.get(belowIndex)[0] == xBorder) {
                    belowIndex++;
                }
                while(aboveIndex < above.size() && above.get(aboveIndex)[0] == xBorder) {
                    aboveIndex++;
                }
                M = Math.min(M,Math.max(Math.max(belowIndex, below.size()-belowIndex),Math.max(aboveIndex,above.size()-aboveIndex)));
            }
        }
        out.println(M);
        f.close();
        out.close();
    }
}
