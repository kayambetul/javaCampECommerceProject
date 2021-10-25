package LoginSignUp.core.concretes;

import LoginSignUp.core.abstracts.GoogleLoggerService;
import LoginSignUp.googleControlerLogger.GoogleControllerLogger;

public class GoogleLoggerAdapter implements GoogleLoggerService{

	@Override
	public void logToSystem(String message) {
		GoogleControllerLogger googleManager=new GoogleControllerLogger();
		googleManager.log(message);
		
	}

}
