import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = f.nextInt();
        for(int i = 0; i < T; i++){
            int N = f.nextInt();
            int[] p = new int[N];
            int[] q = new int[N];
            int sum = 0;
            for(int j = 0; j < N; j++){
                p[j] = f.nextInt();
                sum += p[j];
            }
            for(int j = 0; j < N; j++){
                q[j] = f.nextInt();
                sum -= q[j];
            }
            if(sum < 0){
                out.println("Case " + (i+1) + ": Not possible");
            } else {
                for (int j = 0; j < N; j++) {
                    int petrol = p[j];
                    boolean valid = true;
                    for (int k = 0; k < N; k++) {
                        if (petrol < q[(j + k) % N]) {
                            valid = false;
                            break;
                        }
                        petrol -= q[(j + k) % N];
                        petrol += p[(j + k) % N];
                    }
                    if (valid) {
                        out.println("Case " + (i + 1) + ": Possible from station " + (j + 1));
                        break;
                    }
                }
            }
        }
        f.close();
        out.close();
    }
}
