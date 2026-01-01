import java.util.ArrayList;

public class User {
   
    public String email;
    public String username;
    public String phone;
    public ArrayList<String> joinedGroups = new ArrayList<>();
    
    User() {
    }

    User(String username, String email, String phone) {
        this.username = username;
        this.email = email;
        this.phone = phone;

        new Database(this);
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    

    //IMPROVEMENT WILL BE NEED HERE
    //SO THAT USER WILL NEED A LINK/KEY
    public void joinGroup(String groupName) {
        Database.users.get(this.username).joinedGroups.add(groupName);
    }
}
