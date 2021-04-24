import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!((input = f.readLine()).equals("0"))){
            int current = Integer.parseInt(input);
            String input2;
            while(!((input2 = f.readLine()).equals("0"))) {
                Stack<Integer> in = new Stack<Integer>();
                for (int i = current; i >= 1; i--) {
                    in.push(i);
                }
                StringTokenizer desired = new StringTokenizer(input2);
                Stack<Integer> station = new Stack<Integer>();
                int wanted = Integer.parseInt(desired.nextToken());
                while(!(in.empty()) || station.peek() == wanted) {
                    if (!station.empty() && station.peek() == wanted) {
                        station.pop();
                        if(desired.hasMoreTokens()) {
                            wanted = Integer.parseInt(desired.nextToken());
                        } else {
                            break;
                        }
                    } else {
                        if(!in.empty()) {
                            station.push(in.pop());
                        }
                    }
                }
                out.println(station.isEmpty() ? "Yes" : "No");
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
