import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] arr = new int[20];
        for(int i = 0; i < 20; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] back = arr.clone();
        int min = 0;
        for(int i = 0; i < 20; i++) {
            if(arr[i] == 1) {
                if(i == 19) {
                    min = Integer.MAX_VALUE;
                    break;
                }
                min++;
                for(int j = 0; j < 3 && i+j < 20; j++) {
                    arr[i+j] = (arr[i+j]+1)%2;
                }
            }
        }
        int min2 = 0;
        for(int i = 19; i >= 0; i--) {
            if(back[i] == 1) {
                if(i == 0) {
                    min2 = Integer.MAX_VALUE;
                    break;
                }
                min2++;
                for(int j = 0; j < 3 && i-j >= 0; j++) {
                    back[i-j] = (back[i-j]+1)%2;
                }
            }
        }
        out.println(Math.min(min, min2));
        f.close();
        out.close();
    }
}
