import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("berries.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        int[] trees = new int[N];
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        int[] needed = new int[Math.min(N, K)];
        int average = 0;
        int ind = 0;
        for(int i = N-1; i >= N-Math.min(N, K); i--) {
            needed[ind++] = trees[i];
            average += trees[i];
        }
        average /= Math.min(N, K);
        int max = 0;
        while(average >= 1) {
            ArrayList<Integer> buckets = new ArrayList<>();
            for(int i = 0; i < Math.min(N, K); i++) {
                for(int j = 0; j < needed[i]/average; j++) {
                    buckets.add(average);
                }
                if(needed[i]%average >= 1) {
                    buckets.add(needed[i]%average);
                }
            }
            Collections.sort(buckets);
            if(buckets.size() >= K) {
                int current = 0;
                for(int i = buckets.size()-K/2-1; i >= buckets.size()-K; i--) {
                    current += buckets.get(i);
                }
                max = Math.max(max, current);
            }
            average--;
        }
        out.println(max);
        f.close();
        out.close();
    }
}
