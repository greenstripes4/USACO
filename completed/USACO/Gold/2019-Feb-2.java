import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int higher(ArrayList<Stack<Integer>> arr, int tar, int low) {
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid).peek() > tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static boolean isValid(int k) {
        int[] order = new int[k];
        System.arraycopy(arr, 0, order, 0, k);
        Arrays.sort(order);
        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < k; i++) {
            if(arr[i] == order[idx1]) {
                idx1++;
                while(idx2 < stacks.size() && stacks.get(idx2).peek() == order[idx1]) {
                    stacks.get(idx2).pop();
                    if(stacks.get(idx2).isEmpty()) {
                        idx2++;
                    }
                    idx1++;
                }
            } else {
                int temp = higher(stacks, arr[i], idx2);
                if(temp == -1) {
                    stacks.add(new Stack<>());
                    stacks.get(stacks.size()-1).push(arr[i]);
                } else {
                    stacks.get(temp).push(arr[i]);
                }
            }
        }
        return idx1 == k;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dishes.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dishes.out")));
        int N = Integer.parseInt(f.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(f.readLine());
        }
        int low = 1;
        int high = N;
        int ans = low;
        while(low <= high) {
            int mid = (low+high)/2;
            if(isValid(mid)) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}