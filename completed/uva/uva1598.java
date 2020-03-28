/*
ID: strongh2
LANG: JAVA
PROG: ariprog
TASK: ariprog
 */


import java.io.*;
import java.util.*;

class Order{
    char type;
    int size;
    int price;
    int orderId;
    public Order(char t, int s, int p, int id){
        type = t;
        size = s;
        price = p;
        orderId = id;
    }
}

public class Main{
    public static void main(String[] args) throws IOException {
        //long start = System.nanoTime();
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        //BufferedReader f = new BufferedReader(new FileReader("uva.in"));
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
            HashMap<Integer,Integer> buyBidPrice = new HashMap<>();
            HashMap<Integer,Integer> sellAskPrice = new HashMap<>();
            boolean[] canceled = new boolean[commands];
            Order[] orders = new Order[commands];
            for(int i = 0; i < commands; i++){
                String[] commandComponents = f.readLine().split(" ");
                if(commandComponents[0].equals("BUY")){
                    int size = Integer.parseInt(commandComponents[1]);
                    int price = Integer.parseInt(commandComponents[2]);
                    while(!sellMinHeap.isEmpty() && sellMinHeap.first().price <= price && size > 0){
                        Order seller = sellMinHeap.first();
                        if(!canceled[seller.orderId-1]) {
                            out.println("TRADE " + Math.min(size, seller.size) + " " + seller.price);
                            sellAskPrice.put(seller.price, sellAskPrice.get(seller.price) - Math.min(size, seller.size));
                            int temp = seller.size;
                            seller.size -= size;
                            size -= temp;
                            if (seller.size <= 0) {
                                sellMinHeap.remove(seller);
                                canceled[seller.orderId-1] = true;
                            }
                        }
                    }
                    if(size > 0){
                        Order temp = new Order('B',size,price,i+1);
                        buyMaxHeap.add(temp);
                        orders[i] = temp;
                        buyBidPrice.put(price,buyBidPrice.getOrDefault(price,0)+size);
                    } else {
                        canceled[i] = true;
                    }
                } else if(commandComponents[0].equals("SELL")) {
                    int size = Integer.parseInt(commandComponents[1]);
                    int price = Integer.parseInt(commandComponents[2]);
                    while(!buyMaxHeap.isEmpty() && buyMaxHeap.first().price >= price && size > 0){
                        Order buyer = buyMaxHeap.first();
                        if(!canceled[buyer.orderId-1]) {
                            out.println("TRADE " + Math.min(size, buyer.size) + " " + buyer.price);
                            buyBidPrice.put(buyer.price, buyBidPrice.get(buyer.price) - Math.min(size, buyer.size));
                            int temp = buyer.size;
                            buyer.size -= size;
                            size -= temp;
                            if (buyer.size <= 0) {
                                buyMaxHeap.remove(buyer);
                                canceled[buyer.orderId-1] = true;
                            }
                        }
                    }
                    if(size > 0){
                        Order temp = new Order('S',size,price,i+1);
                        sellMinHeap.add(temp);
                        orders[i] = temp;
                        sellAskPrice.put(price,sellAskPrice.getOrDefault(price,0)+size);
                    } else {
                        canceled[i] = true;
                    }
                } else {
                    int id = Integer.parseInt(commandComponents[1]);
                    if(!canceled[id-1] && orders[id-1] != null) {
                        canceled[id-1] = true;
                        if (orders[id-1].type == 'B') {
                            buyMaxHeap.remove(orders[id-1]);
                            buyBidPrice.put(orders[id-1].price, buyBidPrice.get(orders[id - 1].price) - orders[id - 1].size);
                        } else {
                            sellMinHeap.remove(orders[id-1]);
                            sellAskPrice.put(orders[id-1].price, sellAskPrice.get(orders[id - 1].price) - orders[id - 1].size);
                        }
                    }
                }
                int bidPrice = buyMaxHeap.isEmpty() ? 0:buyMaxHeap.first().price;
                int bidSize = buyBidPrice.getOrDefault(bidPrice,0);
                int askPrice = sellMinHeap.isEmpty() ? 99999:sellMinHeap.first().price;
                int askSize = sellAskPrice.getOrDefault(askPrice,0);
                out.println("QUOTE " + bidSize + " " + bidPrice + " - " + askSize + " " + askPrice);
            }
            f.readLine();
            caseNumber++;
        }
        f.close();
        //out.flush();
        //long end = System.nanoTime();
        //long ms = ((end - start) / 1000000);
        //out.println("Run for " + ms + "ms");
        out.close();
    }
}
