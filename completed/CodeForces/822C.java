import java.io.*;
import java.util.*;

public class Main {
    private static int higher(ArrayList<int[]> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid)[0] > tar) {
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
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[][] vouchers = new int[n][3];
        ArrayList<int[]>[] duration = new ArrayList[x+1];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(f.readLine());
            vouchers[i][0] = Integer.parseInt(st.nextToken());
            vouchers[i][1] = Integer.parseInt(st.nextToken());
            vouchers[i][2] = Integer.parseInt(st.nextToken());
            int length = vouchers[i][1]-vouchers[i][0]+1;
            if(length >= 0 && length <= x) {
                if(duration[length] == null) {
                    duration[length] = new ArrayList<>();
                }
                duration[length].add(new int[]{vouchers[i][0], vouchers[i][2], 1000000007});
            }
        }
        for(int i = 0; i <= x; i++) {
            if(duration[i] != null) {
                Collections.sort(duration[i], new Comparator<int[]>() {
                    @Override
                    public int compare(int[] ints, int[] t1) {
                        return ints[0]-t1[0];
                    }
                });
                duration[i].get(duration[i].size()-1)[2] = duration[i].get(duration[i].size()-1)[1];
                for(int j = duration[i].size()-2; j >= 0; j--) {
                    duration[i].get(j)[2] = Math.min(duration[i].get(j)[1], duration[i].get(j+1)[2]);
                }
            }
        }
        int ans = -1;
        for(int[] i: vouchers) {
            int left = x-(i[1]-i[0]+1);
            if(left >= 0 && left <= x && duration[left] != null) {
                int j = higher(duration[left], i[1]);
                if(j >= 0) {
                    int cost = i[2]+duration[left].get(j)[2];
                    if(ans < 0 || cost < ans) {
                        ans = cost;
                    }
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}