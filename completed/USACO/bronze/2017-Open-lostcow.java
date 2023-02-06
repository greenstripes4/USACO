import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int distance = 0;
        int amount = 1;
        int dir = 0;
        while(true) {
            if ((dir == 0 && y >= x && y <= x + amount) || (dir == 1 && y >= x - amount && y <= x)) {
                distance += Math.abs(y - x);
                out.println(distance);
                break;
            } else {
                dir = dir == 0 ? 1:0;
                distance += amount * 2;
                amount *= 2;
            }
        }
        f.close();
        out.close();
    }
}
