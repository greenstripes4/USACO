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
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        while(T-- > 0) {
            int n = f.nextInt();
            int[][] sticks = new int[n][2];
            for(int i = 0; i < n; i++) {
                sticks[i][0] = f.nextInt();
                sticks[i][1] = f.nextInt();
            }
            Arrays.sort(sticks, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[0]-t1[0];
                }
            });
            ArrayList<Integer> stacks = new ArrayList<Integer>();
            for(int[] i: sticks) {
                int idx = binarySearch(stacks, i[1]);
                if(idx < 0) {
                    stacks.add(i[1]);
                } else {
                    stacks.set(idx, i[1]);
                }
                Collections.sort(stacks);
            }
            out.println(stacks.size());
        }
        f.close();
        out.close();
    }
}
