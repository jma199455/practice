package com.example.demo.dto;

import lombok.Data;

@Data
public class UsersVO {
 
    private String id;  
    private String pw;  
    private String userName;
 
    /*  
    public String getId() {
        return id;
    }
    public String getPw() {
        return pw;
    }
    public void setPw(String pw) {
        this.pw = pw;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }   
    @Override
        public String toString() {          
            return "UsersVO [Id = " + id+ ",Pw = " + pw + ",UserName = " + userName + "]" ;
        }   
    */
    
}
