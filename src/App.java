
public class App {
    
    public static void main(String[] args) {
                      

        System.out.println();
        
        User user1 = new User("ken", "ken@gmail.com", "123");
        User user2 = new User("joe", "joe@gmail.com", "312");
        User user3 = new User("zach", "zach@gmail.com", "456");
        User user4 = new User("vick","vick@gmail.com","2390");

        Group group1 = new Group("group1", user1);
        // Group group2 = new Group("Group2", user1);
        group1.addMember(user2.username);
        group1.addMember(user3.username);
        group1.addMember(user4.username);
        
        Database database = new Database();
        
        //DATABASE TESTINGS:

        //database.getMembersOfGroup(group1);
        database.getMembersOfGroup(group1);
        
        
    }
  
}