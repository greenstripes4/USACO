import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("lemonade.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        int N = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] w = new int[N];
        for(int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(w);
        int lineLength = 0;
        for(int i = N-1; i >= 0; i--) {
            if(lineLength <= w[i]) {
                lineLength++;
            }
        }
        out.println(lineLength);
        f.close();
        out.close();
    }
}
