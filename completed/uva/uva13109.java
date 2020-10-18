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
        for(int t = 0; t < testcases; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[] elephants = new int[M];
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < M; i++) {
                elephants[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(elephants);
            int numElephants = 0;
            int totalWeight = 0;
            for(int i = 0; i < M; i++) {
                if(totalWeight+elephants[i] <= W) {
                    numElephants++;
                    totalWeight += elephants[i];
                } else {
                    break;
                }
            }
            out.println(numElephants);
        }
        f.close();
        out.close();
    }
}
