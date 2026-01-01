import java.util.HashMap;

public class Database {

    static HashMap<String,User> users = new HashMap<>();
    static HashMap<String, HashMap<String, Group>>groups = new HashMap<>() ;
    static HashMap<String, AdminUser> admins = new HashMap<>();


    Database() {}

    //STORE USERS
    Database(User user) {
        Database.users.put(user.username, user);
        //System.out.println("Stored: "+user.username);
    }

    //STORE GROUPS
    Database(Group group) {
        
        if (isAdmin(group.admin.admin)) {
            Database
            .groups.get(group.admin.admin.username).put(group.groupName, group);
        } else {
            Database.groups.put(group.admin.admin.username, new HashMap<>());
            Database.groups.get(group.admin.admin.username).put(group.groupName, group);
        }

        //System.out.println("Added new group: " + group.groupName + "\nOwed by: " + group.admin.admin.username);
    }
    
    //STORE ADMINS
    Database(AdminUser admin) {
        if (Database.groups.get(admin.admin.username) == null) {
            Database.admins.put(admin.admin.username, admin);
            //System.out.println("New admin: " + admin.admin.username);
        } else {
            //System.out.println("Is Already admin");
         }
    }

    

    //GET USER, GROUP, ADMINS... Just names

    public void getUserNames() {
        
        System.out.println("______USERS______");

        for (String user : Database.users.keySet()) {
            System.out.println("--> "+ Database.users.get(user).username);            
        }
    }

    public void getAllGroupNames() {

        for (String a : Database.groups.keySet()) {
            
            System.out.println(a + "__: ");
            
            for (String g : Database.groups.get(a).keySet()) {
                System.out.println("\t->"+groups.get(a).get(g).groupName);
            }
        }
    }

    public void getAdminNames() {
        for (String adminUser : Database.admins.keySet()) {
            System.out.println(adminUser);
        }
    }


    //CHECK IF USER, ADMIN, GROUP... EXISTS

    public boolean isUser(User user) {
        boolean exists = (Database.users.get(user.username) == null)? false : true;
        
        
        return exists;
    }

    public boolean isAdmin(User user) {

        boolean exists = (Database.groups.get(user.username) == null)
                            ? false : true ;

        
        return exists;
    }

    public boolean isGroup(Group group) {
        boolean exists = false;

        return exists;
    }


    //CHECK FOR GROUPS OWNED BY SAID ADMIN    
    public void myGroups(User user) {
        if (isAdmin(user)) {
            System.out.println("___" + user.username + "\'s Groups___");
            for (String g : Database.groups.get(user.username).keySet()) {
                System.out.println("---> " + groups.get(user.username).get(g).groupName);
            }
        } else {
            System.out.println("Has no Groups");
        }
    }

    public void myGroup(AdminUser user) {
        System.out.println("___" + user.admin.username + " Groups___");
        for (String g : Database.groups.get(user.admin.username).keySet()) {
            System.out.println("---> " + groups.get(user.admin.username).get(g).groupName);
        }
    }


    //ADD MEMBER   
    public void addMemberToGroup(Group group, String user) {
        Database.groups.get(group.admin.admin.username).get(group.groupName).members.add(user);
        Database.users.get(user).joinedGroups.add(group.groupName);
    }


    //GETTING GROUP MEMBERS...    
    public void getMembersOfGroup(Group group) {
        System.out.println("\n" + "Group: " + group.groupName);

        if (group.members.size() > 0) {
            for (String member : group.members) {
                System.out.println(" --> " + member);
            }
        }
        else {
            System.out.println("Has no members");
        }
       
    }

    

}
