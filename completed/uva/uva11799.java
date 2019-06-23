import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(f.readLine());
        for (int i = 0; i < testCases; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int max = 0;
            while(st.hasMoreTokens()){
                int nt = Integer.parseInt(st.nextToken());
                if(nt > max){
                    max = nt;
                }
            }
            System.out.println("Case "+ (i + 1) + ": " + max);
        }
    }
}
