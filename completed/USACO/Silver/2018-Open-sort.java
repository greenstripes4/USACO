import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("sort.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
        int N = Integer.parseInt(f.readLine());
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(f.readLine());
        }
        int[] B = A.clone();
        Arrays.sort(B);
        int maximumLeftDistance = 0;
        for(int i = 0; i < N; i++) {
            int index = Arrays.binarySearch(B, A[i]);
            maximumLeftDistance = Math.max(maximumLeftDistance, i-index);
        }
        out.println(maximumLeftDistance+1);
        f.close();
        out.close();
    }
}
