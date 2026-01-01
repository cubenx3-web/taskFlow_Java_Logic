import java.util.ArrayList;
import java.util.HashMap;

public class Group {
   
    public AdminUser admin;
    public String leader;
    public String assistant;
    public String groupName;
    public Group mainGroup;
    public HashMap<String, Group> subGroups = new HashMap<>();
    public ArrayList<String> members = new ArrayList<>();


    //private String access_key;


    //CREATE MAIN GROUP
    Group(String groupName, User user) {
        this.admin = new AdminUser(user);
        this.groupName = groupName;
        new Database(this);
       // System.out.println("First Group: "+this.groupName);
    }

    //CREATE SUB-GROUP
    Group(String groupName, Group mainGroup) {
        this.admin = mainGroup.admin;
        this.groupName = groupName;
        this.mainGroup = mainGroup;
        new Database(this);

        Database
                .groups.get(this.mainGroup.admin.admin.username)
                .get(this.mainGroup.groupName)
                .subGroups.put(this.groupName, this);
        
       // System.out.println(this.groupName+" sub of: "+this.mainGroup.groupName);
    }

    //ADD MEMBER TO GROUP.
    public void addMember(String user) {
        Database database = new Database();
        database.addMemberToGroup(this, user);
    }  
   
}