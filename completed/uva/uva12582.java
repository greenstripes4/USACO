import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            char[] path = f.readLine().toCharArray();
            TreeMap<Character,HashSet<Character>> map = new TreeMap<>();
            Stack<Character> stack = new Stack<>();
            for(char i: path) {
                if(stack.isEmpty()) {
                    stack.push(i);
                } else if(stack.peek() == i) {
                    stack.pop();
                } else {
                    if(!map.containsKey(i)) {
                        map.put(i,new HashSet<>());
                    }
                    if(!map.containsKey(stack.peek())) {
                        map.put(stack.peek(),new HashSet<>());
                    }
                    map.get(i).add(stack.peek());
                    map.get(stack.peek()).add(i);
                    stack.push(i);
                }
            }
            out.println("Case " + t);
            for(char i: map.keySet()) {
                out.println(i + " = " + map.get(i).size());
            }
        }
        f.close();
        out.close();
    }
}
