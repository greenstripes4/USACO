import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        int[] modulos = new int[N+1];
        long sum = 0;
        for(int i = 1; i <= N; i++){
            sum += Integer.parseInt(f.readLine());
            modulos[i] = (int)(sum%7);
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i <= N; i++){
            if(map.containsKey(modulos[i])){
                max = Math.max(max,i-map.get(modulos[i]));
            } else {
                map.put(modulos[i],i);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
