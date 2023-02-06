import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("shell.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] guesses = new int[N][3];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int g = Integer.parseInt(st.nextToken()) - 1;
            guesses[i] = new int[]{a,b,g};
        }
        int oneOriginal = 0;
        int twoOriginal = 0;
        int threeOriginal = 0;
        boolean[] status = {true,false,false};
        for(int i = 0; i < N; i++){
            int a = guesses[i][0];
            int b = guesses[i][1];
            boolean temp = status[a];
            status[a] = status[b];
            status[b] = temp;
            if(status[guesses[i][2]]){
                oneOriginal++;
            }
        }
        status = new boolean[]{false,true,false};
        for(int i = 0; i < N; i++){
            int a = guesses[i][0];
            int b = guesses[i][1];
            boolean temp = status[a];
            status[a] = status[b];
            status[b] = temp;
            if(status[guesses[i][2]]){
                twoOriginal++;
            }
        }
        status = new boolean[]{false,false,true};
        for(int i = 0; i < N; i++){
            int a = guesses[i][0];
            int b = guesses[i][1];
            boolean temp = status[a];
            status[a] = status[b];
            status[b] = temp;
            if(status[guesses[i][2]]){
                threeOriginal++;
            }
        }
        out.println(Math.max(Math.max(oneOriginal,twoOriginal),threeOriginal));
        f.close();
        out.close();
    }
}
