import java.io.*;
import java.util.Stack;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int current;
        while(!((input = f.readLine()).equals("0"))){
            current = Integer.parseInt(input);
            String input2;
            while(!((input2 = f.readLine()).equals("0"))) {
                Stack<Integer> in = new Stack<>();
                for (int i = current; i >= 1; i--) {
                    in.push(i);
                }
                StringTokenizer desired = new StringTokenizer(input2);
                Stack<Integer> station = new Stack<>();
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
                if (!station.empty()) {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
            }
            System.out.println();
        }
    }
}
