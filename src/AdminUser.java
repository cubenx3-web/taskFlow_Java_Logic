public class AdminUser {
    
    public User admin;
    
    
    AdminUser(User user) {
        this.admin = user;
        new Database(this);
    }
    
    public void createGroup(String groupName) {
        new Group(groupName, this.admin);
    }
    
    public void createSubGroup( String groupName, Group mainGroup ) {
        new Group(groupName,this.admin, mainGroup); 
    }
} 
