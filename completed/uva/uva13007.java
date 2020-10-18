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
            int extra = 0;
            for(int i = 0; i < M; i++) {
                StringTokenizer round = new StringTokenizer(f.readLine());
                int B = Integer.parseInt(round.nextToken());
                int choice = Integer.parseInt(round.nextToken());
                int total = 0;
                for(int j = 0; j < N-1; j++) {
                    total += Integer.parseInt(round.nextToken());
                }
                if(total < B) {
                    int amount = 1;
                    while (amount <= B-total) {
                        amount *= 10;
                    }
                    amount /= 10;
                    if(amount < choice) {
                        extra += amount;
                    } else {
                        extra += amount-choice;
                    }
                }
            }
            out.println(extra);
        }
        f.close();
        out.close();
    }
}
