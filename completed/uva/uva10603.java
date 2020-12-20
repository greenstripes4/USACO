import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] capacities = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int d = Integer.parseInt(st.nextToken());
            if(capacities[2] <= d) {
                out.println("0 " + capacities[2]);
                continue;
            }
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    return ints[3]-t1[3];
                }
            });
            boolean[][] visited = new boolean[capacities[2]+1][capacities[2]+1];
            queue.offer(new int[]{0, 0, capacities[2], 0});
            visited[0][0] = true;
            int max = 0;
            int minTransferredWater = 0;
            while(!queue.isEmpty()) {
                int[] current = queue.poll();
                for(int i = 0; i < 3; i++) {
                    if(current[i] <= d && (current[i] > max || current[i] == max && current[3] < minTransferredWater)) {
                        max = current[i];
                        minTransferredWater = current[3];
                    }
                    if(max == d) {
                        break;
                    }
                    for(int j = 0; j < 3; j++) {
                        if(i != j) {
                            int[] next = current.clone();
                            int transferredWater = Math.min(current[i], capacities[j]-current[j]);
                            next[i] -= transferredWater;
                            next[j] += transferredWater;
                            if(!visited[next[0]][next[1]]) {
                                next[3] += transferredWater;
                                queue.offer(next);
                                visited[next[0]][next[1]] = true;
                            }
                        }
                    }
                }
                if(max == d) {
                    break;
                }
            }
            out.println(minTransferredWater + " " + max);
        }
        f.close();
        out.close();
    }
}
