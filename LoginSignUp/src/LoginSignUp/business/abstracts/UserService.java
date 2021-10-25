package LoginSignUp.business.abstracts;

import LoginSignUp.entities.concretes.User;

public interface UserService {
	
	void login(User user);
	void signUp(User user);

	//Yap�lacak i�lemler bir sisteme giri� ve �yelik.
	//Bu i�lemler i�in baz� �artlar var 
	//Burada bu �artlar�n sa�lanmas� durumunda giri� ve �yelik yap�ld� mesaj� vermek..
	
}
