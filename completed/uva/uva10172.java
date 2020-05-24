import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.*;

public class Main{
    private static boolean hasCargoRemaining(Queue<Integer>[] stations, Stack<Integer> carrier){
        if(!carrier.isEmpty()){
            return true;
        }
        for(Queue<Integer> i: stations){
            if(!i.isEmpty()){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int SET = f.nextInt();
        for(int i = 0; i < SET; i++){
            int N = f.nextInt();
            int S = f.nextInt();
            int Q = f.nextInt();
            Stack<Integer> carrier = new Stack<>();
            Queue<Integer>[] stations = new LinkedList[N];
            for(int j = 0; j < N; j++){
                int Qi = f.nextInt();
                Queue<Integer> temp = new LinkedList<>();
                for(int k = 0; k < Qi; k++){
                    temp.add(f.nextInt()-1);
                }
                stations[j] = temp;
            }
            int time = 0;
            int stationNumber = 0;
            while(true){
                Queue<Integer> curStation = stations[stationNumber];
                while(!carrier.isEmpty()){
                    int cargo = carrier.pop();
                    if(cargo != stationNumber){
                        if(curStation.size() < Q){
                            curStation.add(cargo);
                            time++;
                        } else {
                            carrier.push(cargo);
                            break;
                        }
                    } else {
                        time++;
                    }
                }
                while(carrier.size() < S && !curStation.isEmpty()){
                    carrier.push(curStation.poll());
                    time++;
                }
                if(!hasCargoRemaining(stations,carrier)){
                    break;
                }
                time += 2;
                stationNumber = (stationNumber+1)%N;
            }
            out.println(time);
        }
        f.close();
        out.close();
    }
}
