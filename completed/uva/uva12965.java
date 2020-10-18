import java.io.*;
import java.util.*;

public class Main{
    private static int binarySearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length-1;
        int ans = arr.length;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] > val) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[] producers = new int[P+1];
            int[] consumers = new int[C];
            st = new StringTokenizer(f.readLine());
            for(int i = 1; i <= P; i++) {
                producers[i] = Integer.parseInt(st.nextToken());
            }
            if(C > 0) {
                st = new StringTokenizer(f.readLine());
                for(int i = 0; i < C; i++) {
                    consumers[i] = Integer.parseInt(st.nextToken());
                }
            } else {
                f.readLine();
            }
            Arrays.sort(producers);
            Arrays.sort(consumers);
            int bestPrice = -1;
            int minAngry = P+C+1;
            for(int i = 0; i <= P; i++) {
                int temp = binarySearch(consumers, producers[i])+P-i;
                if(temp < minAngry) {
                    bestPrice = producers[i];
                    minAngry = temp;
                }
            }
            for(int i = 0; i < C; i++) {
                int temp = P-binarySearch(producers, consumers[i])+i+1;
                if(temp < minAngry) {
                    bestPrice = consumers[i];
                    minAngry = temp;
                } else if(temp == minAngry) {
                    bestPrice = Math.min(bestPrice, consumers[i]);
                }
            }
            out.println(bestPrice + " " + minAngry);
        }
        f.close();
        out.close();
    }
}
