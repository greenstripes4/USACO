import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        String[] waveforms = {"1","22","333","4444","55555","666666","7777777","88888888","999999999"};
        for(int t = 0; t < testcases; t++) {
            if(t > 0) {
                out.println();
            }
            f.readLine();
            int amplitude = Integer.parseInt(f.readLine());
            int frequency = Integer.parseInt(f.readLine());
            for(int i = 0; i < frequency; i++) {
                if(i > 0) {
                    out.println();
                }
                for(int j = 0; j < amplitude; j++) {
                    out.println(waveforms[j]);
                }
                for(int j = amplitude-2; j >= 0; j--) {
                    out.println(waveforms[j]);
                }
            }
        }
        f.close();
        out.close();
    }
}
