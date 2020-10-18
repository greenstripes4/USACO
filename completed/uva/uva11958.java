import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int K = Integer.parseInt(st.nextToken());
            String[] time = st.nextToken().split(":");
            int formatted = Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(f.readLine());
                String[] arrival = st.nextToken().split(":");
                int formattedDestination = Integer.parseInt(arrival[0])*60+Integer.parseInt(arrival[1]);
                if(formattedDestination < formatted) {
                    formattedDestination += 1440;
                }
                formattedDestination += Integer.parseInt(st.nextToken());
                min = Math.min(min,formattedDestination-formatted);
            }
            out.println("Case " + t + ": " + min);
        }
        f.close();
        out.close();
    }
}
