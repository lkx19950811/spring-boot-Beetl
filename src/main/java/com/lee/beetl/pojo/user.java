package com.lee.beetl.pojo;

import java.util.Date;

/* 
* 
* gen by beetlsql 2018-11-01
*/
public class user  {
	
	private Integer id ;
	private Integer age ;
	//用户角色
	private Integer roleId ;
	private String name ;
	//用户名
	private String userName ;
	private Date date ;
	
	public user() {
	}
	
	public Integer getId(){
		return  id;
	}
	public void setId(Integer id ){
		this.id = id;
	}
	
	public Integer getAge(){
		return  age;
	}
	public void setAge(Integer age ){
		this.age = age;
	}
	
	/**用户角色
	*@return 
	*/
	public Integer getRoleId(){
		return  roleId;
	}
	/**用户角色
	*@param  roleId
	*/
	public void setRoleId(Integer roleId ){
		this.roleId = roleId;
	}
	
	public String getName(){
		return  name;
	}
	public void setName(String name ){
		this.name = name;
	}
	
	/**用户名
	*@return 
	*/
	public String getUserName(){
		return  userName;
	}
	/**用户名
	*@param  userName
	*/
	public void setUserName(String userName ){
		this.userName = userName;
	}
	public Date getDate(){
		return  date;
	}
	public void setDate(Date date ){
		this.date = date;
	}
	

}
