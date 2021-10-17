import java.io.*;
import java.util.*;

public class Main {
    private static int lower(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] < tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int higher(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] > tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] bridges = new int[n][];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int k = Integer.parseInt(st.nextToken());
            bridges[i] = new int[k+2];
            bridges[i][0] = -1;
            for(int j = 1; j <= k; j++) {
                bridges[i][j] = Integer.parseInt(st.nextToken());
            }
            bridges[i][k+1] = 100001;
            Arrays.sort(bridges[i]);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            int[] left = bridges[(i+n-1)%n];
            int[] right = bridges[(i+1)%n];
            for(int j = 2; j < bridges[i].length-1; j++) {
                int c1 = lower(left, bridges[i][j])-higher(left, bridges[i][j-1])+1;
                int c2 = lower(right, bridges[i][j])-higher(right, bridges[i][j-1])+1;
                if(c1 != c2) {
                    cnt++;
                }
            }
        }
        out.println(cnt);
        f.close();
        out.close();
    }
}
