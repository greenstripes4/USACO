import java.io.*;
import java.util.*;

public class Main {
        private static int lastLessThan(int[][] cows, ArrayList<Integer> positiveDirection, int upperBound) {
                int low = 0;
                int high = positiveDirection.size()-1;
                int ans = -1;
                while(low <= high) {
                        int mid = (low+high)/2;
                        if(cows[positiveDirection.get(mid)][1] < upperBound) {
                                low = mid+1;
                                ans = mid;
                        } else {
                                high = mid-1;
                        }
                }
                return ans;
        }
        private static int firstGreaterThan(int[][] cows, ArrayList<Integer> positiveDirection, int lowerBound) {
                int low = 0;
                int high = positiveDirection.size()-1;
                int ans = positiveDirection.size();
                while(low <= high) {
                        int mid = (low+high)/2;
                        if(cows[positiveDirection.get(mid)][1] > lowerBound) {
                                high = mid-1;
                                ans = mid;
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
                BufferedReader f = new BufferedReader(new FileReader("meetings.in"));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
                StringTokenizer st = new StringTokenizer(f.readLine());
                int N = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                int[][] cows = new int[N][4];
                Integer[] x = new Integer[N];
                Integer[] t = new Integer[N];
                int totalWeight = 0;
                for(int i = 0; i < N; i++) {
                        st = new StringTokenizer(f.readLine());
                        int wi = Integer.parseInt(st.nextToken());
                        int xi = Integer.parseInt(st.nextToken());
                        int di = Integer.parseInt(st.nextToken());
                        cows[i][0] = wi;
                        cows[i][1] = xi;
                        cows[i][2] = di;
                        if(di < 0) {
                                cows[i][3] = xi;
                        } else {
                                cows[i][3] = L-xi;
                        }
                        x[i] = i;
                        t[i] = i;
                        totalWeight += wi;
                }
                Arrays.sort(x, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer integer, Integer t1) {
                                return cows[integer][1]-cows[t1][1];
                        }
                });
                Arrays.sort(t, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer integer, Integer t1) {
                                return cows[integer][3]-cows[t1][3];
                        }
                });
                int leftCowIndex = 0;
                int rightCowIndex = N-1;
                ArrayList<Integer> negativeDirection = new ArrayList<>();
                ArrayList<Integer> positiveDirection = new ArrayList<>();
                int T = L;
                int weight = 0;
                for(int i = 0; i < N; i++) {
                        if(cows[t[i]][2] < 0) {
                                negativeDirection.add(t[i]);
                                weight += cows[x[leftCowIndex]][0];
                                leftCowIndex++;
                        } else {
                                positiveDirection.add(t[i]);
                                weight += cows[x[rightCowIndex]][0];
                                rightCowIndex--;
                        }
                        if(weight >= (totalWeight+1)/2) {
                                T = Math.min(T, cows[t[i]][3]);
                        }
                }
                Collections.reverse(positiveDirection);
                int collisions = 0;
                for(int i: negativeDirection) {
                        int end = lastLessThan(cows, positiveDirection, cows[i][1]);
                        if(end >= 0) {
                                int start = firstGreaterThan(cows, positiveDirection, cows[i][1]-2*T-1);
                                collisions += end-start+1;
                        }
                }
                out.println(collisions);
                f.close();
                out.close();
        }
}
