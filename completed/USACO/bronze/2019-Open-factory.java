import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static boolean contains(int target, HashMap<Integer,ArrayList<Integer>> factory, ArrayList<Integer> canGo){
        if(canGo.contains(target)){
            return true;
        }
        for(int j: canGo){
            return contains(target,factory,factory.get(j));
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("factory.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        int N = Integer.parseInt(f.readLine());
        HashMap<Integer,ArrayList<Integer>> factory = new HashMap<>();
        for(int i = 1; i <= N; i++){
            factory.put(i,new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ArrayList<Integer> canGo = factory.get(a);
            canGo.add(b);
            factory.put(a, canGo);
        }
        int I = -1;
        for(int i = 1; i <= N; i++){
            boolean valid = true;
            for(int j: factory.keySet()){
                if(j != i) {
                    ArrayList<Integer> canGo = factory.get(j);
                    if (!contains(i, factory, canGo)) {
                        valid = false;
                        break;
                    }
                }
            }
            if(valid){
                I = i;
                break;
            }
        }
        out.println(I);
        f.close();
        out.close();
    }
}
