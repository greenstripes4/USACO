import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            int N = f.nextInt();
            if(N == 0){
                break;
            }
            int[] loop = new int[N+2];
            for(int i = 0; i < N; i++){
                loop[i] = f.nextInt();
            }
            loop[N] = loop[0];
            loop[N+1] = loop[1];
            boolean up = false;
            int peaks = 0;
            if (loop[1] > loop[0])
                up = true;
            for (int i = 2; i < N+2; i++) {
                if (up && loop[i] < loop[i-1]) {
                    peaks++;
                    up = false;
                } else if (!up && loop[i] > loop[i-1]) {
                    peaks++;
                    up = true;
                }
            }
            out.println(peaks);
        }
        f.close();
        out.close();
    }
}
