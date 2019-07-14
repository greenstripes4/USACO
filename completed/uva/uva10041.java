import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        int cases = Integer.parseInt(f.readLine());
        for(int i = 0; i < cases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            ArrayList<Integer> x = new ArrayList<>();
            int numL = Integer.parseInt(st.nextToken());
            for(int l = 0; l < numL; l++) {
                x.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(x);
            int min = x.get(0);
            int max = x.get(x.size()-1);
            ArrayList<Integer> cL = new ArrayList<>();
            for(int j = min; j <= max; j++){
                int count = 0;
                for(int k: x){
                    count += Math.abs(k-j);
                }
                cL.add(count);
            }
            Collections.sort(cL);
            System.out.println(cL.get(0));
        }
    }
}
