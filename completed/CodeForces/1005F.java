import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<int[]>> adjacencyList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            adjacencyList.get(a).add(new int[]{b, i});
            adjacencyList.get(b).add(new int[]{a, i});
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        queue.offer(0);
        distance[0] = 0;
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int[] v: adjacencyList.get(u)) {
                if(distance[v[0]] == -1) {
                    queue.offer(v[0]);
                    distance[v[0]] = distance[u]+1;
                }
            }
        }
        ArrayList<ArrayList<Integer>> valid = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            valid.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++) {
            for(int[] j: adjacencyList.get(i)) {
                if(distance[j[0]] == distance[i]+1) {
                    valid.get(j[0]).add(j[1]);
                }
            }
        }
        int[] idx = new int[n];
        ArrayList<String> res = new ArrayList<>();
        boolean next = true;
        for(int i = 0; i < k && next; i++) {
            char[] temp = new char[m];
            Arrays.fill(temp, '0');
            for(int j = 1; j < n; j++) {
                temp[valid.get(j).get(idx[j])] = '1';
            }
            res.add(new String(temp));
            next = false;
            for(int j = 0; j < n; j++) {
                if(idx[j] < valid.get(j).size()-1) {
                    next = true;
                    idx[j]++;
                    break;
                } else {
                    idx[j] = 0;
                }
            }
        }
        out.println(res.size());
        for(String i: res) {
            out.println(i);
        }
        f.close();
        out.close();
    }
}