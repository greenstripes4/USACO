import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
O(n)
3
+z -z
3
+z +y
2
+z
4
+z +y +z
5
No +z No No
0
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        HashMap<String,String> output = new HashMap<>();
        output.put("+x+x","+x");
        output.put("+x+y","+y");
        output.put("+x-y","-y");
        output.put("+x-x","-x");
        output.put("+x+z","+z");
        output.put("+x-z","-z");

        output.put("+y+y","-x");
        output.put("+y-y","+x");
        output.put("+y+x","+y");
        output.put("+y-x","-y");
        output.put("+y+z","+y");
        output.put("+y-z","+y");

        output.put("+z+z","-x");
        output.put("+z-z","+x");
        output.put("+z+x","+z");
        output.put("+z-x","-z");
        output.put("+z+y","+z");
        output.put("+z-y","+z");

        output.put("-x-x","+x");
        output.put("-x+x","-x");
        output.put("-x-y","+y");
        output.put("-x+y","-y");
        output.put("-x-z","+z");
        output.put("-x+z","-z");

        output.put("-y-y","-x");
        output.put("-y+y","+x");
        output.put("-y+x","-y");
        output.put("-y-x","+y");
        output.put("-y-z","-y");
        output.put("-y+z","-y");

        output.put("-z-z","-x");
        output.put("-z+z","+x");
        output.put("-z+y","-z");
        output.put("-z-y","-z");
        output.put("-z+x","-z");
        output.put("-z-x","-z");

        while(!((input = f.readLine()).equals("0"))){
            int l = Integer.parseInt(input);
            StringTokenizer st = new StringTokenizer(f.readLine());
            String current = "+x";
            for(int i = 0; i < l-1; i++){
                String next = st.nextToken();
                if(!(next.equals("No"))) {
                    String combo = current + next;
                    current = output.get(combo);
                }
            }
            System.out.println(current);
        }
    }
}
