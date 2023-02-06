import java.io.*;
import java.util.*;

public class Main{
    private static int upperBound(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] >= tar) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static int lowerBound(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] <= tar) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] locations = new int[N];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++) {
            locations[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(locations);
        for(int i = 0; i < Q; i++) {
            st = new StringTokenizer(f.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            out.println(Math.max(0, lowerBound(locations, B)-upperBound(locations, A)+1));
        }
        f.close();
        out.close();
    }
}
