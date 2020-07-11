import java.io.*;
import java.util.*;

class Component implements Comparable<Component>{
    public String name;
    public int price;
    public int quality;
    public Component(String name, int price, int quality){
        this.name = name;
        this.price = price;
        this.quality = quality;
    }
    @Override
    public int compareTo(Component o){
        if(this.price == o.price){
            return o.quality-this.quality;
        }
        return this.price-o.price;
    }
}

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        //Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int testcases = Integer.parseInt(f.readLine());
        for(int i = 0; i < testcases; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            HashMap<String,ArrayList<Component>> components = new HashMap<>();
            for(int j = 0; j < n; j++){
                StringTokenizer component = new StringTokenizer(f.readLine());
                String category = component.nextToken();
                String name = component.nextToken();
                int price = Integer.parseInt(component.nextToken());
                int quality = Integer.parseInt(component.nextToken());
                if(components.containsKey(category)){
                    components.get(category).add(new Component(name,price,quality));
                } else {
                    ArrayList<Component> temp = new ArrayList<>();
                    temp.add(new Component(name,price,quality));
                    components.put(category,temp);
                }
            }
            for(ArrayList<Component> j: components.values()){
                Collections.sort(j);
            }
            int[] indicies = new int[components.size()];
            int curInd = 0;
            for(ArrayList<Component> j: components.values()){
                b -= j.get(indicies[curInd]).price;
                curInd++;
            }
            int minQuality;
            while(true){
                minQuality = Integer.MAX_VALUE;
                curInd = 0;
                for(ArrayList<Component> j: components.values()){
                    minQuality = Math.min(minQuality,j.get(indicies[curInd]).quality);
                    curInd++;
                }
                curInd = 0;
                boolean updated = false;
                for(ArrayList<Component> j: components.values()){
                    if(j.get(indicies[curInd]).quality == minQuality) {
                        for (int k = indicies[curInd]+1; k < j.size(); k++) {
                            if (j.get(k).quality > minQuality && b+j.get(indicies[curInd]).price-j.get(k).price >= 0){
                                updated = true;
                                b += j.get(indicies[curInd]).price;
                                b -= j.get(k).price;
                                indicies[curInd] = k;
                                break;
                            }
                        }
                    }
                    curInd++;
                }
                if(!updated){
                    break;
                }
            }
            out.println(minQuality);
        }
        f.close();
        out.close();
    }
}
