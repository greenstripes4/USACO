import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class trickyTravels {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int N = f.nextInt();
        int[] T = new int[N];
        for(int i = 0; i < N; i++) {
            T[i] = f.nextInt();
        }
        int index = 0;
        int moves = 0;
        boolean[] visited = new boolean[N];
        while(T[index] != 0 && !visited[index]) {
            visited[index] = true;
            index = (index+T[index])%N;
            moves++;
        }
        out.println(T[index] == 0 ? moves : -1);
        f.close();
        out.close();
    }
}
