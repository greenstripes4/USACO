import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        int a3 = Integer.parseInt(st.nextToken());
        int a4 = Integer.parseInt(st.nextToken());
        if(Math.abs(a3-a4) > 1) {
            out.println(-1);
        } else {
            StringBuilder root = new StringBuilder();
            if(a3 > a4) {
                root.append("47".repeat(a3));
                a1 -= a3;
                a2 -= a3;
            } else if(a4 > a3) {
                root.append("74".repeat(a4));
                a1 -= a4;
                a2 -= a4;
            } else if(a1 > a3) {
                root.append("47".repeat(a3));
                root.append(4);
                a1 -= a3+1;
                a2 -= a3;
            } else {
                root.append("74".repeat(a4));
                root.append(7);
                a1 -= a4;
                a2 -= a4+1;
            }
            if(a1 < 0 || a2 < 0) {
                out.println(-1);
            } else {
                for(int i = 0; i < root.length(); i++) {
                    if(root.charAt(i) == '4') {
                        root.insert(i, "4".repeat(a1));
                        break;
                    }
                }
                for(int i = root.length()-1; i >= 0; i--) {
                    if(root.charAt(i) == '7') {
                        root.insert(i, "7".repeat(a2));
                        break;
                    }
                }
                out.println(root);
            }
        }
        f.close();
        out.close();
    }
}