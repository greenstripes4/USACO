import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        long[][] arr = new long[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        boolean flag = false;
        for(int i = 1; i < N; i++) {
            if(arr[i][0] < arr[i][1]) {
                if(i > 31) {
                    flag = true;
                    break;
                }
                arr[0][0] -= (arr[i][1]-arr[i][0])*(1 << i);
            } else {
                long diff = arr[i][0]-arr[i][1];
                if(diff%2 == 0) {
                    arr[(i+1)%N][0] += diff/2;
                } else {
                    if(i > 31) {
                        flag = true;
                        break;
                    }
                    arr[(i+1)%N][0] += (diff+1)/2;
                    arr[0][0] -= 1 << i;
                }
            }
        }
        if(flag) {
            out.println("No");
        } else {
            out.println(arr[0][0] == arr[0][1] ? "Yes" : "No");
        }
        f.close();
        out.close();
    }
}