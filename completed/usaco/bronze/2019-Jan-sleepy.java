import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sleepy.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
        int N = Integer.parseInt(f.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int directions = N-1;
        for(int i = N-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                directions--;
            } else {
                break;
            }
        }
        out.println(directions);
        f.close();
        out.close();
    }
}
