import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int t = Integer.parseInt(f.readLine());
        for(int i = 0; i < t; i++){
            String title = f.readLine().toUpperCase();
            StringTokenizer mnb = new StringTokenizer(f.readLine());
            int m = Integer.parseInt(mnb.nextToken());
            int n = Integer.parseInt(mnb.nextToken());
            int b = Integer.parseInt(mnb.nextToken());
            HashMap<String,Integer> ingredientCosts = new HashMap<>();
            for(int j = 0; j < m; j++){
                StringTokenizer ingredientc = new StringTokenizer(f.readLine());
                String ingredient = ingredientc.nextToken();
                int c = Integer.parseInt(ingredientc.nextToken());
                ingredientCosts.put(ingredient,c);
            }
            ArrayList<String[]> possibleRecipes = new ArrayList<>();
            for(int j = 0; j < n; j++){
                String name = f.readLine();
                int k = Integer.parseInt(f.readLine());
                int cost = 0;
                for(int l = 0; l < k; l++){
                    StringTokenizer requirementx = new StringTokenizer(f.readLine());
                    String requirement = requirementx.nextToken();
                    int x = Integer.parseInt(requirementx.nextToken());
                    cost += ingredientCosts.get(requirement)*x;
                }
                if(cost < b) {
                    possibleRecipes.add(new String[]{name,Integer.toString(cost)});
                }
            }
            Collections.sort(possibleRecipes, new Comparator<String[]>() {
                @Override
                public int compare(String[] strings, String[] t1) {
                    String name1 = strings[0];
                    int cost1 = Integer.parseInt(strings[1]);
                    String name2 = t1[0];
                    int cost2 = Integer.parseInt(t1[1]);
                    if(cost1 == cost2){
                        return name1.compareTo(name2);
                    }
                    return cost1-cost2;
                }
            });
            out.println(title);
            if(possibleRecipes.size() == 0){
                out.println("Too expensive!");
            }
            for(String[] j: possibleRecipes){
                out.println(j[0]);
            }
            out.println();
        }
        f.close();
        out.close();
    }
}
