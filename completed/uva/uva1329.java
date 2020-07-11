import java.io.*;
import java.util.*;

public class Main{
    private static int getDistance(int[] leaderIds, int I) {
        int distance = 0;
        while(I != leaderIds[I]) {
            distance += Math.abs(leaderIds[I]-I)%1000;
            I = leaderIds[I];
        }
        return distance;
    }
    private static void union(int[] leaderIds, int I, int J) {
        leaderIds[I] = J;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(f.readLine());
            int[] leaderIds = new int[N+1];
            for(int i = 1; i <= N; i++) {
                leaderIds[i] = i;
            }
            String input;
            while(!(input = f.readLine()).equals("O")) {
                StringTokenizer st = new StringTokenizer(input);
                String command = st.nextToken();
                if(command.equals("E")) {
                    int I = Integer.parseInt(st.nextToken());
                    out.println(getDistance(leaderIds,I));
                } else {
                    int I = Integer.parseInt(st.nextToken());
                    int J = Integer.parseInt(st.nextToken());
                    union(leaderIds,I,J);
                }
            }
        }
        f.close();
        out.close();
    }
}
