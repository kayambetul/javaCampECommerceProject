package LoginSignUp.business.concretes;

import LoginSignUp.business.abstracts.UserCheckService;
import LoginSignUp.business.abstracts.UserService;
import LoginSignUp.business.abstracts.UserVerificationService;
import LoginSignUp.core.abstracts.GoogleLoggerService;
import LoginSignUp.dataAccress.abstracts.UserDao;
import LoginSignUp.entities.concretes.User;

public class UserManager implements UserService{

    private UserDao userDao;
    private UserCheckService checkService;
    private UserVerificationService verificationService;
    private GoogleLoggerService googleService;
    
	public UserManager(UserDao userDao, UserCheckService checkService, UserVerificationService verificationService,
			GoogleLoggerService googleService) {
		super();
		this.userDao = userDao;
		this.checkService = checkService;
		this.verificationService = verificationService;
		this.googleService = googleService;
	}

	@Override
	public void login(User user) {
		//Giri� yap�lmas� i�in email-password �art
		//ve giri�in olup olmamas�na g�re bildirim 
		if(checkService.isValid(user)==true) {
			System.out.println("Giri� yap�ld�.");
		}
		else {
			System.out.println("Giri� ba�ar�s�z.");
		}
	}

	@Override
	public void signUp(User user) {
		//�yelik i�in paralo en az 6 karakter 
		//eposta eposta format�nda ve daha �nce kullan�lmam�� olmal�
		//ad soyad en az iki karakterli
		//�yelik sonucunda kullan�c�ya eposta g�nderilmeli-do�rulama linki t�kland���nda 
		//�yelik tamamland� mesaj� almal�
		//hatal� ba�ar�l� durumu bildirilmeli
		if(checkService.isValid(user)==true) {
			System.out.println(user.getFirstName()+ " ismiyle kaydolundu.");
			verificationService.sendVerifyMail(user.getEmail());
			this.userDao.add(user);
		}
		else {
			System.out.println("Bilgilerinizi kontrol ediniz.");
		}
		
		
		
	}
	
	//d�� loglamam ile google ile �yelik yap�lmal�

}

//yukar�daki bilgilerin kontrol� ba�ka bir interfacede yap�l�p buraya entegre edilcek.