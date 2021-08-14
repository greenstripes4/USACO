import java.io.*;
import java.util.*;

public class Main {
    private static int floor(int[][] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid][0] <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static boolean isValid(int O, int r, int x, int y) {
        long dx = Math.abs(x-O);
        long dy = Math.abs(y);
        return dx*dx+dy*dy <= r*r;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] circles = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            circles[i][0] = Integer.parseInt(st.nextToken());
            circles[i][1] = Integer.parseInt(st.nextToken());
            circles[i][0] -= circles[i][1];
            circles[i][2] = i;
        }
        Arrays.sort(circles, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        int[] first = new int[n];
        Arrays.fill(first, -1);
        int ans = 0;
        int m = Integer.parseInt(f.readLine());
        for(int i = 1; i <= m; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int j = floor(circles, x);
            if(j >= 0 && first[circles[j][2]] < 0 && isValid(circles[j][0]+circles[j][1], circles[j][1], x, y)) {
                first[circles[j][2]] = i;
                ans++;
            }
            if(j-1 >= 0 && first[circles[j-1][2]] < 0 && isValid(circles[j-1][0]+circles[j-1][1], circles[j-1][1], x, y)) {
                first[circles[j-1][2]] = i;
                ans++;
            }
        }
        out.println(ans);
        out.print(first[0]);
        for(int i = 1; i < n; i++) {
            out.print(" " + first[i]);
        }
        out.println();
        f.close();
        out.close();
    }
}