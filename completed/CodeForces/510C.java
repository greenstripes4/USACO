import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = Integer.parseInt(f.readLine());
        char[] last = null;
        ArrayList<Integer>[] adjacencyList = new ArrayList[26];
        int[] indegree = new int[26];
        for(int i = 0; i < 26; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        boolean valid = true;
        for(int i = 0; i < n; i++) {
            char[] temp = f.readLine().toCharArray();
            if(i > 0) {
                int LIMIT = Math.min(last.length, temp.length);
                boolean reachedLimit = true;
                for(int j = 0; j < LIMIT; j++) {
                    if(last[j] != temp[j]) {
                        reachedLimit = false;
                        adjacencyList[last[j]-'a'].add(temp[j]-'a');
                        indegree[temp[j]-'a']++;
                        break;
                    }
                }
                if(reachedLimit && last.length > temp.length) {
                    valid = false;
                    out.println("Impossible");
                    break;
                }
            }
            last = temp;
        }
        if(valid) {
            LinkedList<Integer> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            int visited = 0;
            for(int i = 0; i < 26; i++) {
                if(indegree[i] == 0) {
                    queue.offer(i);
                    sb.append((char) ('a'+i));
                    visited++;
                }
            }
            while(!queue.isEmpty()) {
                int temp = queue.poll();
                for(int i: adjacencyList[temp]) {
                    indegree[i]--;
                    if(indegree[i] == 0) {
                        queue.offer(i);
                        sb.append((char) ('a'+i));
                        visited++;
                    }
                }
            }
            out.println(visited == 26 ? sb : "Impossible");
        }
        f.close();
        out.close();
    }
}