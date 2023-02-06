import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        HashMap<String, HashMap<String, Integer>> map = new HashMap<>();
        int specialPairs = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            String city = st.nextToken().substring(0,2);
            String state = st.nextToken();
            if(city.equals(state)) {
                continue;
            }
            if(map.containsKey(state)) {
                specialPairs += map.get(state).getOrDefault(city, 0);
            }
            if(!map.containsKey(city)) {
                map.put(city, new HashMap<>());
            }
            map.get(city).put(state, map.get(city).getOrDefault(state, 0)+1);
        }
        out.println(specialPairs);
        f.close();
        out.close();
    }
}
