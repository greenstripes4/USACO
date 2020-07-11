import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        //Scanner f = new Scanner(new File("uva.in"));
        Scanner f = new Scanner(System.in);
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while(true){
            f.nextInt();
            f.next();
            f.next();
            int fuelConsumption = f.nextInt();
            if(fuelConsumption == 0){
                break;
            }
            int lastCheckpoint = 0;
            int leaks = 0;
            double minimumFuelTank = 0;
            double usedFuel = 0;
            while(true){
                int distanceFromStart = f.nextInt();
                String event = f.next();
                if(event.equals("Goal")){
                    usedFuel += (distanceFromStart-lastCheckpoint)*((fuelConsumption)/100.0+leaks);
                    minimumFuelTank = Math.max(minimumFuelTank,usedFuel);
                    break;
                } else if(event.equals("Mechanic")) {
                    usedFuel += (distanceFromStart-lastCheckpoint)*((fuelConsumption)/100.0+leaks);
                    leaks = 0;
                    lastCheckpoint = distanceFromStart;
                } else if(event.equals("Gas")) {
                    usedFuel += (distanceFromStart-lastCheckpoint)*((fuelConsumption)/100.0+leaks);
                    minimumFuelTank = Math.max(minimumFuelTank,usedFuel);
                    usedFuel = 0;
                    lastCheckpoint = distanceFromStart;
                    f.next();
                } else if(event.equals("Leak")) {
                    usedFuel += (distanceFromStart-lastCheckpoint)*((fuelConsumption)/100.0+leaks);
                    leaks++;
                    lastCheckpoint = distanceFromStart;
                } else if(event.equals("Fuel")) {
                    usedFuel += (distanceFromStart-lastCheckpoint)*((fuelConsumption)/100.0+leaks);
                    f.next();
                    fuelConsumption = f.nextInt();
                    lastCheckpoint = distanceFromStart;
                }
            }
            out.printf("%.3f\n",Math.round(minimumFuelTank*1000.0)/1000.0);
        }
        f.close();
        out.close();
    }
}
