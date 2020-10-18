import java.io.*;
import java.util.*;

public class Main{
    private static boolean solve(LinkedList<Integer> sticks, int target, int current, int sides) {
        if(current == target) {
            sides++;
            if(sides == 4) {
                return true;
            }
            if(sticks.size() < 4-sides) {
                return false;
            }
            return solve(sticks, target, 0, sides);
        }
        ListIterator<Integer> pointer = sticks.listIterator();
        while(pointer.hasNext()) {
            int value = pointer.next();
            if(current+value <= target) {
                pointer.remove();
                if(solve(sticks, target, current+value, sides)) {
                    return true;
                }
                sticks.add(0, value);
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = Integer.parseInt(f.readLine());
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<Integer> sticks = new LinkedList<>();
            int sum = 0;
            for(int i = 0; i < M; i++) {
                sticks.add(Integer.parseInt(st.nextToken()));
                sum += sticks.get(i);
            }
            if(sum%4 == 0) {
                out.println(solve(sticks, sum/4, 0, 0) ? "yes" : "no");
            } else {
                out.println("no");
            }
        }
        f.close();
        out.close();
    }
}
