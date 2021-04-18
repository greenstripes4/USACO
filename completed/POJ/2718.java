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
        int cases = Integer.parseInt(f.readLine());
        for(int t = 0; t < cases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] arr = new int[st.countTokens()];
            int idx = 0;
            while(st.hasMoreTokens()) {
                arr[idx++] = Integer.parseInt(st.nextToken());
            }
            int ans = Integer.MAX_VALUE;
            do {
                if(arr[0] == 0 || (arr[arr.length/2] == 0 && arr.length > 2)) {
                    continue;
                }
                int num1 = 0;
                for(int i = 0; i < arr.length/2; i++) {
                    num1 = num1*10+arr[i];
                }
                int num2 = 0;
                for(int i = arr.length/2; i < arr.length; i++) {
                    num2 = num2*10+arr[i];
                }
                ans = Math.min(ans, Math.abs(num1-num2));
            } while(nextPermutation(arr));
            out.println(ans);
        }
        f.close();
        out.close();
    }
}