/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

class Order{
    int size;
    int price;
    int orderId;
    public Order(int s, int p, int id){
        size = s;
        price = p;
        orderId = id;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        long start = System.nanoTime();
        //BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        BufferedReader f = new BufferedReader(new FileReader("uva.in"));
        String input;
        int caseNumber = 1;
        while((input = f.readLine()) != null){
            if(caseNumber > 1){
                out.println();
            }
            int commands = Integer.parseInt(input);
            TreeSet<Order> buyMaxHeap = new TreeSet<>(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if(o2.price == o1.price){
                        return o1.orderId-o2.orderId;
                    }
                    return o2.price-o1.price;
                }
            });
            TreeSet<Order> sellMinHeap = new TreeSet<>(new Comparator<Order>() {
                @Override
                public int compare(Order o1, Order o2) {
                    if(o1.price == o2.price){
                        return o1.orderId-o2.orderId;
                    }
                    return o1.price-o2.price;
                }
            });
            for(int i = 0; i < commands; i++){
                String[] commandComponents = f.readLine().split(" ");
                if(commandComponents[0].equals("BUY")){
                    int size = Integer.parseInt(commandComponents[1]);
                    int price = Integer.parseInt(commandComponents[2]);
                    while(!sellMinHeap.isEmpty() && sellMinHeap.first().price <= price && size > 0){
                        Order seller = sellMinHeap.first();
                        out.println("TRADE " + Math.min(size,seller.size) + " " + seller.price);
                        int temp = seller.size;
                        seller.size -= size;
                        size -= temp;
                        if(seller.size <= 0){
                            sellMinHeap.remove(seller);
                        }
                    }
                    if(size > 0){
                        buyMaxHeap.add(new Order(size,price,i+1));
                    }
                } else if(commandComponents[0].equals("SELL")) {
                    int size = Integer.parseInt(commandComponents[1]);
                    int price = Integer.parseInt(commandComponents[2]);
                    while(!buyMaxHeap.isEmpty() && buyMaxHeap.first().price >= price && size > 0){
                        Order buyer = buyMaxHeap.first();
                        out.println("TRADE " + Math.min(size,buyer.size) + " " + buyer.price);
                        int temp = buyer.size;
                        buyer.size -= size;
                        size -= temp;
                        if(buyer.size <= 0){
                            buyMaxHeap.remove(buyer);
                        }
                    }
                    if(size > 0){
                        sellMinHeap.add(new Order(size,price,i+1));
                    }
                } else {
                    int id = Integer.parseInt(commandComponents[1]);
                    boolean found = false;
                    for(Order j: buyMaxHeap){
                        if(j.orderId == id){
                            found = true;
                            buyMaxHeap.remove(j);
                            break;
                        }
                    }
                    if(!found) {
                        for (Order j : sellMinHeap) {
                            if (j.orderId == id) {
                                sellMinHeap.remove(j);
                                break;
                            }
                        }
                    }
                }
                int bidPrice = buyMaxHeap.isEmpty() ? 0:buyMaxHeap.first().price;
                int bidSize = 0;
                for(Order j: buyMaxHeap){
                    if(j.price == bidPrice){
                        bidSize += j.size;
                    } else {
                        break;
                    }
                }
                int askPrice = sellMinHeap.isEmpty() ? 99999:sellMinHeap.first().price;
                int askSize = 0;
                for(Order j: sellMinHeap){
                    if(j.price == askPrice){
                        askSize += j.size;
                    } else {
                        break;
                    }
                }
                out.println("QUOTE " + bidSize + " " + bidPrice + " - " + askSize + " " + askPrice);
            }
            f.readLine();
            caseNumber++;
        }
        f.close();
        out.flush();
        long end = System.nanoTime();
        long ms = ((end - start) / 1000000);
        out.println("Run for " + ms + "ms");
        out.close();
    }
}
