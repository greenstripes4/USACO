import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while((input = f.readLine()) != null) {
            int T = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int count = 0;
            for(int i = 0; i < 5; i++) {
                if(Integer.parseInt(st.nextToken()) == T) {
                    count++;
                }
            }
            out.println(count);
        }
        f.close();
        out.close();
    }
}
