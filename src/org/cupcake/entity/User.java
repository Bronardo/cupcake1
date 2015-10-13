package org.cupcake.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3637735074560776557L;

	@Id
	//@GeneratedValue(generator="system-uuid")  
	//@GenericGenerator(name = "system-uuid",strategy="uuid")  
	@Column(length=9)  
	private int user_id;
	
	@Length(min=3,max=45) 
    private String login_name;
    
	@Length(min=3,max=45) 
    private String password;
 
    public int getUser_id() {
        return user_id;
    }
 
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
 
    public String getLogin_name() {
        return login_name;
    }
 
    public void setLogin_name(String login_name) {
        this.login_name = login_name;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
	
}
