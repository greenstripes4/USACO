import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
        int N = Integer.parseInt(f.readLine());
        HashSet<String> traits = new HashSet<>();
        ArrayList<HashSet<String>> subPopulations = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int K = Integer.parseInt(st.nextToken());
            HashSet<String> subPopulationTraits = new HashSet<>();
            for(int j = 0; j < K; j++){
                String trait = st.nextToken();
                subPopulationTraits.add(trait);
                traits.add(trait);
            }
            subPopulations.add(subPopulationTraits);
        }
        boolean valid = true;
        for(String i: traits){
            for(String j: traits){
                if(!i.equals(j)){
                    for(HashSet<String> k: subPopulations){
                        if(k.contains(i) && !k.contains(j)){
                            for(HashSet<String> l: subPopulations){
                                if(l.contains(j) && !l.contains(i)){
                                    for(HashSet<String> m: subPopulations){
                                        if(m.contains(i) && m.contains(j)){
                                            valid = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println(valid ? "yes":"no");
        f.close();
        out.close();
    }
}
