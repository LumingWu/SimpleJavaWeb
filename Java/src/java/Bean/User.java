package Bean;

import java.io.Serializable;

public class User implements Serializable {
    
    private int userid;
    private String firstname;
    private String lastname;
    private String middlename;
    private String nickname;
    private String password;
    
    public User() {
        
    }
    
    public void setUserid(int u){
        userid = u;
    }
    
    public int getUserid(){
        return userid;
    }
    
    public void setFirstname(String f){
        firstname = f;
    }
    
    public String getFirstname(){
        return firstname;
    }
    
    public void setLastname(String l){
        lastname = l;
    }
    
    public String getLastname(){
        return lastname;
    }
    
    public void setMiddlename(String m){
        middlename = m;
    }
    
    public String getMiddlename(){
        return middlename;
    }
    
    public void setNickname(String n){
        nickname = n;
    }
    
    public String getNickname(){
        return nickname;
    }
    
    public void setPassword(String p){
        password = p;
    }
    
    public String getPassword(){
        return password;
    }
    
}
