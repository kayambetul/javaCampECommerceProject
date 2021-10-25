package LoginSignUp.business.concretes;

import java.util.ArrayList;
import java.util.List;

import LoginSignUp.business.abstracts.UserVerificationService;

public class UserVerificationManager implements UserVerificationService{

	List<String> emails=new ArrayList<String>();
	
	@Override
	public void sendVerifyMail(String email) {
		System.out.println("Doðrulama emaili gönderildi.");
		
	}

	@Override
	public void verifyMail(String email) {
		System.out.println("Emailinizi doðruladýnýz.");
		emails.add(email);
		
		
		
	}

	@Override
	public boolean checkVerifyAccount(String email) {
		if(emails.contains(email)==true) {
			System.out.println("Bu email doðrulanmýþ email içerisindedir.");
			return true;
		}else {
			System.out.println("Bu email doðrulanamadý.");
		return false;
	}
	}

}
