package test;

public class Data {
	public String firstname = "Fany";
	public String lastname = "Araminta";
	public String password = "pass1234";
	public String email = "@gmail.com";
	public String gender = "wanita";
	public String phone = "1234457654";
	
	public Data(String prefix) {
		email = firstname.toLowerCase() + prefix + email;
	}
}
