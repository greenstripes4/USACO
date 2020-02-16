import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("records.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("records.out")));
        int N = Integer.parseInt(f.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String[] cows = new String[3];
            for(int j = 0; j < 3; j++){
                cows[j] = st.nextToken();
            }
            Arrays.sort(cows);
            String converted = String.join(" ",cows);
            if(map.containsKey(converted)){
                map.put(converted,map.get(converted)+1);
            } else {
                map.put(converted,1);
            }
        }
        int max = 0;
        for(String i: map.keySet()){
            max = Math.max(map.get(i),max);
        }
        out.println(max);
        f.close();
        out.close();
    }
}
