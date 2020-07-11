import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("closing.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++) {
            f.readLine();
            if(t > 0) {
                out.println();
            }
            StringTokenizer st = new StringTokenizer(f.readLine());
            int P = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            boolean[][] dancedWith = new boolean[P][P];
            for(int i = 0; i < D; i++) {
                StringTokenizer dance = new StringTokenizer(f.readLine());
                int a = Integer.parseInt(dance.nextToken());
                int b = Integer.parseInt(dance.nextToken());
                dancedWith[a][b] = true;
                dancedWith[b][a] = true;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            int[] giovanniNumbers = new int[P];
            while(!queue.isEmpty()) {
                int next = queue.poll();
                for(int i = 0; i < P; i++) {
                    if(dancedWith[next][i] && giovanniNumbers[i] == 0) {
                        giovanniNumbers[i] = giovanniNumbers[next]+1;
                        queue.add(i);
                    }
                }
            }
            for(int i = 1; i < P; i++) {
                out.println(giovanniNumbers[i]);
            }
        }
        f.close();
        out.close();
    }
}
