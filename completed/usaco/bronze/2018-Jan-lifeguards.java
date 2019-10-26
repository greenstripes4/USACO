import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        int N = Integer.parseInt(f.readLine());
        int[][] times = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            times[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }
        int max = 0;
        for(int j = 0; j < N; j++){
            boolean[] temp = new boolean[1001];
            for(int k = 0; k < N; k++){
                if(j != k) {
                    for(int l = times[k][0]; l < times[k][1]; l++){
                        temp[l] = true;
                    }
                }
            }
            int count = 0;
            for(boolean m: temp){
                if(m){
                    count++;
                }
            }
            if(count > max){
                max = count;
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
