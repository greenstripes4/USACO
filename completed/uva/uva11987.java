import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] leaderIds = new int[n+1];
            for(int i = 1; i <= n; i++) {
                leaderIds[i] = i;
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(f.readLine());
                int command = Integer.parseInt(st.nextToken());
                if(command == 1) {
                    int I = Integer.parseInt(st.nextToken());
                    int J = Integer.parseInt(st.nextToken());
                    int leaderI = leaderIds[I];
                    int leaderJ = leaderIds[J];
                    for(int j = 1; j <= n; j++) {
                        if(leaderIds[j] == leaderI) {
                            leaderIds[j] = leaderJ;
                        }
                    }
                } else if(command == 2) {
                    int I = Integer.parseInt(st.nextToken());
                    int J = Integer.parseInt(st.nextToken());
                    leaderIds[I] = leaderIds[J];
                } else {
                    int I = Integer.parseInt(st.nextToken());
                    int count = 0;
                    int sum = 0;
                    for(int j = 1; j <= n; j++) {
                        if(leaderIds[j] == leaderIds[I]) {
                            count++;
                            sum += j;
                        }
                    }
                    out.println(count + " " + sum);
                }
            }
        }
        f.close();
        out.close();
    }
}
