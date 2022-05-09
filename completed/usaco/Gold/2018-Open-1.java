import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        int N = Integer.parseInt(f.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(f.readLine());
        }
        boolean sorted = false;
        int ans = 0;
        while(!sorted) {
            sorted = true;
            ans++;
            for(int i = 0; i < N-1; i++) {
                if(A[i] > A[i+1]) {
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
            for(int i = N-2; i >= 0; i--) {
                if(A[i] > A[i+1]) {
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
            for(int i = 0; i < N-1; i++) {
                if(A[i] > A[i+1]) {
                    sorted = false;
                    break;
                }
            }
        }
        out.println(ans);
        f.close();
        out.close();
    }
}
