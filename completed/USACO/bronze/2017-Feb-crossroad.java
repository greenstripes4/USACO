import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("crossroad.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
        int N = Integer.parseInt(f.readLine());
        HashMap<Integer,Integer> positions = new HashMap<>();
        int crossings = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int id = Integer.parseInt(st.nextToken());
            int side = Integer.parseInt(st.nextToken());
            if(positions.containsKey(id)){
                int originalSide = positions.get(id);
                if(originalSide != side){
                    crossings++;
                }
            }
            positions.put(id,side);
        }
        out.println(crossings);
        f.close();
        out.close();
    }
}
