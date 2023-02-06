import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[][] signal = new char[M][N];
        char[][] enlargedSignal = new char[M*K][N*K];
        for(int i = 0; i < M; i++){
            signal[i] = f.readLine().toCharArray();
        }
        for(int j = 0; j < M; j++){
            for(int k = 0; k < N; k++){
                for(int l = 0; l < K; l++){
                    for(int m = 0; m < K; m++){
                        enlargedSignal[j*K+l][k*K+m] = signal[j][k];
                    }
                }
            }
        }
        for(int n = 0; n < M*K; n++){
            StringBuilder sb = new StringBuilder();
            for(int o = 0; o < N*K; o++){
                sb.append(enlargedSignal[n][o]);
            }
            out.println(sb.toString());
        }
        f.close();
        out.close();
    }
}
