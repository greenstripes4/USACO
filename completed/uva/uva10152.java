import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int K = Integer.parseInt(f.readLine());
        for(int t = 0; t < K; t++){
            int n = Integer.parseInt(f.readLine());
            ArrayList<String> curPos = new ArrayList<>();
            ArrayList<String> desPos = new ArrayList<>();
            for(int i = 0; i < n; i++){
                curPos.add(f.readLine());
            }
            for(int i = 0; i < n; i++){
                desPos.add(f.readLine());
            }
            for(int i = n-1; i > 0; i--){
                int lower = curPos.indexOf(desPos.get(i));
                int higher = curPos.indexOf(desPos.get(i-1));
                if(higher > lower){
                    out.println(desPos.get(i-1));
                    curPos.add(0,curPos.remove(higher));
                }
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
