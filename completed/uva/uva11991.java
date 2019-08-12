import java.io.*;
import java.util.*;
/*
O(n + m)
8 4
1 3 2 2 4 3 2 1
1 3
2 4
3 2
4 2
*/

public class Main{
    public static void main(String[] args) throws IOException{
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String input;
        while((input = f.readLine()) != null){
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            HashMap<Integer, ArrayList<Integer>> values = new HashMap<>();
            st = new StringTokenizer(f.readLine());
            for(int i = 0; i < n; i++){
                int current = Integer.parseInt(st.nextToken());
                if(values.containsKey(current)){
                    ArrayList<Integer> temp = values.get(current);
                    temp.add(i);
                    values.put(current,temp);
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    values.put(current,temp);
                }
            }
            for(int j = 0; j < m; j++){
                StringTokenizer query = new StringTokenizer(f.readLine());
                int k = Integer.parseInt(query.nextToken());
                int v = Integer.parseInt(query.nextToken());
                if(values.containsKey(v)){
                    ArrayList<Integer> o = values.get(v);
                    if(o.size() > k-1){
                        out.println(o.get(k-1) + 1);
                    } else {
                        out.println(0);
                    }
                } else {
                    out.println(0);
                }
            }
        }
        out.close();
        f.close();
    }
}
