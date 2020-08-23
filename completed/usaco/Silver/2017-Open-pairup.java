import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        int N = Integer.parseInt(f.readLine());
        TreeMap<Integer,Integer> cows = new TreeMap<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows.put(y,x);
        }
        int maxTime = 0;
        while(!cows.isEmpty()) {
            int Ay = cows.firstKey();
            int By = cows.lastKey();
            maxTime = Math.max(maxTime,Ay+By);
            if(cows.get(Ay) < cows.get(By)) {
                cows.put(By,cows.get(By)-cows.get(Ay));
                cows.remove(Ay);
            } else if(cows.get(Ay) > cows.get(By)) {
                cows.put(Ay,cows.get(Ay)-cows.get(By));
                cows.remove(By);
            } else {
                cows.remove(Ay);
                cows.remove(By);
            }
        }
        out.println(maxTime);
        f.close();
        out.close();
    }
}
