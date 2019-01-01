import java.sql.SQLException;
import java.util.*;
import java.io.*;

class Booking {
	
	Booking() {
		Bus b = new Bus(1,50,0,"pune","mumbai","12-12-2015",500);
		Global.buses.add(b);
	}

    public void addbus(ObjectInputStream ois) {
		try {
			Bus b = (Bus)ois.readObject();
			//System.out.println(b.busno + b.source + b.destination);
        	Global.buses.add(b);
        	//dos.writeUTF("Bus added successfully");
        	MySQLJDBC jdbc = new MySQLJDBC();
            //jdbc.writeBus(b);
		}
		catch(Exception i) {
			System.out.println(i);
		}
    }
 
    public void cancelbus(ObjectInputStream ois) {
		try {
        	Scanner sc = new Scanner(System.in);
        	//dos.writeUTF("Enter bus number");
        	
        	int no = (int) ois.readObject();
        	for(Bus b : Global.buses) {
        	    if(b.busno == no) {
        	        Global.buses.remove(b);
        	        //dos.writeUTF("Bus cancelled");
        	        break;
        	    }
        	}
		}
		catch(IOException | ClassNotFoundException i) {
			System.out.println(i);
		}
    }

    public void showbuses(ObjectOutputStream oos) {
		try {
			oos.writeObject(Global.buses.size());
			//System.out.println(Global.buses.size());
    	    for(Bus b : Global.buses) {
    	    	//dos.writeUTF("Bus no " + b.busno + "\nDate " + b.date + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n" + "Fare " + b.fare + "\n");
    	    	oos.writeObject(b);
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
                	for(int bno : Global.passtick.keySet()) {
                    	Customer c = Global.passtick.get(bno);
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
 
    public synchronized void bookticket(ObjectInputStream ois,ObjectOutputStream oos) {
    	    /*for(Bus b : Global.buses) {
    	        dos.writeUTF("Bus no " + b.busno + "\n" + b.source + " to " + b.destination + "\nAvailable seats " + b.availcount + "\n");
        	}*/
        	//dos.writeUTF("Enter bus number");
    	System.out.println("Inside book method");
    	try {
        	int no = (int) ois.readObject();
        	//int no = Integer.parseInt(temp);
        	for(Bus b : Global.buses) {
        		System.out.println("Inside for loop" + no);
        	    if(b.busno == no) {
        	    	System.out.println("Bus matched");
        	        //dos.writeUTF("Available seats are " + b.availcount);
        	        //dos.writeUTF("Enter number of passengers");
        	        //temp = dis.readUTF();
        	    	int tno = (int) ois.readObject();
        	        if(tno <= b.availcount) {
        	        	System.out.println("no detected");
        	        	Customer c1,c2,c3,c4;
        	        	int n;
        	        	switch(tno) {
        	        	case 1: c1 = (Customer) ois.readObject();
        	        			b.bcount++;
        	        			c1.bookno = b.bcount;
        	        			n = Global.passtick.size();
            	                Global.passtick.put(n+1,c1);
            	                break;
        	        	case 2: c1 = (Customer) ois.readObject();
	        					b.bcount++;
	        					c1.bookno = b.bcount;
	        					n = Global.passtick.size();
	        					Global.passtick.put(n+1,c1);
	        					c2 = (Customer) ois.readObject();
	        					b.bcount++;
	        					c2.bookno = b.bcount;
	        					n = Global.passtick.size();
	        					Global.passtick.put(n+1,c2);
	        					break;
        	        	case 3: c1 = (Customer) ois.readObject();
    							b.bcount++;
    							c1.bookno = b.bcount;
    							n = Global.passtick.size();
    							Global.passtick.put(n+1,c1);
    							c2 = (Customer) ois.readObject();
    							b.bcount++;
    							c2.bookno = b.bcount;
    							n = Global.passtick.size();
    							Global.passtick.put(n+1,c2);
    							c3 = (Customer) ois.readObject();
    							b.bcount++;
    							c3.bookno = b.bcount;
    							n = Global.passtick.size();
    							Global.passtick.put(n+1,c3);
    							break;
        	        	case 4: c1 = (Customer) ois.readObject();
    							b.bcount++;
    							c1.bookno = b.bcount;
    							n = Global.passtick.size();
    							Global.passtick.put(n+1,c1);
    							c2 = (Customer) ois.readObject();
    							b.bcount++;
    							c2.bookno = b.bcount;
    							n = Global.passtick.size();
    							Global.passtick.put(n+1,c2);
    							c3 = (Customer) ois.readObject();
    							b.bcount++;
    							c3.bookno = b.bcount;
    							n = Global.passtick.size();
    							Global.passtick.put(n+1,c3);
    							c4 = (Customer) ois.readObject();
    							b.bcount++;
    							c4.bookno = b.bcount;
    							n = Global.passtick.size();
    							Global.passtick.put(n+1,c4);
    							break;
        	        	}
        	        	oos.writeObject("Booking successful");
        	            /*for(int i=0; i<tno; i++) {
        	                //dos.writeUTF("Enter passenger name");
        	                //String pname = dis.readUTF();
        	                //dos.writeUTF("Enter passenger Aadhar number");
        	                //temp = dis.readUTF();
        					//int ano = dis.readInt();
        	                //dos.writeUTF("Enter passenger age");
        	                //temp = dis.readUTF();
        					//int pa = dis.readInt();
        	            	
        	                b.bcount++;
        	                //Customer c = new Customer(b.busno,b.bcount,pa,pname,ano);
        	                //b.booked.add(b.bcount);
        	                int n = Global.passtick.size();
        	                Global.passtick.put(n+1,c);
        	                MySQLJDBC jdbc = new MySQLJDBC();
        	                jdbc.writeCust(c);
        	                dos.writeUTF("Name- " + pname + " Booking no- " + n+1);
        	            }*/
        	            b.availcount -= tno;
        	        }
        	        else {
        	        	oos.writeObject("Tickets not available");
        	        }
        	    }
        	}
    	}
    	catch(Exception e) {
    		System.out.println(e);
    		e.printStackTrace();
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
        	                if(Global.passtick.containsKey(bookno)) {
        	                    Customer c = Global.passtick.get(bookno);
        	                    dos.writeUTF("Enter passenger Aadhar number");
        	                    temp = dis.readUTF();
        						long ano = Integer.parseInt(temp);	
        	                    if(c.Aadhar == ano) {
        	                        //b.booked.remove(new Integer(bookno));
        	                        Global.passtick.remove(bookno);
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