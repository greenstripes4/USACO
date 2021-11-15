import java.io.*;
import java.util.*;

public class Main {
        private static class Edge {
                private String v;
                private int a;
                private int b;
                private Edge(String v, int a, int b) {
                        this.v = v;
                        this.a = a;
                        this.b = b;
                }
        }
        private static class State {
                private String s;
                private int a;
                private int b;
                private State(String s, int a, int b) {
                        this.s = s;
                        this.a = a;
                        this.b = b;
                }
        }
        private static int gcd(int a, int b) {
                if(a == 0) {
                        return b;
                }
                return gcd(b%a, a);
        }
        public static void main(String[] args) throws IOException{
                //BufferedReader f = new BufferedReader(new FileReader("cowjump.in"));
                BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
                //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
                PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
                HashMap<String, ArrayList<Edge>> adjacencyList = new HashMap<>();
                String input;
                while((input = f.readLine()).charAt(0) != '.') {
                        StringTokenizer st = new StringTokenizer(input);
                        if(st.nextToken().equals("!")) {
                                int a = Integer.parseInt(st.nextToken());
                                String u = st.nextToken();
                                st.nextToken();
                                int b = Integer.parseInt(st.nextToken());
                                String v = st.nextToken();
                                int gcd = gcd(a, b);
                                a /= gcd;
                                b /= gcd;
                                adjacencyList.putIfAbsent(u, new ArrayList<>());
                                adjacencyList.putIfAbsent(v, new ArrayList<>());
                                adjacencyList.get(u).add(new Edge(v, a, b));
                                adjacencyList.get(v).add(new Edge(u, b, a));
                        } else {
                                String u = st.nextToken();
                                st.nextToken();
                                String v = st.nextToken();
                                Queue<State> queue = new LinkedList<>();
                                HashSet<String> visited = new HashSet<>();
                                queue.offer(new State(u, 1, 1));
                                visited.add(u);
                                boolean flag = false;
                                while(!queue.isEmpty()) {
                                        State cur = queue.poll();
                                        if(cur.s.equals(v)) {
                                                flag = true;
                                                out.println(cur.a + " " + u + " = " + cur.b + " " + v);
                                                break;
                                        }
                                        for(Edge e: adjacencyList.get(cur.s)) {
                                                State next = new State(e.v, cur.a*e.a, cur.b*e.b);
                                                int gcd = gcd(next.a, next.b);
                                                next.a /= gcd;
                                                next.b /= gcd;
                                                if(!visited.contains(next.s)) {
                                                        queue.offer(next);
                                                        visited.add(next.s);
                                                }
                                        }
                                }
                                if(!flag) {
                                        out.println("? " + u + " = ? " + v);
                                }
                        }
                }
                f.close();
                out.close();
    }
}
