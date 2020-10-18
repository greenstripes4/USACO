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
            StringTokenizer st = new StringTokenizer(input);
            int first = 0;
            for(int i = 0; i < 5; i++) {
                first = first << 1 | Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(f.readLine());
            int second = 0;
            for(int i = 0; i < 5; i++) {
                second = second << 1 | Integer.parseInt(st.nextToken());
            }
            out.println((first^second) == 31 ? 'Y' : 'N');
        }
        f.close();
        out.close();
    }
}
