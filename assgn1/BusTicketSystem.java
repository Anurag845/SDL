import java.util.*;

class BusTicketSystem {
    public static void main(String args[]) {
        Booking bk = new Booking();
        bk.initialize();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Press 1 to login as admin");
            System.out.println("Press 2 to login as user");
            int ch = sc.nextInt();
            if(ch == 1) {
                System.out.println("Press 1 to add bus");
                System.out.println("Press 2 to cancel bus");
                System.out.println("Press 3 to see buses");
                System.out.println("Press 4 to check status of particular bus");
                int choice = sc.nextInt();
                switch(choice) {
                    case 1: bk.addbus();
                        break;
                    case 2: bk.cancelbus();
                        break;
                    case 3: bk.showbuses();
                        break;
                    case 4: bk.checkbus();
                        break;
                }
            }
            else if(ch == 2) {
                System.out.println("Press 1 to see buses");
                System.out.println("Press 2 to book ticket");
                System.out.println("Press 3 to cancel ticket");
                int choice = sc.nextInt();
                switch(choice) {
                    case 1: bk.showbuses();
                        break;
                    case 2: bk.bookticket();
                        break;
                    case 3: bk.cancelticket();
                        break;
                }
            }
            System.out.println("Do you want to continue?");
            String c = sc.next();
            if(!c.equals("y")) {
                break;
            }
        }
    }
}

