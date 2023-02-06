import java.io.*;
import java.util.*;

public class Main {
    private static boolean validK(int Tmax, int[] d, int K) {
        PriorityQueue<Integer> offTimes = new PriorityQueue<>();
        int nextOff = 0;
        for(int i: d) {
            if(offTimes.size() == K) {
                nextOff = offTimes.poll();
            }
            if(nextOff+i > Tmax) {
                return false;
            }
            offTimes.offer(nextOff+i);
        }
        while(!offTimes.isEmpty()) {
            if(offTimes.poll() > Tmax) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Tmax = Integer.parseInt(st.nextToken());
        int[] d = new int[N];
        for(int i = 0; i < N; i++) {
            d[i] = Integer.parseInt(f.readLine());
        }
        int low = 1;
        int high = N;
        int K = -1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(validK(Tmax,d,mid)) {
                K = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        out.println(K);
        f.close();
        out.close();
    }
}
