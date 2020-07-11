import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < testcases; t++){
            if(t > 0){
                out.println();
            }
            ArrayList<String> files = new ArrayList<>();
            String input;
            while((input = f.readLine()) != null && input.length() != 0){
                files.add(input);
            }
            HashMap<String,Integer> map = new HashMap<>();
            for(int i = 0; i < files.size(); i++){
                for(int j = 0; j < files.size(); j++){
                    if(i != j){
                        map.put(files.get(i)+files.get(j),map.getOrDefault(files.get(i)+files.get(j),0)+1);
                    }
                }
            }
            String ans = null;
            for(String i: map.keySet()){
                if(ans == null || map.get(i) > map.get(ans)){
                    ans = i;
                }
            }
            out.println(ans);
        }
        f.close();
        out.close();
    }
}
