import java.util.*;

class Booking {
    Set<Bus> buses = new HashSet<Bus>();
    
    public void initialize() {
    	Bus b1 = new Bus(1,"Pune","Mumbai",600);
    	Bus b2 = new Bus(2,"Bangalore","Mysore",500);
    	Bus b3 = new Bus(3,"Pune","Bangalore",1200);
    	Bus b4 = new Bus(4,"Pune","Panaji",1000);
    	Bus b5 = new Bus(5,"Hyderabad","Bangalore",700);
    	buses.add(b1);
    	buses.add(b2);
    	buses.add(b3);
    	buses.add(b4);
    	buses.add(b5);
    }

    public void addbus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bus number");
        int no = sc.nextInt();
        System.out.println("Enter source");
        String s = sc.next();
        System.out.println("Enter destination");
        String d = sc.next();
        System.out.println("Enter fare");
        float f = sc.nextFloat();
        Bus b = new Bus(no,s,d,f);
        buses.add(b);
        System.out.println("Bus added successfully");
    }
  
    public void cancelbus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bus number");
        int no = sc.nextInt();
        for(Bus b : buses) {
            if(b.busno == no) {
                buses.remove(b);
                System.out.println("Bus cancelled");
                break;
            }
        }
    }

    public void showbuses() {
        for(Bus b : buses) {
            System.out.println("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\nFare " + b.fare + "\n");
        }
    }
  
    public void checkbus() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter bus number");
        int no = sc.nextInt();
        for(Bus b : buses) {
            if(b.busno == no) {
                System.out.println("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\nFare " + b.fare + "\n");
                for(int bno : b.passtick.keySet()) {
                	Customer c = b.passtick.get(bno);
                	System.out.println("Booking number- " + bno + " Name- " + c.name + " Aadhar- " + c.Aadhar + " Age- " + c.age);
                }
                break;
            }
        }
    }
  
    public void bookticket() {
        Scanner sc = new Scanner(System.in);
        for(Bus b : buses) {
            System.out.println("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n");
        }
        System.out.println("Enter bus number");
        int no = sc.nextInt();
    	for(Bus b : buses) {
        	if(b.busno == no) {
        	    System.out.println("Available seats are " + b.availcount);
        	    System.out.println("Enter number of passengers");
        	    int tno = sc.nextInt();
        	    if(tno <= b.availcount) {
        	        for(int i=0; i<tno; i++) {
        	        	System.out.println("Enter passenger name");
        		        String pname = sc.next();
        		        System.out.println("Enter passenger Aadhar number");
        		        long ano = sc.nextInt();
        		        System.out.println("Enter passenger age");
        		        int pa = sc.nextInt();
        		        Customer c = new Customer(pa,pname,ano);
        		        b.bcount++;
        		        b.booked.add(b.bcount);
        		        b.passtick.put(b.bcount,c);
        		        System.out.println("Name- " + pname + " Booking no- " + b.bcount); 
        	        }
        	        b.availcount -= tno;
        	    }
        	    else {
        	    	System.out.println(tno + " tickets not available");
        	    }
        	}
    	}
    }

    public void cancelticket() {
        Scanner sc = new Scanner(System.in);
        for(Bus b : buses) {
            System.out.println("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n");
        }
        System.out.println("Enter bus number");
        int no = sc.nextInt();
    	for(Bus b : buses) {
        	if(b.busno == no) {
        	    System.out.println("Enter number of tickets to be cancelled");
        	    int tno = sc.nextInt();
        	    if(tno <= b.bcount) {
        	        for(int i=0; i<tno; i++) {
        	            System.out.println("Enter booking number");
        	            int bookno = sc.nextInt();
        	            if(b.passtick.containsKey(bookno)) {
        	            	Customer c = b.passtick.get(bookno);
        	            	System.out.println("Enter passenger Aadhar number");
        	            	long ano = sc.nextInt();
        	            	if(c.Aadhar == ano) {
        	            		b.booked.remove(new Integer(bookno));
        	            		b.passtick.remove(bookno);
        	            	}
        	            	else {
        	            		System.out.println("Booking number does not match Aadhar number");
        	            		break;
        	            	}
        	            }
        	            else {
        	            	System.out.println("Booking number does not exist");
        	            	break;
        	            }
        	        }
        	        b.availcount += tno;
        	    }
        	    else {
        	    	System.out.println(tno + " tickets haven't been booked yet");
        	    	break;
        	    }
        	}
    	}
    }             
}
