import java.io.*;
import java.util.*;

public class Main {
    private static int minimumBandwidth;
    private static ArrayList<Integer> minimumOrdering;
    private static TreeSet<Integer> nodes;
    private static ArrayList<Integer>[] adjacencyList;
    private static int computeMaximumBandwidth(ArrayList<Integer> ordering) {
        int maximumBandwidth = 0;
        for(int i = 0; i < ordering.size(); i++) {
            for(int j: adjacencyList[ordering.get(i)]) {
                int index = ordering.indexOf(j);
                maximumBandwidth = Math.max(maximumBandwidth,Math.abs(index-i));
            }
        }
        return maximumBandwidth;
    }
    private static void getMinimumBandwidth(ArrayList<Integer> currentOrdering) {
        if(currentOrdering.size() == nodes.size()) {
            int currentBandwidth = computeMaximumBandwidth(currentOrdering);
            if(currentBandwidth < minimumBandwidth) {
                minimumBandwidth = currentBandwidth;
                minimumOrdering = new ArrayList<>();
                minimumOrdering.addAll(currentOrdering);
            }
            return;
        }
        for(int i: nodes) {
            if(!currentOrdering.contains(i)) {
                currentOrdering.add(i);
                getMinimumBandwidth(currentOrdering);
                currentOrdering.remove(currentOrdering.size()-1);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String input;
        while(!(input = f.readLine()).equals("#")) {
            minimumBandwidth = Integer.MAX_VALUE;
            minimumOrdering = new ArrayList<>();
            nodes = new TreeSet<>();
            adjacencyList = new ArrayList[26];
            String[] edgesFromNodes = input.split(";");
            for(int i = 0; i < 26; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            for(String i: edgesFromNodes) {
                String[] keyValues = i.split(":");
                int source = keyValues[0].charAt(0)-'A';
                nodes.add(source);
                for(char j: keyValues[1].toCharArray()) {
                    nodes.add(j-'A');
                    adjacencyList[source].add(j-'A');
                }
            }
            getMinimumBandwidth(new ArrayList<>());
            for(int i: minimumOrdering) {
                out.print(((char)(i+'A')) + " ");
            }
            out.println("-> " + minimumBandwidth);
        }
        f.close();
        out.close();
    }
}
