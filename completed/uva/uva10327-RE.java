import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while ((input = f.readLine()) != null) {
            int n = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                if(st.hasMoreTokens()) {
                    arr[i] = Integer.parseInt(st.nextToken());
                } else {
                    st = new StringTokenizer(f.readLine());
                    arr[i] = Integer.parseInt(st.nextToken());
                }
            }
            int flips = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length-i-1; j++){
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        flips++;
                    }
                }
            }
            out.println("Minimum exchange operations : " + flips);
        }
        f.close();
        out.close();
    }
}
