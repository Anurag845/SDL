import java.net.*;
import java.util.*;
import java.io.*;

class Booking {

    public void addbus(DataInputStream dis,DataOutputStream dos) {
		try {
        	//Scanner sc = new Scanner(System.in);
        	dos.writeUTF("Enter bus number");
        	String temp = dis.readUTF();
        	int no = Integer.parseInt(temp);
        	dos.writeUTF("Enter source");
        	String s = dis.readUTF();
        	dos.writeUTF("Enter destination");
        	String d = dis.readUTF();
        	dos.writeUTF("Enter fare");
        	temp = dis.readUTF();
        	int f = Integer.parseInt(temp);
        	dos.writeUTF("Enter date");
        	String date = dis.readUTF();
        	Bus b = new Bus(no,s,d,date,f);
        	Global.buses.add(b);
        	dos.writeUTF("Bus added successfully");
		}
		catch(IOException i) {
			System.out.println(i);
		}
    }
 
    public void cancelbus(DataInputStream dis,DataOutputStream dos) {
		try {
        	//Scanner sc = new Scanner(System.in);
        	dos.writeUTF("Enter bus number");
        	String temp = dis.readUTF();
        	int no = Integer.parseInt(temp);
        	for(Bus b : Global.buses) {
        	    if(b.busno == no) {
        	        Global.buses.remove(b);
        	        dos.writeUTF("Bus cancelled");
        	        break;
        	    }
        	}
        	updatedata();
		}
		catch(IOException i) {
			System.out.println(i);
		}
    }

    public void showbuses(DataOutputStream dos) {
		try {
    	    for(Bus b : Global.buses) {
    	    	dos.writeUTF("Bus no " + b.busno + "\nDate " + b.date + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n" + "Fare " + b.fare + "\n");
    	    }
		}
		catch(IOException i) {
			System.out.println(i);
		}
    }
 
    public void checkbus(DataInputStream dis,DataOutputStream dos) {
        //Scanner sc = new Scanner(System.in);
		try {
    	    dos.writeUTF("Enter bus number");
    	    String temp = dis.readUTF();
    	    int no = Integer.parseInt(temp);
    	    for(Bus b : Global.buses) {
    	        if(b.busno == no) {
    	            dos.writeUTF("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n");
                	for(int bno : b.passtick.keySet()) {
                    	Customer c = b.passtick.get(bno);
                    	dos.writeUTF("Booking number- " + bno + " Name- " + c.name + " Aadhar- " + c.Aadhar + " Age- " + c.age);
                	}
                	break;
            	}
        	}
		}
		catch(IOException i) {
			System.out.println(i);
		}
    }
 
    public synchronized void bookticket(DataInputStream dis,DataOutputStream dos) {
		try {
    	    //Scanner sc = new Scanner(System.in);
    	    for(Bus b : Global.buses) {
    	        dos.writeUTF("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n");
        	}
        	dos.writeUTF("Enter bus number");
        	String temp = dis.readUTF();
        	int no = Integer.parseInt(temp);
        	for(Bus b : Global.buses) {
        	    if(b.busno == no) {
        	        dos.writeUTF("Available seats are " + b.availcount);
        	        dos.writeUTF("Enter number of passengers");
        	        temp = dis.readUTF();
        	    	int tno = Integer.parseInt(temp);
        	        if(tno <= b.availcount) {
        	            for(int i=0; i<tno; i++) {
        	                dos.writeUTF("Enter passenger name");
        	                String pname = dis.readUTF();
        	                dos.writeUTF("Enter passenger Aadhar number");
        	                temp = dis.readUTF();
        					long ano = Integer.parseInt(temp);
        	                dos.writeUTF("Enter passenger age");
        	                temp = dis.readUTF();
        					int pa = Integer.parseInt(temp);
        	                Customer c = new Customer(pa,pname,ano);
        	                b.bcount++;
        	                b.booked.add(b.bcount);
        	                b.passtick.put(b.bcount,c);
        	                dos.writeUTF("Name- " + pname + " Booking no- " + b.bcount);
        	            }
        	            b.availcount -= tno;
        	        }
        	        else {
        	            dos.writeUTF(tno + " tickets not available");
        	        }
        	    }
        	}
		}
		catch(IOException i) {
			System.out.println(i);
		}
    }

    public synchronized void cancelticket(DataInputStream dis,DataOutputStream dos) {
		try {
        	//Scanner sc = new Scanner(System.in);
        	for(Bus b : Global.buses) {
        	    dos.writeUTF("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n");
        	}
        	dos.writeUTF("Enter bus number");
        	String temp = dis.readUTF();
        	int no = Integer.parseInt(temp);
        	for(Bus b : Global.buses) {
        	    if(b.busno == no) {
        	        dos.writeUTF("Enter number of tickets to be cancelled");
        	        temp = dis.readUTF();
        			int tno = Integer.parseInt(temp);
        	        if(tno <= b.bcount) {
        	            for(int i=0; i<tno; i++) {
        	                dos.writeUTF("Enter booking number");
        	                temp = dis.readUTF();
        					int bookno = Integer.parseInt(temp);
        	                if(b.passtick.containsKey(bookno)) {
        	                    Customer c = b.passtick.get(bookno);
        	                    dos.writeUTF("Enter passenger Aadhar number");
        	                    temp = dis.readUTF();
        						long ano = Integer.parseInt(temp);	
        	                    if(c.Aadhar == ano) {
        	                        b.booked.remove(new Integer(bookno));
        	                        b.passtick.remove(bookno);
        	                    }
        	                    else {
        	                        dos.writeUTF("Booking number does not match Aadhar number");
        	                        break;
        	                    }
        	                }
        	                else {
        	                    dos.writeUTF("Booking number does not exist");
        	                    break;
        	                }
        	            }
        	            b.availcount += tno;
        	        }
        	        else {
        	            dos.writeUTF(tno + " tickets haven't been booked yet");
        	            break;
        	        }
        	    }
        	}
		}
		catch(IOException i) {
			System.out.println(i);
		}	
    }
    
    public void getdata() {
    	try {
    		FileInputStream fis = new FileInputStream("Buses.txt");
    		ObjectInputStream ois = new ObjectInputStream(fis);
    		while(true) {
    			try {
    				Bus b = (Bus)ois.readObject();
    				Global.buses.add(b);
    			}
    			catch(EOFException e) {
    				break;
    			}
    		}
    		ois.close();
    		fis.close();
    	}
    	catch(Exception e) {
    		
    	}
    }
    
    public void updatedata() {
    	try {
    		FileOutputStream fos = new FileOutputStream("Buses.txt");
    		ObjectOutputStream oos = new ObjectOutputStream(fos);
    		
    		if(Global.buses.size() > 0) {
    			for(Bus b : Global.buses) {
    				oos.writeObject(b);
    			}
    		}
    		fos.close();
    		oos.close();
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    }      
}
