import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("closing.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(true) {
            int L = f.nextInt();
            int U = f.nextInt();
            int R = f.nextInt();
            if(L == 0 && U == 0 && R == 0) {
                break;
            }
            int[] buttons = new int[R];
            for(int i = 0; i < R; i++) {
                buttons[i] = f.nextInt();
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.add(L);
            boolean[] visited = new boolean[10000];
            visited[L] = true;
            int presses = 0;
            while(!queue.isEmpty()) {
                int size = queue.size();
                boolean found = false;
                for(int i = 0; i < size; i++) {
                    int temp = queue.poll();
                    if(temp == U) {
                        found = true;
                        out.println("Case " + testcase + ": " + presses);
                        break;
                    }
                    for(int j: buttons) {
                        if(!visited[(temp+j)%10000]) {
                            queue.add((temp+j)%10000);
                            visited[(temp+j)%10000] = true;
                        }
                    }
                }
                if(found) {
                    break;
                }
                presses++;
            }
            if(!visited[U]) {
                out.println("Case " + testcase + ": Permanently Locked");
            }
            testcase++;
        }
        f.close();
        out.close();
    }
}
