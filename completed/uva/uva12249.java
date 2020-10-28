import java.io.*;
import java.util.*;

public class Main{
    private static int shortest;
    private static String merge(String movie, String scene) {
        for(int i = Math.min(movie.length(), scene.length()); i > 0; i--) {
            if(movie.substring(movie.length()-i).equals(scene.substring(0,i))) {
                return movie+scene.substring(i);
            }
        }
        return movie+scene;
    }
    private static void getShortest(String[] scenes, boolean[] used, String movie, int left) {
        if(left == 0) {
            shortest = Math.min(shortest, movie.length());
            return;
        }
        for(int i = 0; i < scenes.length; i++) {
            if(!used[i]) {
                used[i] = true;
                getShortest(scenes, used, merge(movie, scenes[i]), left-1);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(f.readLine());
            String[] scenes = new String[N];
            int MAX = 0;
            for(int i = 0; i < N; i++) {
                scenes[i] = f.readLine();
                MAX += scenes[i].length();
            }
            shortest = MAX;
            getShortest(scenes, new boolean[N], "", N);
            out.println("Case " + t + ": " + shortest);
        }
        f.close();
        out.close();
    }
}
