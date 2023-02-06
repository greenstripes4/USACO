import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        while(T-- > 0) {
            st = new StringTokenizer(f.readLine());
            int lights = Integer.parseInt(st.nextToken(), 2);
            int switches = Integer.parseInt(st.nextToken(), 2);
            if(lights == 0) {
                out.println(0);
                continue;
            }
            for(int moves = 1; moves <= N; moves++) {
                int temp = lights;
                for(int i = 0; i < N; i++) {
                    if((switches&(1 << i)) > 0) {
                        int right = Math.min(moves, i+1);
                        int left = moves-right;
                        temp ^= (1 << (i+1))-1;
                        temp ^= (1 << (i-right+1))-1;
                        temp ^= (1 << N)-1;
                        temp ^= (1 << (N-left))-1;
                    }
                }
                int sum = 0;
                int cur = 0;
                int min = N;
                for(int i = 0; i < N; i++) {
                    if((temp&(1 << i)) > 0) {
                        cur++;
                    } else if(cur > 0) {
                        sum += (cur+moves-1)/moves;
                        min = Math.min(min, cur);
                        cur = 0;
                    }
                }
                if(cur > 0) {
                    sum += (cur+moves-1)/moves;
                    min = Math.min(min, cur);
                }
                if(sum <= moves && (sum%2 == moves%2 || min < moves)) {
                    out.println(moves);
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}
