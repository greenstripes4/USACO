import sun.awt.im.CompositionArea;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int count = 0;
            for(int j = 0; j < n-1; j++) {
                StringTokenizer edge = new StringTokenizer(f.readLine());
                if(Integer.parseInt(edge.nextToken()) == x || Integer.parseInt(edge.nextToken()) == x) {
                    count++;
                }
            }
            if(count <= 1 || n%2 == 0) {
                out.println("Ayush");
            } else {
                out.println("Ashish");
            }
        }
        f.close();
        out.close();
    }
}
