import java.net.*;
import java.io.*;

class BusTicketSystem {
	public static void main(String[] args) throws IOException 
    {
    	Booking bk = new Booking();
    	
    	bk.getdata();
    	
        // server is listening on port 5056
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
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                 
                System.out.println("Assigning new thread for this client");
 
                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);
 
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
	final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) 
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }
 
    /*@Override
    public void run() 
    {
        String received;
        String toreturn;
        while (true) 
        {
            try {
 
                // Ask user what he wants
                dos.writeUTF("What do you want?[Date | Time]..\n"+
                            "Type Exit to terminate connection.");
                 
                // receive the answer from client
                received = dis.readUTF();
                 
                if(received.equals("Exit"))
                { 
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }
                 
                // creating Date object
                Date date = new Date();
                 
                // write on output stream based on the
                // answer from the client
                switch (received) {
                 
                    case "Date" :
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;
                         
                    case "Time" :
                        toreturn = fortime.format(date);
                        dos.writeUTF(toreturn);
                        break;
                         
                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
         
        try
        {
            // closing resources
            this.dis.close();
            this.dos.close();
             
        }catch(IOException e){
            e.printStackTrace();
        }*/



	@Override
    public void run() {
		
		Booking bk = new Booking();
		
		try {
        	//Scanner sc = new Scanner(System.in);

			String temp;

			System.out.println("Customer connected");
	
        	while(true) {
        	    dos.writeUTF("Press 1 to login as admin");
        	    dos.writeUTF("Press 2 to login as user\nEnter");
        	    //dos.writeUTF("Press 3 to exit \n Enter");
        	    temp = dis.readUTF();
        	    int ch = Integer.parseInt(temp);
        	    if(ch == 1) {
        	        dos.writeUTF("Press 1 to add bus");
        	        dos.writeUTF("Press 2 to cancel bus");
        	        dos.writeUTF("Press 3 to see buses");
        	        dos.writeUTF("Press 4 to check status of particular bus \nEnter");
        	        temp = dis.readUTF();
        	    	int choice = Integer.parseInt(temp);
        	        switch(choice) {
        	            case 1: bk.addbus(dis,dos);
        	                break;
        	            case 2: bk.cancelbus(dis,dos);
        	                break;
        	            case 3: bk.showbuses(dos);
        	                break;
        	            case 4: bk.checkbus(dis,dos);
        	                break;
        	        }
        	    }
        	    else if(ch == 2) {
        	        dos.writeUTF("Press 1 to see buses");
        	        dos.writeUTF("Press 2 to book ticket");
        	        dos.writeUTF("Press 3 to cancel ticket \nEnter");
        	        temp = dis.readUTF();
        	    	int choice = Integer.parseInt(temp);
        	        switch(choice) {
        	            case 1: bk.showbuses(dos);
        	                break;
        	            case 2: bk.bookticket(dis,dos);
        	                break;
        	            case 3: bk.cancelticket(dis,dos);
        	                break;
        	        }
        	    }
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
        	    dos.writeUTF("Do you want to continue? Enter");
        	    String c = dis.readUTF();
        	    if(!c.equals("y")) {
        	    	bk.updatedata();
        	        break;
        	    }
        	}
        	this.dis.close();
        	this.dos.close();
		}
		catch(IOException i) {
			System.out.println(i);
		}
    }
}


