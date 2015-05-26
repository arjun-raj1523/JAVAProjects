package Login;

public class Login {
String uid,pass;




public Login() {
	super();
	
}

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public String getPass() {
	return pass;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String isValid(){
		
	if(uid.equals("1")&& pass.equals("2"))
		return ("Valid");
	else
		return ("Not Valid");

}
}
