import java.io.*;
import java.util.*;

public class Main{
    private static class Cow {
        private int x;
        private int y;
        private int p;
        private Cow(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
        private boolean canReach(Cow o) {
            int differenceX = Math.abs(x-o.x);
            int differenceY = Math.abs(y-o.y);
            return differenceX*differenceX+differenceY*differenceY <= p*p;
        }
    }
    private static void floodFill(Cow[] cows, boolean[] visited, int root) {
        visited[root] = true;
        for(int i = 0; i < cows.length; i++) {
            if(!visited[i] && cows[root].canReach(cows[i])) {
                floodFill(cows, visited, i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        Cow[] cows = new Cow[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int max = 0;
        for(int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            floodFill(cows, visited, i);
            int current = 0;
            for(boolean j: visited) {
                if(j) {
                    current++;
                }
            }
            max = Math.max(max, current);
        }
        out.println(max);
        f.close();
        out.close();
    }
}
