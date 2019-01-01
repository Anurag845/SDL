import java.util.*;
import java.io.*;

class Bus implements Serializable{
    int busno;
    int bcount;
    int availcount;
    String date;
    int fare;
    String source,destination;
    ArrayList<Integer> booked = new ArrayList<Integer>();
    HashMap<Integer,Customer> passtick = new HashMap<>();
   
    Bus(int b,String src,String des,String d,int f)
    {
        busno = b;
        bcount = 0;
        availcount = 50;
        source = src;
        destination = des;
        date = d;
        fare = f;
    }
}
