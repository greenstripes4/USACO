import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            int L = Integer.parseInt(f.readLine());
            int[] arr = new int[L];
            StringTokenizer st = new StringTokenizer(f.readLine());
            for(int i = 0; i < L; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for(int i = 0; i < L; i++) {
                for(int j = 0; j < L-1; j++) {
                    if(arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        count++;
                    }
                }
            }
            out.println("Optimal train swapping takes " + count + " swaps.");
        }
        f.close();
        out.close();
    }
}