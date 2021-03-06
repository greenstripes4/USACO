import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mowing.out")));
        int numDirections = Integer.parseInt(f.readLine());
        HashMap<Integer,Integer> alreadyVisited = new HashMap<>();
        int pos = 10001000;
        Integer min = null;
        int t = 0;
        for(int i = 0; i < numDirections; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            String direction = st.nextToken();
            int steps = Integer.parseInt(st.nextToken());
            if(direction.equals("N")){
                for(int j = 0; j < steps; j++){
                    pos++;
                    t++;
                    if(alreadyVisited.containsKey(pos)){
                        int timeDiff = t - alreadyVisited.get(pos);
                        if(min == null || timeDiff < min){
                            min = timeDiff;
                        }
                        alreadyVisited.put(pos,t);
                    } else {
                        alreadyVisited.put(pos,t);
                    }
                }
            } else if(direction.equals("S")){
                for(int j = 0; j < steps; j++){
                    pos--;
                    t++;
                    if(alreadyVisited.containsKey(pos)){
                        int timeDiff = t - alreadyVisited.get(pos);
                        if(min == null || timeDiff < min){
                            min = timeDiff;
                        }
                        alreadyVisited.put(pos,t);
                    } else {
                        alreadyVisited.put(pos,t);
                    }
                }
            }  else if(direction.equals("W")){
                for(int j = 0; j < steps; j++){
                    pos -= 10000;
                    t++;
                    if(alreadyVisited.containsKey(pos)){
                        int timeDiff = t - alreadyVisited.get(pos);
                        if(min == null || timeDiff < min){
                            min = timeDiff;
                        }
                        alreadyVisited.put(pos,t);
                    } else {
                        alreadyVisited.put(pos,t);
                    }
                }
            } else if(direction.equals("E")){
                for(int j = 0; j < steps; j++){
                    pos += 10000;
                    t++;
                    if(alreadyVisited.containsKey(pos)){
                        int timeDiff = t - alreadyVisited.get(pos);
                        if(min == null || timeDiff < min){
                            min = timeDiff;
                        }
                        alreadyVisited.put(pos,t);
                    } else {
                        alreadyVisited.put(pos,t);
                    }
                }
            }
        }
        out.println((min == null) ? -1 : min);
        f.close();
        out.close();
    }
}
