import java.util.ArrayList;

public class Group {
   
    public AdminUser admin;
    public String leader;
    public String assistant;
    public String groupName;
    public Group mainGroup;
    public ArrayList<String> members = new ArrayList<>();

    //private String access_key;


    //CREATE MAIN GROUP
    Group(String groupName, User user) {
        this.admin = new AdminUser(user);
        this.groupName = groupName;
        new Database(this);
    }

    //CREATE SUB-GROUP
    Group(String groupName, User user, Group mainGroup) {
        this.admin = new AdminUser(user);
        this.groupName = groupName;
        this.mainGroup = mainGroup;
        new Database(this);
    }

    //ADD MEMBER TO GROUP.
    public void addMember(String user) {
        Database database = new Database();
        database.addMemberToGroup(this, user);
    }  
   
}