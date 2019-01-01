import java.sql.*;

public class MySQLJDBC {

        Connection cn = null;   
   
    public MySQLJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/anurag?useSSL=false","root","dell");         
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update() throws SQLException {
    	for(Bus b : Global.buses) {
    		writeBus(b);
    	}
    	for(int i : Global.passtick.keySet()) {
    		writeCust(Global.passtick.get(i));
    	}
    }
   
    public void writeBus(Bus b) {
        try {
        	PreparedStatement st = cn.prepareStatement("insert into Buses values(?,?,?,?,?,?,?)");
            //st.executeUpdate("insert into Buses values(b.busno,b.availcount,b.bcount,'b.source','b.destination','b.date',b.fare");
        	st.setInt(1,b.busno);
        	st.setInt(2,b.availcount);
        	st.setInt(3,b.bcount);
        	st.setString(4,b.source);
        	st.setString(5,b.destination);
        	st.setString(6,b.date);
        	st.setInt(7,b.fare);
        	int i = st.executeUpdate();
        	System.out.println(i + " Buses Database Updated");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void writeCust(Customer c) throws SQLException {
    	PreparedStatement st = cn.prepareStatement("insert into Customers values(?,?,?,?,?)");
    	st.setInt(1,c.busno);
    	st.setInt(2,c.bookno);
    	st.setInt(3,c.age);
    	st.setString(4,c.name);
    	st.setInt(5,c.Aadhar);
    	int i = st.executeUpdate();
    	System.out.println(i + " Customers Database Updated");
    }
   
    public void read() {
        try {
        	Statement st = cn.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select * from Buses");
           
            while(rs.next()) {
                int bno = rs.getInt(1);
                int avail = rs.getInt(2);
                int book = rs.getInt(3);
                String  src = rs.getString(4);
                String dest = rs.getString(5);
                String bdate = rs.getString(6);
                int fare = rs.getInt(7);
               
                /*System.out.print("Bus no " + bno + "\t");
                System.out.print("Available " + avail + "\t");
                System.out.print("Booked " + book + "\t");
                System.out.print("Source " + src + "\t");
                System.out.print("Destination " + dest + "\t");
                System.out.print("Date " + bdate + "\t");
                System.out.println("Fare " + fare);*/
               
                Bus b = new Bus(bno,avail,book,src,dest,bdate,fare);
                Global.buses.add(b);
            }
            
            rs = st.executeQuery("select * from Customers");
            int n = 1;
            while(rs.next()) {
            	int bno = rs.getInt(1);
            	int book = rs.getInt(2);
            	int age = rs.getInt(3);
            	String name = rs.getString(4);
            	int ano = rs.getInt(5);
            	
            	Customer c = new Customer(bno,book,age,name,ano);
            	Global.passtick.put(n,c);
            	n++;
            }
            
            
            st.executeUpdate("Delete from Buses");
            st.executeUpdate("Delete from Customers");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}