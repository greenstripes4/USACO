import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("guess.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
        int N = Integer.parseInt(f.readLine());
        HashMap<String,HashSet<String>> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String animal = st.nextToken();
            int characteristics = Integer.parseInt(st.nextToken());
            HashSet<String> set = new HashSet<>();
            for(int j = 0; j < characteristics; j++){
                String characteristic = st.nextToken();
                set.add(characteristic);
            }
            map.put(animal,set);
        }
        int max = 0;
        for(String i: map.keySet()){
            for(String j: map.keySet()){
                if(!(i.equals(j))){
                    HashSet<String> c1 = map.get(i);
                    HashSet<String> c2 = map.get(j);
                    int count = 0;
                    for(String k: c1){
                        if(c2.contains(k)){
                            count++;
                        }
                    }
                    max = Math.max(max,count);
                }
            }
        }
        out.println(max+1);
        f.close();
        out.close();
    }
}
