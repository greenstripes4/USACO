import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int t = 0; t < testcases; t++){
            if(t > 0){
                out.println();
            }
            f.readLine();
            int N = Integer.parseInt(f.readLine());
            int[][] jobs = new int[N][3];
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                int T = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());
                jobs[i][0] = i+1;
                jobs[i][1] = T;
                jobs[i][2] = S;
            }
            Arrays.sort(jobs, new Comparator<int[]>() {
                @Override
                public int compare(int[] ints, int[] t1) {
                    if(ints[1]*t1[2] == ints[2]*t1[1]) {
                        return ints[0]-t1[0];
                    }
                    return ints[1]*t1[2]-ints[2]*t1[1];
                }
            });
            out.print(jobs[0][0]);
            for(int i = 1; i < jobs.length; i++){
                out.print(" " + jobs[i][0]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
