import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String country = st.nextToken();
            map.put(country,map.getOrDefault(country,0)+1);
        }
        for(String i: map.keySet()) {
            out.println(i + " " + map.get(i));
        }
        f.close();
        out.close();
    }
}
