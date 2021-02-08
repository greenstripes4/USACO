import java.io.*;
import java.util.*;

public class Main {
    private static int binarySearch(int[][] arr, Integer[] ind, int tar) {
        int low = 0;
        int high = ind.length-1;
        int ans = ind.length;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr[ind[mid]][0] < tar) {
                ans = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(f.readLine());
            int[][] arr = new int[n][2];
            Integer[] ind = new Integer[n];
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
                ind[j] = j;
            }
            Arrays.sort(ind, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    if(arr[integer][0] == arr[t1][0]) {
                        return arr[t1][1]-arr[integer][1];
                    }
                    return arr[integer][0]-arr[t1][0];
                }
            });
            int[] min = new int[n];
            min[0] = ind[0];
            for(int j = 1; j < n; j++) {
                if(arr[ind[j]][1] < arr[min[j-1]][1]) {
                    min[j] = ind[j];
                } else {
                    min[j] = min[j-1];
                }
            }
            int[] ans = new int[n];
            for(int j = 0; j < n; j++) {
                int temp = binarySearch(arr, ind, arr[ind[j]][0]);
                if(temp == n) {
                    int temp2 = binarySearch(arr, ind, arr[ind[j]][1]);
                    if(temp2 == n) {
                        ans[ind[j]] = -1;
                    } else {
                        int temp3 = min[temp2];
                        if(arr[temp3][1] < arr[ind[j]][0]) {
                            ans[ind[j]] = temp3+1;
                        } else {
                            ans[ind[j]] = -1;
                        }
                    }
                } else {
                    int temp2 = min[temp];
                    if(arr[temp2][1] < arr[ind[j]][1]) {
                        ans[ind[j]] = temp2+1;
                    } else {
                        int temp3 = binarySearch(arr, ind, arr[ind[j]][1]);
                        if(temp3 == n) {
                            ans[ind[j]] = -1;
                        } else {
                            int temp4 = min[temp3];
                            if(arr[temp4][1] < arr[ind[j]][0]) {
                                ans[ind[j]] = temp4+1;
                            } else {
                                ans[ind[j]] = -1;
                            }
                        }
                    }
                }
            }
            out.print(ans[0]);
            for(int j = 1; j < n; j++) {
                out.print(" " + ans[j]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}