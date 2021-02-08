import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) <= tar) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> ladders = new ArrayList<>();
        int start = 0;
        boolean up = true;
        for(int i = 1; i < n; i++) {
            if(a[i] < a[i-1] && up) {
                up = false;
            } else if(a[i] > a[i-1] && !up) {
                ladders.add(start);
                start = i;
                up = true;
            }
        }
        ladders.add(start);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int l = Integer.parseInt(st.nextToken())-1;
            int r = Integer.parseInt(st.nextToken())-1;
            int temp1 = binarySearch(ladders, l);
            int temp2 = binarySearch(ladders, r);
            if(temp1 == temp2 || ladders.get(temp2)-1 == l) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        f.close();
        out.close();
    }
}