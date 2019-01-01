import java.net.*;
import java.sql.SQLException;
import java.io.*;

class BusTicketSystem {
	public static void main(String[] args) throws IOException 
    {
    	//Booking bk = new Booking();
    	
    	//bk.getdata();
		
		MySQLJDBC mysqljdbc = new MySQLJDBC();
		//mysqljdbc.read();
    	
        ServerSocket ss = new ServerSocket(3000);
         
        // running infinite loop for getting
        // client request
        while (true) 
        {
            Socket s = null;
             
            try
            {
                // socket object to receive incoming client requests
                s = ss.accept();
                 
                System.out.println("A new client is connected : " + s);
                 
                // obtaining input and out streams
                ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
                //DataInputStream dis = new DataInputStream(s.getInputStream());
                //DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
                 
                System.out.println("Assigning new thread for this client");
 
                // create a new thread object
                Thread t = new ClientHandler(s,ois,oos);
 
                // Invoking the start() method
                t.start();
            }
            catch (Exception e){
                s.close();
                e.printStackTrace();
            }
        }
    }
}

class ClientHandler extends Thread {
	final ObjectInputStream ois;
    final ObjectOutputStream oos;
    
    final Socket s;
    // Constructor
    public ClientHandler(Socket s, ObjectInputStream ois, ObjectOutputStream oos) 
    {
        this.s = s;
        this.ois = ois;
        this.oos = oos;
        //this.dos = dos;
    }
 
    
	@Override
    public void run() {
		
		Booking bk = new Booking();
		
		try {
        	//Scanner sc = new Scanner(System.in);

			//String temp;

			System.out.println("Customer connected");
	
        	while(true) {
        		//int ch = (int) ois.readObject();
        		
        	    //dos.writeUTF("Press 1 to login as admin");
        	    //dos.writeUTF("Press 2 to login as user\nEnter");
        	    //dos.writeUTF("Press 3 to exit \n Enter");
        	    //temp = dis.readUTF();
        	    //int ch = Integer.parseInt(temp);
        	    //if(ch == 1) {
        	        //dos.writeUTF("Press 1 to add bus");
        	        //dos.writeUTF("Press 2 to cancel bus");
        	        //dos.writeUTF("Press 3 to see buses");
        	        //dos.writeUTF("Press 4 to check status of particular bus \nEnter");
        	        int choice = (int) ois.readObject();
        	    	//int choice = Integer.parseInt(temp);
        	        switch(choice) {
        	            case 1: bk.addbus(ois);
        	                break;
        	            case 2: bk.cancelbus(ois);
        	                break;
        	            case 3: bk.showbuses(oos);
        	                break;
        	            /*case 4: bk.checkbus(ois);
        	                break;*/
        	        //}
        	    //}
        	    //else if(ch == 2) {
        	        //dos.writeUTF("Press 1 to see buses");
        	        //dos.writeUTF("Press 2 to book ticket");
        	        //dos.writeUTF("Press 3 to cancel ticket \nEnter");
        	        //temp = dis.readUTF();
        	    	//int choice = Integer.parseInt(temp);
        	    	//System.out.println("Inside user");
        	    	//int choice = (int) ois.readObject();
        	        //switch(choice) {
        	            case 4: bk.showbuses(oos);
        	                break;
        	            case 5: bk.bookticket(ois,oos);
        	                break;
        	            /*case 3: bk.cancelticket(dis,dos);
        	                break;*/
        	        }
        	    //}
        	    /*else if(ch==3) {
        	    	try {
        	    		bk.updatedata();
        	    	}
        	    	catch(Exception e) {
        	    		e.printStackTrace();
        	    	}
        	    	dos.writeUTF("Data saved. Exit successful");
        	    	this.dis.close();
        			this.dos.close();
        	    	System.exit(0);
        	    }*/
        	    //dos.writeUTF("Do you want to continue? Enter");
        	    
        	}
        	
		}
		catch(IOException | ClassNotFoundException i) {
			System.out.println(i);
		}
    }
}
