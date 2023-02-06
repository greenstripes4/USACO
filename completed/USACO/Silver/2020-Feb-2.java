import java.io.*;
import java.util.*;

public class Main {
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
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("triangles.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
        int N = Integer.parseInt(f.readLine());
        HashMap<Integer, ArrayList<ArrayList<Integer>>> X = new HashMap<>();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> Y = new HashMap<>();
        int[][] points = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(!X.containsKey(y)) {
                X.put(y, new ArrayList<>(2));
                X.get(y).add(new ArrayList<>());
                X.get(y).add(new ArrayList<>());
            }
            if(!Y.containsKey(x)) {
                Y.put(x, new ArrayList<>(2));
                Y.get(x).add(new ArrayList<>());
                Y.get(x).add(new ArrayList<>());
            }
            X.get(y).get(0).add(x);
            Y.get(x).get(0).add(y);
            points[i][0] = x;
            points[i][1] = y;
        }
        for(ArrayList<ArrayList<Integer>> i: X.values()) {
            Collections.sort(i.get(0));
            i.get(1).add(0);
            for(int j = 0; j < i.get(0).size(); j++) {
                i.get(1).add(i.get(1).get(i.get(1).size()-1)+i.get(0).get(j));
            }
        }
        for(ArrayList<ArrayList<Integer>> i: Y.values()) {
            Collections.sort(i.get(0));
            i.get(1).add(0);
            for(int j = 0; j < i.get(0).size(); j++) {
                i.get(1).add(i.get(1).get(i.get(1).size()-1)+i.get(0).get(j));
            }
        }
        long sum = 0;
        for(int[] p: points) {
            ArrayList<Integer> horizontal = X.get(p[1]).get(0);
            ArrayList<Integer> horpref = X.get(p[1]).get(1);
            ArrayList<Integer> vertical = Y.get(p[0]).get(0);
            ArrayList<Integer> vertpref = Y.get(p[0]).get(1);
            int splitHor = lower(horizontal, p[0])+1;
            int splitVer = lower(vertical, p[1])+1;
            long val1 = p[0]*splitHor-horpref.get(splitHor)+horpref.get(horpref.size()-1)-horpref.get(splitHor)-p[0]*(horpref.size()-splitHor-1);
            long val2 = p[1]*splitVer-vertpref.get(splitVer)+vertpref.get(vertpref.size()-1)-vertpref.get(splitVer)-p[1]*(vertpref.size()-splitVer-1);
            sum = (sum+val1*val2)%1000000007;
        }
        out.println(sum);
        f.close();
        out.close();
    }
}
