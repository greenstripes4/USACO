import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        StringTokenizer st2 = new StringTokenizer(f.readLine());
        ArrayList<Integer> buckets1 = new ArrayList<>();
        ArrayList<Integer> buckets2 = new ArrayList<>();
        HashSet<Integer> possibleValues = new HashSet<>();
        for(int i = 0; i < 10; i++){
            buckets1.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < 10; i++){
            buckets2.add(Integer.parseInt(st2.nextToken()));
        }
        ArrayList<Integer> copy1 = new ArrayList<>();
        ArrayList<Integer> copy2 = new ArrayList<>();
        copy1.addAll(buckets1);
        copy2.addAll(buckets2);
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 11; j++){
                for(int k = 0; k < 10; k++){
                    for(int l = 0; l < 11; l++){
                        int n1 = buckets1.get(i);
                        buckets1.remove(i);
                        buckets2.add(n1);
                        int n2 = buckets2.get(j);
                        buckets2.remove(j);
                        buckets1.add(n2);
                        int n3 = buckets1.get(k);
                        buckets1.remove(k);
                        buckets2.add(n3);
                        int n4 = buckets2.get(l);
                        buckets1.clear();
                        buckets2.clear();
                        buckets1.addAll(copy1);
                        buckets2.addAll(copy2);
                        possibleValues.add(1000-n1+n2-n3+n4);
                    }
                }
            }
        }
        out.println(possibleValues.size());
        f.close();
        out.close();
    }
}