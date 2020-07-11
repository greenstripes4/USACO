import java.io.*;
import java.util.*;

public class Main{
    private static int dfs(int theseus, int minotaur, int k, LinkedList<Integer>[] adjacencyList, LinkedList<Integer> path, boolean[] lit) {
        int cavern = 1;
        while(true) {
            int nextTheseus = -1;
            for (int i : adjacencyList[theseus]) {
                if (i >= 0 && i != minotaur && !lit[i]) {
                    nextTheseus = i;
                    break;
                }
            }
            if (nextTheseus == -1) {
                return theseus;
            }
            if (cavern % k == 0) {
                lit[theseus] = true;
                path.add(theseus);
            }
            minotaur = theseus;
            theseus = nextTheseus;
            cavern++;
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("#")) {
            StringTokenizer st = new StringTokenizer(input);
            String[] map = st.nextToken().split(";");
            int theseus = st.nextToken().charAt(0)-'A';
            int minotaur = st.nextToken().charAt(0)-'A';
            int k = Integer.parseInt(st.nextToken());
            LinkedList<Integer>[] adjacencyList = new LinkedList[26];
            for(int i = 0; i < 26; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
            for(String cavern: map) {
                char source = cavern.charAt(0);
                char[] destinations = cavern.length() > 2 ? cavern.substring(2).toCharArray() : new char[0];
                for(char i: destinations) {
                    adjacencyList[source-'A'].add(i-'A');
                }
            }
            LinkedList<Integer> path = new LinkedList<>();
            int trapped = dfs(theseus,minotaur,k,adjacencyList,path,new boolean[26]);
            for(int i: path) {
                out.print((char)(i+'A') + " ");
            }
            out.println("/" + (char)(trapped+'A'));
        }
        f.close();
        out.close();
    }
}
