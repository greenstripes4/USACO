import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(f.readLine());
            StringTokenizer st = new StringTokenizer(f.readLine());
            int[] x = new int[N];
            for(int i = 0; i < N; i++) {
                x[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(x);
            if(N == 7) {
                int c = x[0]+x[1] == x[2] ? 3 : 2;
                int[] temp = {x[0]+x[1], x[1]+x[c], x[c]+x[0], x[0]+x[1]+x[c]};
                boolean flag = false;
                for(int i = 2; i < 7; i++) {
                    if(i == c) {
                        continue;
                    }
                    boolean valid = false;
                    for(int j = 0; j < 4; j++) {
                        if(x[i] == temp[j]) {
                            valid = true;
                            temp[j] = -1;
                            break;
                        }
                    }
                    if(!valid) {
                        flag = true;
                        break;
                    }
                }
                out.println(flag ? 0 : 1);
            } else {
                int count = 0;
                for(int i = 1; i <= 50; i++) {
                    for(int j = i; j <= 50; j++) {
                        for(int k = j; k <= 50; k++) {
                            int[] temp = {i, j, k, i+j, j+k, k+i, i+j+k};
                            boolean flag = false;
                            for(int l: x) {
                                boolean valid = false;
                                for(int m = 0; m < 7; m++) {
                                    if(l == temp[m]) {
                                        valid = true;
                                        temp[m] = -1;
                                        break;
                                    }
                                }
                                if(!valid) {
                                    flag = true;
                                }
                            }
                            if(!flag) {
                                count++;
                            }
                        }
                    }
                }
                out.println(count);
            }
        }
        f.close();
        out.close();
    }
}