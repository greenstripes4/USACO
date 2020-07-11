import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int i = 0; i < T; i++){
            ArrayList<Integer> L = new ArrayList<>();
            String Li;
            while(!(Li = f.readLine()).equals("0")){
                L.add(Integer.parseInt(Li));
            }
            Collections.sort(L);
            int p = 1;
            int total = 0;
            for(int j = L.size()-1; j >= 0; j--){
                total += 2*Math.pow(L.get(j),p);
                p++;
            }
            out.println(total > 5000000 ? "Too expensive" : total);
        }
        f.close();
        out.close();
    }
}
