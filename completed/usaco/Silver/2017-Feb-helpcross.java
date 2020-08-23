import java.io.*;
import java.util.*;

public class Main {
    private static int ceiling(ArrayList<Integer> T, int start) {
        int low = 0;
        int high = T.size()-1;
        int ans = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(T.get(mid) >= start) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("helpcross.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> T = new ArrayList<>();
        int[][] AB = new int[N][2];
        for(int i = 0; i < C; i++) {
            T.add(Integer.parseInt(f.readLine()));
        }
        for(int i = 0; i < N; i++) {
            StringTokenizer cow = new StringTokenizer(f.readLine());
            AB[i][0] = Integer.parseInt(cow.nextToken());
            AB[i][1] = Integer.parseInt(cow.nextToken());
        }
        Collections.sort(T);
        Arrays.sort(AB, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                if(ints[1] == t1[1]) {
                    return ints[0]-t1[0];
                }
                return ints[1]-t1[1];
            }
        });
        int pairs = 0;
        for(int[] i: AB) {
            int chicken = ceiling(T,i[0]);
            if(chicken != -1 && T.get(chicken) <= i[1]) {
                pairs++;
                T.remove(chicken);
            }
        }
        out.println(pairs);
        f.close();
        out.close();
    }
}
