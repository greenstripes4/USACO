import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("badmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        HashMap<Integer,ArrayList<int[]>> people = new HashMap<>();
        for(int i = 1; i <= n; i++){
            people.put(i,new ArrayList<>());
        }
        for(int j = 0; j < d; j++){
            StringTokenizer drink = new StringTokenizer(f.readLine());
            int person = Integer.parseInt(drink.nextToken());
            int milk = Integer.parseInt(drink.nextToken());
            int time = Integer.parseInt(drink.nextToken());
            ArrayList<int[]> temp = people.get(person);
            temp.add(new int[]{milk,time});
            people.put(person,temp);
        }
        HashMap<Integer,Integer> possible = new HashMap<>();
        for(int k = 0; k < s; k++){
            StringTokenizer sick = new StringTokenizer(f.readLine());
            int person = Integer.parseInt(sick.nextToken());
            int time = Integer.parseInt(sick.nextToken());
            ArrayList<int[]> temp = people.get(person);
            for(int[] p: temp){
                if(p[1] < time){
                    if(possible.containsKey(p[0])){
                        possible.put(p[0],possible.get(p[0]) + 1);
                    } else {
                        possible.put(p[0],1);
                    }
                }
            }
        }
        ArrayList<Integer> c = new ArrayList<>();
        for(int l: possible.keySet()){
            if(possible.get(l) >= s) {
                int count = 0;
                for (int p : people.keySet()) {
                    ArrayList<int[]> temp = people.get(p);
                    for (int[] drank : temp){
                        if(drank[0] == l) {
                            count++;
                            break;
                        }
                    }
                }
                c.add(count);
            }
        }
        int max = 0;
        for(int i = 0; i < c.size(); i++){
            if(c.get(i) > max){
                max = c.get(i);
            }
        }
        out.println(max);
        f.close();
        out.close();
    }
}
