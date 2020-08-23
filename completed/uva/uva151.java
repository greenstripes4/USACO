import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int N = f.nextInt();
            if(N == 0) {
                break;
            }
            for(int i = 1; i < N; i++) {
                boolean[] blackedOut = new boolean[N];
                int nextCity = -i;
                int turnedOff = 0;
                while(turnedOff < N) {
                    if(nextCity < 0) {
                        nextCity = 0;
                    } else {
                        for(int j = 0; j < i; j++) {
                            nextCity = (nextCity+1)%N;
                            if(blackedOut[nextCity]) {
                                j--;
                            }
                        }
                    }
                    blackedOut[nextCity] = true;
                    turnedOff++;
                }
                if(nextCity == 12) {
                    out.println(i);
                    break;
                }
            }
        }
        f.close();
        out.close();
    }
}
