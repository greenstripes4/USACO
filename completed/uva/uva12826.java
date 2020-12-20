import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] dR = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dC = {0, 1, 1, 1, 0, -1, -1, -1};
        String input;
        int testcase = 1;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;
            int r3 = Integer.parseInt(st.nextToken())-1;
            int c3 = Integer.parseInt(st.nextToken())-1;
            boolean[][] visited = new boolean[8][8];
            visited[r3][c3] = true;
            Queue<Integer> queueR = new LinkedList<>();
            Queue<Integer> queueC = new LinkedList<>();
            int steps = 0;
            visited[r1][c1] = true;
            queueR.offer(r1);
            queueC.offer(c1);
            boolean found = false;
            while(!queueR.isEmpty()) {
                int size = queueR.size();
                for(int i = 0; i < size; i++) {
                    int r = queueR.poll();
                    int c = queueC.poll();
                    if(r == r2 && c == c2) {
                        found = true;
                        break;
                    }
                    for(int j = 0; j < 8; j++) {
                        int nR = r+dR[j];
                        int nC = c+dC[j];
                        if(nR < 0 || nR >= 8 || nC < 0 || nC >= 8 || visited[nR][nC]) {
                            continue;
                        }
                        visited[nR][nC] = true;
                        queueR.offer(nR);
                        queueC.offer(nC);
                    }
                }
                if(found) {
                    break;
                }
                steps++;
            }
            out.println("Case " + testcase + ": " + steps);
            testcase++;
        }
        f.close();
        out.close();
    }
}
