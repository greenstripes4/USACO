import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true) {
            int T = f.nextInt();
            if(T == 0) {
                break;
            }
            int maximumHeight = 0;
            int maximumVolume = 0;
            for(int i = 0; i < T; i++) {
                int L = f.nextInt();
                int W = f.nextInt();
                int H = f.nextInt();
                if(H > maximumHeight) {
                    maximumHeight = H;
                    maximumVolume = L*W*H;
                } else if(H == maximumHeight && L*W*H > maximumVolume) {
                    maximumVolume = L*W*H;
                }
            }
            out.println(maximumVolume);
        }
        f.close();
        out.close();
    }
}
