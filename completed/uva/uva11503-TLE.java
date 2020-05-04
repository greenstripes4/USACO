import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testCases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testCases; i++){
            int F = Integer.parseInt(f.readLine());
            HashMap<String,HashSet<String>> socialNetworks = new HashMap<>();
            for(int j = 0; j < F; j++){
                StringTokenizer friendship = new StringTokenizer(f.readLine());
                String a = friendship.nextToken();
                String b = friendship.nextToken();
                HashSet<String> aFriends = socialNetworks.getOrDefault(a,new HashSet<>());
                HashSet<String> bFriends = socialNetworks.getOrDefault(b,new HashSet<>());
                aFriends.addAll(bFriends);
                bFriends.addAll(aFriends);
                aFriends.add(b);
                bFriends.add(a);
                aFriends.remove(a);
                bFriends.remove(b);
                socialNetworks.put(a,aFriends);
                socialNetworks.put(b,bFriends);
                out.println(aFriends.size()+1);
            }
        }
        f.close();
        out.close();
    }
}
