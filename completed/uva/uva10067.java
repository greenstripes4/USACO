import java.io.*;
import java.util.*;

public class Main{
    private static int move(int cur, int dir) {
        return (cur+dir+10)%10;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        while(N-- > 0) {
            int initial = 0;
            for(int i = 0; i < 4; i++) {
                initial = initial*10+f.nextInt();
            }
            int target = 0;
            for(int i = 0; i < 4; i++) {
                target = target*10+f.nextInt();
            }
            int n = f.nextInt();
            boolean[] forbidden = new boolean[10000];
            while(n-- > 0) {
                int temp = 0;
                for(int i = 0; i < 4; i++) {
                    temp = temp*10+f.nextInt();
                }
                forbidden[temp] = true;
            }
            if(forbidden[initial] || forbidden[target]) {
                out.println(-1);
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            queue.offer(initial);
            visited[initial] = true;
            int[] dir1 = {-1, 1, 0, 0, 0, 0, 0, 0};
            int[] dir2 = {0, 0, -1, 1, 0, 0, 0, 0};
            int[] dir3 = {0, 0, 0, 0, -1, 1, 0, 0};
            int[] dir4 = {0, 0, 0, 0, 0, 0, -1, 1};
            int steps = 0;
            boolean found = false;
            while(!queue.isEmpty()) {
                int size = queue.size();
                while(size-- > 0) {
                    int cur = queue.poll();
                    if(cur == target) {
                        found = true;
                        break;
                    }
                    int[] decoded = {cur/1000, (cur/100)%10, (cur/10)%10, cur%10};
                    for(int i = 0; i < 8; i++) {
                        int[] next = {move(decoded[0], dir1[i]), move(decoded[1], dir2[i]), move(decoded[2], dir3[i]), move(decoded[3], dir4[i])};
                        int encoded = next[0]*1000+next[1]*100+next[2]*10+next[3];
                        if(!forbidden[encoded] && !visited[encoded]) {
                            queue.offer(encoded);
                            visited[encoded] = true;
                        }
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            out.println(found ? steps : -1);
        }
        f.close();
        out.close();
    }
}
