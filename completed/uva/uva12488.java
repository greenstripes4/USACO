import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(f.hasNext()) {
            int N = f.nextInt();
            ArrayList<Integer> initial = new ArrayList<>();
            ArrayList<Integer> finish = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                initial.add(f.nextInt());
            }
            for(int i = 0; i < N; i++) {
                finish.add(f.nextInt());
            }
            int overtakes = 0;
            for(int i: initial) {
                for(int j = 0; j < finish.size(); j++) {
                    if(i == finish.get(j)) {
                        finish.remove(j);
                        overtakes += j;
                        break;
                    }
                }
            }
            out.println(overtakes);
        }
        f.close();
        out.close();
    }
}