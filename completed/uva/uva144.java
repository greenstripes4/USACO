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
        while(!(input = f.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] grants = new int[N];
            Arrays.fill(grants,40);
            int paid = 0;
            int student = 0;
            int coins = 1;
            int nextCoins = 1%k+1;
            while(true) {
                if(coins < grants[student]) {
                    grants[student] -= coins;
                    coins = nextCoins;
                    nextCoins = nextCoins%k+1;
                } else {
                    coins -= grants[student];
                    grants[student] = 0;
                    paid++;
                    out.printf("%1$3s",student+1);
                    if(coins == 0) {
                        coins = nextCoins;
                        nextCoins = nextCoins%k+1;
                    }
                }
                if(paid == N) {
                    break;
                }
                student = (student+1)%N;
                while(grants[student] == 0) {
                    student = (student+1)%N;
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
