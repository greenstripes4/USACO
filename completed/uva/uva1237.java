import java.io.*;
import java.util.*;
/*
O(n)
1
4
HONDA 10000 45000
PEUGEOT 12000 44000
BMW 30000 75900
CHEVROLET 7000 37000
4
60000
7500
5000
10000
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int numTestCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < numTestCases; i++){
            if(i != 0){
                out.println();
            }
            int numMarkers = Integer.parseInt(f.readLine());
            HashMap<String,int[]> ranges = new HashMap<>();
            for(int j = 0; j < numMarkers; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                String marker = st.nextToken();
                int minValue = Integer.parseInt(st.nextToken());
                int maxValue = Integer.parseInt(st.nextToken());
                ranges.put(marker,new int[]{minValue,maxValue});
            }
            int numQueries = Integer.parseInt(f.readLine());
            for(int k = 0; k < numQueries; k++){
                int price = Integer.parseInt(f.readLine());
                String nameOfMarker = null;
                for(String m: ranges.keySet()){
                    int[] priceRange = ranges.get(m);
                    if(price >= priceRange[0] && price <= priceRange[1]){
                        if(nameOfMarker == null){
                            nameOfMarker = m;
                        } else {
                            nameOfMarker = null;
                            break;
                        }
                    }
                }
                if(nameOfMarker == null){
                    out.println("UNDETERMINED");
                } else {
                    out.println(nameOfMarker);
                }
            }
        }
        f.close();
        out.close();
    }
}
