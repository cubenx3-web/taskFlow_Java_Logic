
public class App {
    
    public static void main(String[] args) {
                      

        System.out.println();
        
        User user1 = new User("ken", "ken@gmail.com", "123");
        //User user2 = new User("Joe", "ken@gmail.com", "07734");

        Group a = new Group("A", user1);
        Group b = new Group("B", a);
        new Group("C1", b);
        Group c2 = new Group("C2", b);
        new Group("D", c2);
        Group a2 = new Group("A2", user1);


        
        Database database = new Database();
        
        //DATABASE TESTINGS:
        //System.out.println("\n");
        Database.admins.get(user1.username).getAllMyGroup();
        
        
    }
  
}