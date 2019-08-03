import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;
/*
O(n)
1

3 1 2
32.0 54.7 -2
*/

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int numCases = Integer.parseInt(f.readLine());
        boolean first = true;
        for(int i = 0; i < numCases; i++){
            if(!first){
                System.out.println();
            }
            else{
                first = false;
            }
            f.readLine();
            ArrayList<Integer> permutes = new ArrayList<>();
            ArrayList<String> result = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(f.readLine());
            while(st.hasMoreTokens()){
                permutes.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(f.readLine());
            while(st.hasMoreTokens()){
                result.add(st.nextToken());
            }
            TreeMap<Integer,String> original = new TreeMap<>();
            for(int j = 0; j < permutes.size(); j++){
                original.put(permutes.get(j), result.get(j));
            }
            for(String k: original.values()){
                System.out.println(k);
            }
        }
    }
}
