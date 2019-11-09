import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("family.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("family.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        String cow1 = st.nextToken();
        String cow2 = st.nextToken();
        String[] mothers = new String[N];
        String[] daughters = new String[N];
        for(int i = 0; i < N; i++){
            StringTokenizer relation = new StringTokenizer(f.readLine());
            String mother = relation.nextToken();
            String daughter = relation.nextToken();
            mothers[i] = mother;
            daughters[i] = daughter;
        }
        ArrayList<String> path1 = new ArrayList<>();
        ArrayList<String> path2 = new ArrayList<>();
        path1.add(cow1);
        path2.add(cow2);
        while(true){
            boolean found = false;
            String target = path1.get(path1.size()-1);
            for(int i = 0; i < N; i++){
                if(daughters[i].equals(target)){
                    path1.add(mothers[i]);
                    found = true;
                    break;
                }
            }
            if(!found){
                break;
            }
        }
        while(true){
            boolean found = false;
            String target = path2.get(path2.size()-1);
            for(int i = 0; i < N; i++){
                if(daughters[i].equals(target)){
                    path2.add(mothers[i]);
                    found = true;
                    break;
                }
            }
            if(!found){
                break;
            }
        }
        int count1 = -1, count2 = -1;
        boolean found = false;
        for(int i = 0; i < path1.size(); i++){
            for(int j = 0; j < path2.size(); j++){
                if(path1.get(i).equals(path2.get(j))){
                    count1 = i;
                    count2 = j;
                    found = true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
        if(count1 == -1 || count2 == -1){
            out.println("NOT RELATED");
        } else if(count1 == 1 && count2 == 1){
            out.println("SIBLINGS");
        } else if(count2 == 1 && count1 > 1){
            out.print(cow2 + " is the ");
            for(int i = count2; i < count1 - 1; i++){
                out.print("great-");
            }
            out.println("aunt of " + cow1);
        } else if(count1 == 1 && count2 > 1){
            out.print(cow1 + " is the ");
            for(int i = count1; i < count2 - 1; i++){
                out.print("great-");
            }
            out.println("aunt of " + cow2);
        } else if((count1 == 0) && (count2 > 0)){
            out.print(cow1 + " is the ");
            for(int i = count1; i < count2 - 2; i++){
                out.print("great-");
            }
            if(count2 > 1){
                out.print("grand-");
            }
            out.println("mother of " + cow2);
        } else if((count2 == 0) && (count1 > 0)){
            out.print(cow2 + " is the ");
            for(int i = count2; i < count1 - 2; i++){
                out.print("great-");
            }
            if(count1 > 1){
                out.print("grand-");
            }
            out.println("mother of " + cow1);
        } else {
            out.println("COUSINS");
        }
        f.close();
        out.close();
    }
}
