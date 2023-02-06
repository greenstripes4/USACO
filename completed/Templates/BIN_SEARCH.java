import java.io.*;
import java.util.*;

public class Main {
    private static int arrLower(int[] arr, int tar) {
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
    private static int arrHigher(int[] arr, int tar) {
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
    private static int arrFloor(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int arrCeil(int[] arr, int tar) {
        int low = 0;
        int high = arr.length-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[mid] >= tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static int lisLower(ArrayList<Integer> lis, int tar) {
        int low = 0;
        int high = lis.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(lis.get(mid) < tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int lisHigher(ArrayList<Integer> lis, int tar) {
        int low = 0;
        int high = lis.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(lis.get(mid) > tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    private static int lisFloor(ArrayList<Integer> lis, int tar) {
        int low = 0;
        int high = lis.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(lis.get(mid) <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int lisCeil(ArrayList<Integer> lis, int tar) {
        int low = 0;
        int high = lis.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(lis.get(mid) >= tar) {
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        f.close();
        out.close();
    }
}
