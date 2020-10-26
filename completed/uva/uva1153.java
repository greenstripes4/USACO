import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int cases = f.nextInt();
        for(int t = 0; t < cases; t++) {
            if(t > 0) {
                out.println();
            }
            int n = f.nextInt();
            int[][] tasks = new int[n][2];
            for(int i = 0; i < n; i++) {
                tasks[i][0] = f.nextInt();
                tasks[i][1] = f.nextInt();
            }
            Arrays.sort(tasks, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if(ints[1] == t1[1]) {
                        return ints[0]-t1[0];
                    }
                    return ints[1]-t1[1];
                }
            });
            PriorityQueue<Integer> accepted = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1-integer;
                }
            });
            int time = 0;
            for(int i = 0; i < n; i++) {
                accepted.offer(tasks[i][0]);
                time += tasks[i][0];
                if(time > tasks[i][1]) {
                    time -= accepted.poll();
                }
            }
            out.println(accepted.size());
        }
        f.close();
        out.close();
    }
}
