import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] steps = new ArrayList[200001];
        for(int i = 0; i <= 200000; i++) {
            steps[i] = new ArrayList<>();
        }
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++) {
            int ai = Integer.parseInt(st.nextToken());
            int count = 0;
            while(ai > 0) {
                steps[ai].add(count++);
                ai /= 2;
            }
            steps[0].add(count);
        }
        int min = Integer.MAX_VALUE;
        for(ArrayList<Integer> i: steps) {
            if(i.size() < k) {
                continue;
            }
            Collections.sort(i);
            int sum = 0;
            for(int j = 0; j < k; j++) {
                sum += i.get(j);
            }
            min = Math.min(min, sum);
        }
        out.println(min);
        f.close();
        out.close();
    }
}