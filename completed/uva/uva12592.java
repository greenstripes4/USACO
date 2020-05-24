import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(f.readLine(),f.readLine());
        }
        int q = Integer.parseInt(f.readLine());
        for(int i = 0; i < q; i++){
            out.println(map.get(f.readLine()));
        }
        f.close();
        out.close();
    }
}
