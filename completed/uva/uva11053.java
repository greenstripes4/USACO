import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
                String input;
                while(!(input = f.readLine()).equals("0")) {
                    StringTokenizer st = new StringTokenizer(input);
                    int N = Integer.parseInt(st.nextToken());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    HashMap<Long, Integer> timer = new HashMap<>();
                    long cur = 0;
                    int time = 0;
                    while(!timer.containsKey(cur)) {
                        timer.put(cur, time);
                        cur = (((a*cur)%N*cur)%N+b)%N;
                        time++;
                    }
                    out.println(N-time+timer.get(cur));
                }
                f.close();
                out.close();
        }
}
