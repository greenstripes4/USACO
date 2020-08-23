import java.io.*;
import java.util.*;

public class Main {
    private static LinkedList<Integer>[] adjacencyList;
    private static boolean[] visited;
    private static boolean[] reachableFromFire;
    private static LinkedList<LinkedList<Integer>> allPaths;
    private static void findReachableStreetcornersFromFire(int reachable) {
        reachableFromFire[reachable] = true;
        for(int i: adjacencyList[reachable]) {
            if(!reachableFromFire[i]) {
                findReachableStreetcornersFromFire(i);
            }
        }
    }
    private static void dfs(LinkedList<Integer> path, int currentStreetcorner, int fire) {
        if(currentStreetcorner == fire) {
            LinkedList<Integer> pathCopy = new LinkedList<>(path);
            allPaths.add(pathCopy);
            return;
        }
        if(reachableFromFire[currentStreetcorner]) {
            for(int i: adjacencyList[currentStreetcorner]) {
                if(!visited[i] && reachableFromFire[i]) {
                    visited[i] = true;
                    path.add(i);
                    dfs(path,i,fire);
                    visited[i] = false;
                    path.remove(path.size()-1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcase = 1;
        while(f.hasNext()) {
            int fire = f.nextInt();
            adjacencyList = new LinkedList[21];
            visited = new boolean[21];
            reachableFromFire = new boolean[21];
            allPaths = new LinkedList<>();
            for(int i = 0; i < 21; i++) {
                adjacencyList[i] = new LinkedList<>();
            }
            while(true) {
                int streetcornerA = f.nextInt();
                int streetcornerB = f.nextInt();
                if(streetcornerA == 0 && streetcornerB == 0) {
                    break;
                }
                adjacencyList[streetcornerA].add(streetcornerB);
                adjacencyList[streetcornerB].add(streetcornerA);
            }
            findReachableStreetcornersFromFire(fire);
            out.println("CASE " + testcase + ":");
            visited[1] = true;
            LinkedList<Integer> path = new LinkedList<>();
            path.add(1);
            dfs(path,1,fire);
            Collections.sort(allPaths, new Comparator<LinkedList<Integer>>() {
                @Override
                public int compare(LinkedList<Integer> integers, LinkedList<Integer> t1) {
                    for(int i = 0; i < Math.min(integers.size(),t1.size()); i++) {
                        if(integers.get(i) < t1.get(i)) {
                            return -1;
                        } else if(integers.get(i) > t1.get(i)) {
                            return 1;
                        }
                    }
                    return 0;
                }
            });
            for(LinkedList<Integer> i: allPaths) {
                out.print(i.get(0));
                for(int j = 1; j < i.size(); j++) {
                    out.print(" " + i.get(j));
                }
                out.println();
            }
            out.println("There are " + allPaths.size() + " routes from the firestation to streetcorner " + fire + ".");
            testcase++;
        }
        f.close();
        out.close();
    }
}
