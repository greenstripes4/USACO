import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        char[][] perms = {{'A', 'B', 'C'}, {'A', 'C', 'B'}, {'B', 'A', 'C'}, {'B', 'C', 'A'}, {'C', 'A', 'B'}, {'C', 'B', 'A'}};
        char[][] req = new char[3][2];
        for(int i = 0; i < 3; i++) {
            char[] temp = f.readLine().toCharArray();
            req[i][0] = temp[0];
            req[i][1] = temp[2];
            if(temp[1] == '<') {
                char ttemp = req[i][0];
                req[i][0] = req[i][1];
                req[i][1] = ttemp;
            }
        }
        boolean found = false;
        for(char[] i: perms) {
            int[] pos = new int[3];
            for(int j = 0; j < 3; j++) {
                pos[i[j]-'A'] = j;
            }
            boolean flag = false;
            for(char[] j: req) {
                if(pos[j[0]-'A'] < pos[j[1]-'A']) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                found = true;
                out.println(i);
                break;
            }
        }
        if(!found) {
            out.println("Impossible");
        }
        f.close();
        out.close();
    }
}