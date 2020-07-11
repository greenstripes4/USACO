import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int i = 0; i < N; i++) {
            int P = Integer.parseInt(f.readLine());
            int[] lengths = new int[P];
            int minLength = Integer.MAX_VALUE;
            for(int j = 0; j < P; j++) {
                StringTokenizer st = new StringTokenizer(f.readLine());
                lengths[j] = st.countTokens();
                minLength = Math.min(minLength,lengths[j]);
            }
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < P; j++) {
                if(lengths[j] == minLength) {
                    sb.append(j+1);
                    sb.append(' ');
                }
            }
            out.println(sb.substring(0,sb.length()-1));
            f.readLine();
        }
        f.close();
        out.close();
    }
}
