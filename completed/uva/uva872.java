import java.io.*;
import java.util.*;

public class Main {
    private static char[] variables;
    private static ArrayList<ArrayList<Integer>> adjacencyList;
    private static int[] indegree;
    private static boolean[] visited;
    private static ArrayList<String> res;
    private static void dfs(StringBuilder sb) {
        boolean flag = false;
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0 && !visited[i]) {
                for(int j: adjacencyList.get(i)) {
                    indegree[j]--;
                    if(indegree[j] < 0) {
                        return;
                    }
                }
                sb.append(variables[i]);
                sb.append(" ");
                visited[i] = true;
                dfs(sb);
                for(int j: adjacencyList.get(i)) {
                    indegree[j]++;
                }
                sb.deleteCharAt(sb.length()-1);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
                flag = true;
            }
        }
        if(!flag) {
            if(sb.length() == 0) {
                return;
            }
            res.add(sb.substring(0, sb.length()-1));
        }
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = Integer.parseInt(f.readLine());
        while(T-- > 0) {
            f.readLine();
            StringTokenizer st = new StringTokenizer(f.readLine());
            variables = new char[20];
            int[] idx = new int[26];
            int i = 0;
            while(st.hasMoreTokens()) {
                char temp = st.nextToken().charAt(0);
                variables[i] = temp;
                idx[temp-'A'] = i;
                i++;
            }
            adjacencyList = new ArrayList<>(i);
            for(int j = 0; j < i; j++) {
                adjacencyList.add(new ArrayList<>());
            }
            indegree = new int[i];
            st = new StringTokenizer(f.readLine());
            while(st.hasMoreTokens()) {
                char[] temp = st.nextToken().toCharArray();
                adjacencyList.get(idx[temp[0]-'A']).add(idx[temp[2]-'A']);
                indegree[idx[temp[2]-'A']]++;
            }
            visited = new boolean[i];
            res = new ArrayList<>();
            dfs(new StringBuilder());
            if(res.size() > 0) {
                Collections.sort(res);
                for(String j: res) {
                    out.println(j);
                }
            } else {
                out.println("NO");
            }
            if(T > 0) {
                out.println();
            }
        }
        f.close();
        out.close();
    }
}