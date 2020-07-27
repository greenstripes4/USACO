import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class essayExpert {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        LinkedList<String> ans = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            String next = f.next();
            if(ans.isEmpty() || !ans.get(ans.size()-1).equals(next)) {
                ans.add(next);
            }
        }
        out.print(ans.get(0));
        for(int i = 1; i < ans.size(); i++) {
            out.print(" " + ans.get(i));
        }
        out.println();
        f.close();
        out.close();
    }
}
