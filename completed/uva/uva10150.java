import java.io.*;
import java.util.*;

public class Main{
    private static void printPath(HashMap<String,String> traceBack, String finish, PrintWriter out) {
        if(traceBack.containsKey(finish)) {
            printPath(traceBack,traceBack.get(finish),out);
        }
        out.println(finish);
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        LinkedList<String> dictionary = new LinkedList<>();
        while(true){
            String next = f.readLine();
            if(next == null || next.length() == 0){
                break;
            }
            dictionary.add(next);
        }
        int testCase = 0;
        while(true){
            String pair = f.readLine();
            if(pair == null){
                break;
            }
            if(testCase > 0){
                out.println();
            }
            StringTokenizer st = new StringTokenizer(pair);
            String start = st.nextToken();
            String finish = st.nextToken();
            Queue<String> queue = new LinkedList<>();
            queue.add(start);
            HashMap<String,String> traceBack = new HashMap<>();
            HashSet<String> seen = new HashSet<>();
            seen.add(start);
            boolean found = false;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    String next = queue.poll();
                    if(next == null){
                        continue;
                    }
                    if(next.equals(finish)){
                        found = true;
                        break;
                    }
                    for(String j: dictionary){
                        int difference = 0;
                        if(j.length() != next.length() || seen.contains(j)){
                            continue;
                        }
                        for(int k = 0; k < next.length(); k++){
                            if(j.charAt(k) != next.charAt(k)){
                                difference++;
                            }
                        }
                        if(difference == 1){
                            queue.add(j);
                            seen.add(j);
                            traceBack.put(j,next);
                        }
                    }
                }
                if(found){
                    break;
                }
            }
            testCase++;
            if(!found){
                out.println("No solution.");
                continue;
            }
            printPath(traceBack,finish,out);
        }
        f.close();
        out.close();
    }
}
