package com.rays.collection;

public class DataSource {
	
	private String url;
	private String  user;
	@Override
	public String toString() {
		return "DataSource [url=" + url + ", user=" + user + ", password=" + password + "]";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	

}
