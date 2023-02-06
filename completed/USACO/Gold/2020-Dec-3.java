import java.io.*;
import java.util.*;

public class Main {
    private static int floor(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) <= tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    private static int lower(ArrayList<Integer> arr, int tar) {
        int low = 0;
        int high = arr.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) < tar) {
                low = mid+1;
                ans = mid;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int ans = 1;
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                int max = Math.max(points[i][1], points[j][1]);
                int min = Math.min(points[i][1], points[j][1]);
                if(points[j][0]-points[i][0] < max-min) {
                    continue;
                }
                int s = points[j][0]-points[i][0];
                int lowerBound = max-s;
                int upperBound = min+s;
                ArrayList<Integer> left = new ArrayList<>();
                ArrayList<Integer> right = new ArrayList<>();
                for(int k = i; k <= j; k++) {
                    if(points[k][1] >= lowerBound && points[k][1] <= min) {
                        left.add(points[k][1]);
                    }
                    if(points[k][1] >= max && points[k][1] <= upperBound) {
                        right.add(points[k][1]);
                    }
                }
                Collections.sort(left);
                Collections.sort(right);
                int prev = lowerBound;
                for(int k: left) {
                    int l = floor(right, prev+s);
                    int r = floor(right, k+s);
                    ans += r-l+1;
                    prev = k+1;
                }
            }
        }
        for(int[] i: points) {
            int temp = i[0];
            i[0] = i[1];
            i[1] = temp;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                int max = Math.max(points[i][1], points[j][1]);
                int min = Math.min(points[i][1], points[j][1]);
                if(points[j][0]-points[i][0] < max-min) {
                    continue;
                }
                int s = points[j][0]-points[i][0];
                int lowerBound = max-s;
                int upperBound = min+s;
                ArrayList<Integer> left = new ArrayList<>();
                ArrayList<Integer> right = new ArrayList<>();
                for(int k = i; k <= j; k++) {
                    if(points[k][1] >= lowerBound && points[k][1] <= min) {
                        left.add(points[k][1]);
                    }
                    if(points[k][1] >= max && points[k][1] <= upperBound) {
                        right.add(points[k][1]);
                    }
                }
                Collections.sort(left);
                Collections.sort(right);
                int prev = lowerBound;
                for(int k: left) {
                    int l = floor(right, prev+s);
                    int r = lower(right, k+s);
                    ans += r-l+1;
                    prev = k+1;
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}