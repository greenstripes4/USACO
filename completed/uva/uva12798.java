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
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(f.readLine());
                boolean valid = true;
                for(int j = 0; j < M; j++) {
                    if(Integer.parseInt(st.nextToken()) == 0) {
                        valid = false;
                    }
                }
                if(valid) {
                    count++;
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
