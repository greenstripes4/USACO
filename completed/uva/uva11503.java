import java.io.*;
import java.util.*;

public class Main{
    private static int root(int[] socialNetworks, int id){
        while(id != socialNetworks[id]){
            socialNetworks[id] = socialNetworks[socialNetworks[id]];
            id = socialNetworks[id];
        }
        return id;
    }
    private static void union(int[] socialNetworks, int[] sizes, int aId, int bId){
        int aRoot = root(socialNetworks,aId);
        int bRoot = root(socialNetworks,bId);
        if(aRoot == bRoot){
            return;
        }
        if(sizes[aRoot] < sizes[bRoot]){
            socialNetworks[aRoot] = bRoot;
            sizes[bRoot] += sizes[aRoot];
        } else {
            socialNetworks[bRoot] = aRoot;
            sizes[aRoot] += sizes[bRoot];
        }
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            int F = Integer.parseInt(f.readLine());
            HashMap<String,Integer> map = new HashMap<>();
            int[] socialNetworks = new int[F*2];
            int[] sizes = new int[F*2];
            Arrays.fill(socialNetworks,-1);
            int id = 0;
            for(int j = 0; j < F; j++){
                StringTokenizer st = new StringTokenizer(f.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)){
                    map.put(a,id);
                    socialNetworks[id] = id;
                    sizes[id] = 1;
                    id++;
                }
                if(!map.containsKey(b)){
                    map.put(b,id);
                    socialNetworks[id] = id;
                    sizes[id] = 1;
                    id++;
                }
                int aId = map.get(a);
                int bId = map.get(b);
                union(socialNetworks,sizes,aId,bId);
                out.println(sizes[root(socialNetworks,aId)]);
            }
        }
        f.close();
        out.close();
    }
}
