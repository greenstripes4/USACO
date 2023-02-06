import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("photo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        ArrayList<HashMap<Integer,Integer>> pos = new ArrayList<>();
        int numCows = Integer.parseInt(f.readLine());
        Integer[] cows = new Integer[numCows];
        for(int i = 0; i < 5; i++){
            HashMap<Integer,Integer> temp = new HashMap<>();
            for(int j = 0; j < numCows; j++){
                int id = Integer.parseInt(f.readLine());
                temp.put(id,j);
                cows[j] = id;
            }
            pos.add(temp);
        }
        Arrays.sort(cows, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int count = 0;
                for(HashMap<Integer,Integer> i: pos){
                    int ind1 = i.get(o1);
                    int ind2 = i.get(o2);
                    if(ind2 < ind1){
                        count++;
                    }
                }
                return count >= 3 ? 1:-1;
            }
        });
        for(int k: cows){
            out.println(k);
        }
        out.close();
        f.close();
    }
}
