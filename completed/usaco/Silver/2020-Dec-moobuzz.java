import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader("moobuzz.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
        ArrayList<Integer> firstFifteen = new ArrayList<>();
        for(int i = 1; i <= 15; i++) {
            if(i%3 == 0 || i%5 == 0) {
                continue;
            }
            firstFifteen.add(i);
        }
        int N = Integer.parseInt(f.readLine());
        out.println(firstFifteen.get(N-8*((N-1)/8)-1)+15*((N-1)/8));
        f.close();
        out.close();
    }
}
