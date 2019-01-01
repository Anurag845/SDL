import java.util.*;

class Bus {
	int busno;
	int bcount;
	int availcount;
	String source,destination;
	float fare;
	ArrayList<Integer> booked = new ArrayList<Integer>();
	HashMap<Integer,Customer> passtick = new HashMap<>();
	
	Bus(int b,String src,String des,float fare)
	{
		busno = b;
		bcount = 0;
		availcount = 50;
		source = src;
		destination = des;
		this.fare = fare;
	}
}
