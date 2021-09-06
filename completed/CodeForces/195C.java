import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        Stack<Integer> tries = new Stack<>();
        String exception = null;
        int pos = -1;
        for(int i = 0; i < n; i++) {
            String next = f.readLine().trim();
            if(next.equals("")) {
                continue;
            }
            String operation = next.substring(0, 3);
            if(operation.equals("try")) {
                tries.push(i);
            } else if(operation.equals("thr")) {
                exception = next.substring(next.indexOf("(")+1, next.indexOf(")")).trim();
                pos = i;
            } else {
                String[] temp = next.substring(next.indexOf("(")+1, next.indexOf(")")).split(",");
                temp[0] = temp[0].trim();
                temp[1] = temp[1].substring(temp[1].indexOf("\"")+1, temp[1].lastIndexOf("\""));
                if(tries.pop() < pos && temp[0].equals(exception)) {
                    out.println(temp[1]);
                    pos = -1;
                }
            }
        }
        if(pos >= 0) {
            out.println("Unhandled Exception");
        }
        f.close();
        out.close();
    }
}