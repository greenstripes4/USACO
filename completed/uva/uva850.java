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
        int testcases = Integer.parseInt(f.readLine());
        f.readLine();
        for(int t = 0; t < testcases; t++){
            if(t > 0) {
                out.println();
            }
            ArrayList<String> sentences = new ArrayList<>();
            String next;
            while((next = f.readLine()) != null && next.length() != 0){
                sentences.add(next);
            }
            HashMap<Character,Character> map = new HashMap<>();
            for(String i: sentences) {
                if(i.length() == "the quick brown fox jumps over the lazy dog".length()) {
                    for(int j = 0; j < "the quick brown fox jumps over the lazy dog".length(); j++) {
                        if(map.containsKey(i.charAt(j)) && !map.get(i.charAt(j)).equals("the quick brown fox jumps over the lazy dog".charAt(j))) {
                            map.clear();
                            break;
                        }
                        map.put(i.charAt(j), "the quick brown fox jumps over the lazy dog".charAt(j));
                    }
                    if(map.size() == 27){
                        break;
                    }
                }
            }
            if(map.size() != 27){
                out.println("No solution.");
                continue;
            }
            for(String i: sentences) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < i.length(); j++) {
                    sb.append(map.get(i.charAt(j)));
                }
                out.println(sb);
            }
        }
        f.close();
        out.close();
    }
}
