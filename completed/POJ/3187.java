import java.io.*;
import java.util.*;

public class Main {
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private static boolean nextPermutation(int[] nums) {
        int idx = -1;
        for(int i = nums.length-1; i > 0; i--) {
            if(nums[i] > nums[i-1]) {
                idx = i;
                break;
            }
        }
        if(idx == -1) {
            Arrays.sort(nums);
            return false;
        }
        int min = -1;
        for(int i = idx; i < nums.length; i++) {
            if(nums[i] > nums[idx-1] && (min == -1 || nums[min] > nums[i])) {
                min = i;
            }
        }
        swap(nums, idx-1, min);
        for(int i = idx; i < nums.length; i++) {
            int temp = i;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[temp] > nums[j]) {
                    temp = j;
                }
            }
            swap(nums, i, temp);
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i+1;
        }
        do {
            int[] cur = arr.clone();
            for(int i = N; i > 1; i--) {
                int[] next = new int[i-1];
                for(int j = 0; j < i-1; j++) {
                    next[j] = cur[j]+cur[j+1];
                }
                cur = next;
            }
            if(cur[0] == sum) {
                out.print(arr[0]);
                for(int i = 1; i < arr.length; i++) {
                    out.print(" " + arr[i]);
                }
                out.println();
                break;
            }
        } while(nextPermutation(arr));
        f.close();
        out.close();
    }
}