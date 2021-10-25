package LoginSignUp.business.abstracts;

import LoginSignUp.entities.concretes.User;

public interface UserCheckService {
	
	boolean checkFirstName(User user);
	boolean checkLastName(User user);
	boolean checkEmail(User user);
	boolean checkUnusedEmail(User user);
	boolean checkPassword(User user);
	boolean isValid(User user);
	boolean checkGoogle(User user);
	

}
