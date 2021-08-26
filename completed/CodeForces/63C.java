import java.io.*;
import java.util.*;

public class Main {
    private static int contains(int[] a, int t) {
        for(int i = 0; i < 4; i++) {
            if(a[i] == t) {
                return i;
            }
        }
        return -1;
    }
    private static boolean consistent(int[][] arr, int k) {
        for(int[] i: arr) {
            int[] temp = new int[4];
            int kk = k;
            for(int j = 0; j < 4; j++) {
                temp[j] = kk%10;
                kk /= 10;
            }
            for(int j = 0; j < 4; j++) {
                for(int l = j+1; l < 4; l++) {
                    if(temp[j] == temp[l]) {
                        return false;
                    }
                }
            }
            int cur = i[0];
            int[] digits = new int[4];
            int b = 0;
            int c = 0;
            for(int j = 0; j < 4; j++) {
                digits[j] = cur%10;
                int place = contains(temp, digits[j]);
                if(place == j) {
                    b++;
                    temp[j] = -1;
                } else if(place >= 0) {
                    c++;
                    temp[place] = -1;
                }
                cur /= 10;
            }
            if(b != i[1] || c != i[2]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        int ans = 0;
        for(int i = 0; i < 10000; i++) {
            if(consistent(arr, i)) {
                count++;
                ans = i;
            }
        }
        if(count == 0) {
            out.println("Incorrect data");
        } else if(count == 1) {
            out.printf("%04d\n", ans);
        } else {
            out.println("Need more data");
        }
        f.close();
        out.close();
    }
}