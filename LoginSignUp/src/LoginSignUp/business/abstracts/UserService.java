package LoginSignUp.business.abstracts;

import LoginSignUp.entities.concretes.User;

public interface UserService {
	
	void login(User user);
	void signUp(User user);

	//Yapýlacak iþlemler bir sisteme giriþ ve üyelik.
	//Bu iþlemler için bazý þartlar var 
	//Burada bu þartlarýn saðlanmasý durumunda giriþ ve üyelik yapýldý mesajý vermek..
	
}
