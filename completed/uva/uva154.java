import java.io.*;
import java.util.*;
/*
O(n^3)
r/P,o/G,y/S,g/A,b/N
r/G,o/P,y/S,g/A,b/N
r/P,y/S,o/G,g/N,b/A
r/P,o/S,y/A,g/G,b/N
e
r/G,o/P,y/S,g/A,b/N
r/P,y/S,o/G,g/N,b/A
r/P,o/S,y/A,g/G,b/N
r/P,o/G,y/S,g/A,b/N
ecclesiastical
#
 */

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!((input = f.readLine()).equals("#"))){
            ArrayList<String[]> cityPlans = new ArrayList<>();
            ArrayList<Integer> changes = new ArrayList<>();
            String[] first = input.split(",");
            Arrays.sort(first);
            cityPlans.add(first);
            String city;
            while((city = f.readLine()).charAt(0) != 'e'){
                String[] temp = city.split(",");
                Arrays.sort(temp);
                cityPlans.add(temp);
            }
            for(int i = 0; i < cityPlans.size(); i++){
                int numChanges = 0;
                for(int j = 0; j < cityPlans.size(); j++){
                    if(j != i){
                        String[] city1 = cityPlans.get(i);
                        String[] city2 = cityPlans.get(j);
                        for(int k = 0; k < 5; k++){
                            if(!(city1[k].equals(city2[k]))){
                                numChanges++;
                            }
                        }
                    }
                }
                changes.add(numChanges);
            }
            Integer min = null;
            int ind = -1;
            for(int l = 0; l < changes.size(); l++){
                if(min == null || changes.get(l) < min){
                    min = changes.get(l);
                    ind = l;
                }
            }
            out.println(ind+1);
        }
        f.close();
        out.close();
    }
}
