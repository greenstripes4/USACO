import java.io.*;
import java.util.*;

public class Main{
    private static boolean isValid(int[] arr, int containers, int limit, int test) {
        int ind = 0;
        while(ind < arr.length && containers > 0) {
            int nextInd = ind;
            for(int i = 0; i < limit; i++) {
                nextInd++;
                if(nextInd == arr.length || arr[nextInd]-arr[ind] > test) {
                    break;
                }
            }
            ind = nextInd;
            containers--;
        }
        return ind == arr.length;
    }
    private static int binarySearch(int[] arr, int high, int containers, int limit) {
        int low = 0;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(isValid(arr, containers, limit, mid)) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("mooyomooyo.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.in")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        StringTokenizer arrivalTimes = new StringTokenizer(f.readLine());
        int[] t = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            t[i] = Integer.parseInt(arrivalTimes.nextToken());
            max = Math.max(max, t[i]);
        }
        Arrays.sort(t);
        out.println(binarySearch(t, max, M, C));
        f.close();
        out.close();
    }
}
