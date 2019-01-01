import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


class client{

	public static void main(String[] args)
	{
		try
		{
		Socket s = new Socket("localhost",3000);

		System.out.println("\n**********************CONNECTED TO SERVER*******************\n");
		
		DataInputStream dis = new DataInputStream(s.getInputStream());
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		Scanner in = new Scanner(System.in);

		String msg="",input,text;

		while(true)
		{
			text= dis.readUTF();
			
			if(text.indexOf("ENTER")>=0)
			{
				JOptionPane.showMessageDialog(null,msg,"RESULT",JOptionPane.PLAIN_MESSAGE);
				msg=text="";
				input= JOptionPane.showInputDialog("Enter Your Choice: ");
				dos.writeUTF(input);
			}
			msg += text;	
		}

		}
		catch(Exception e){}
	}
}
