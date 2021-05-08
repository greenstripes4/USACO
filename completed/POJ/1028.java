import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        Stack<String> back = new Stack<String>();
        Stack<String> forward = new Stack<String>();
        String cur = "http://www.acm.org/";
        while (true) {
            String command = f.next();
            if (command.equals("QUIT")) {
                break;
            }
            if (command.equals("BACK")) {
                if (back.isEmpty()) {
                    out.println("Ignored");
                } else {
                    forward.push(cur);
                    cur = back.pop();
                    out.println(cur);
                }
            } else if (command.equals("FORWARD")) {
                if (forward.isEmpty()) {
                    out.println("Ignored");
                } else {
                    back.push(cur);
                    cur = forward.pop();
                    out.println(cur);
                }
            } else {
                back.push(cur);
                forward.clear();
                cur = f.next();
                out.println(cur);
            }
        }
        f.close();
        out.close();
    }
}