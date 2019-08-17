import java.io.*;
import java.util.TreeMap;
/*
O(n)
1
Red Alder
Ash
Aspen
Basswood
Ash
Beech
Yellow Birch
Ash
Cherry
Cottonwood
Ash
Cypress
Red Elm
Gum
Hackberry
White Oak
Hickory
Pecan
Hard Maple
White Oak
Soft Maple
Red Oak
Red Oak
White Oak
Poplan
Sassafras
Sycamore
Black Walnut
Willow
*/

public class Main{
    public static void main(String[] args) throws Exception {
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in,"ISO-8859-1"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out,"ISO-8859-1")));
        int numTestCases = Integer.parseInt(f.readLine());
        f.readLine();
        for (int i = 0; i < numTestCases; i++){
            TreeMap<String,Integer> treeCount = new TreeMap<>();
            int totalTrees = 0;
            String tree;
            while((tree = f.readLine()) != null){
                if(tree.equals("")){
                    break;
                }
                totalTrees++;
                if(treeCount.containsKey(tree)){
                    int currentCount = treeCount.get(tree);
                    treeCount.put(tree, currentCount+1);
                } else {
                    treeCount.put(tree, 1);
                }
            }
            for(String key: treeCount.keySet()){
                out.print(key + " ");
                out.printf("%.4f", treeCount.get(key)*100.0/totalTrees);
                out.println();
            }
            if(i < numTestCases-1){
                out.println();
            }
        }
        f.close();
        out.close();
    }
}
