import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("herding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] pos = {a,b,c};
        Arrays.sort(pos);
        if(pos[1] - pos[0] == 1 && pos[2] - pos[1] == 1){
            out.println(0);
        } else if(pos[1] - pos[0] == 2 || pos[2] - pos[1] == 2) {
            out.println(1);
        } else {
            out.println(2);
        }
        out.println(Math.max(pos[1] - pos[0], pos[2] - pos[1]) - 1);
        f.close();
        out.close();
    }
}
