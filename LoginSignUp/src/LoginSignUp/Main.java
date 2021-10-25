package LoginSignUp;

import LoginSignUp.business.abstracts.UserService;
import LoginSignUp.business.concretes.UserCheckManager;
import LoginSignUp.business.concretes.UserManager;
import LoginSignUp.business.concretes.UserVerificationManager;
import LoginSignUp.core.concretes.GoogleLoggerAdapter;
import LoginSignUp.dataAccress.concretes.HibernateUserDao;
import LoginSignUp.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService=new UserManager(new HibernateUserDao(),new UserCheckManager(),
				new UserVerificationManager(),new GoogleLoggerAdapter());
		
		User user =new User(1,"Ümmü Betül","Kayam","betulkayam24@gmail.com","12345");
		userService.login(user);
		//userService.signUp(user);
		

	}

}
