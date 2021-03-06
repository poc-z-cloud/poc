package poc.spring.boot.domain.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
 

@Entity
public class Role extends AbstractNamedDomainClass {
 
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "role_id"),
         inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users = new ArrayList<>();
 
    public List<User> getUsers() {
        return users;
    }
 
    public void setUsers(List<User> users) {
        this.users = users;
    }
 
    public void addUser(User user){
        if(!this.users.contains(user)){
            this.users.add(user);
        }
 
        if(!user.getRoles().contains(this)){
            user.getRoles().add(this);
        }
    }
 
    public void removeUser(User user){
        this.users.remove(user);
        user.getRoles().remove(this);
    }
 
}