public class AdminUser {
    
    public User admin;
    
    
    AdminUser(User user) {
        this.admin = user;
        new Database(this);
    }
    
    public void createGroup(String groupName) {
        new Group(groupName, this.admin);
    }
    
    public void createSubGroup(String groupName, Group mainGroup) {
        new Group(groupName, mainGroup);
    }
    
    public void getAllMyGroup() {
        Database database = new Database();
        //database.myGroups(this.admin);

        for (String groupKey : Database.groups.get(this.admin.username).keySet()) {

            Group group = Database.groups.get(this.admin.username).get(groupKey);

            if (group.mainGroup == null) {
                mkTree(group, 0);
            } else {
                continue;
            }
        }

    }

    public void mkTree(Group group, int i) {
        if (!(group.subGroups.isEmpty())) {
            for (int j = 0; j < i; j++) {
                System.out.print(" _ ");
            }
            System.out.println(group.groupName+">> ");    
            for (String g : group.subGroups.keySet()) {
                for (int j = 0; j<i; j++){
                    System.out.print(" _ ");
                }
                //System.out.println(" " + group.subGroups.get(g).groupName);
                mkTree(group.subGroups.get(g), i+1);
                                
            }
        }
        else {
            for (int j = 0; j < i; j++) {
                System.out.print(" _ ");
            }
            System.out.println(group.groupName);
        }
        
    }




} 
