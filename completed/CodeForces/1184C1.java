import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        int[][] points = new int[4*n+1][2];
        for(int i = 0; i <= 4*n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i][0] = x;
            points[i][1] = y;
        }
        for(int i = 0; i <= 50; i++) {
            for(int k = 0; k <= 50; k++) {
                for(int j = i+1; j <= 50; j++) {
                    int l = k+j-i;
                    if(l > 50) {
                        break;
                    }
                    int[] invalid = {-1, -1};
                    for(int[] m: points) {
                        if(m[0] < i || m[0] > j || m[1] < k || m[1] > l) {
                            if (invalid[0] >= 0 || invalid[1] >= 0) {
                                invalid = new int[]{-1, -1};
                                break;
                            }
                            invalid = m;
                        } else if(m[0] != i && m[0] != j && m[1] != k && m[1] != l) {
                            if(invalid[0] >= 0 || invalid[1] >= 0) {
                                invalid = new int[]{-1, -1};
                                break;
                            }
                            invalid = m;
                        }
                    }
                    if(invalid[0] >= 0 && invalid[1] >= 0) {
                        out.println(invalid[0] + " " + invalid[1]);
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}