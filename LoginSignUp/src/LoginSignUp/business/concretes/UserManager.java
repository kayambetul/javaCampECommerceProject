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
		//Giriþ yapýlmasý için email-password þart
		//ve giriþin olup olmamasýna göre bildirim 
		if(checkService.isValid(user)==true) {
			System.out.println("Giriþ yapýldý.");
		}
		else {
			System.out.println("Giriþ baþarýsýz.");
		}
	}

	@Override
	public void signUp(User user) {
		//Üyelik için paralo en az 6 karakter 
		//eposta eposta formatýnda ve daha önce kullanýlmamýþ olmalý
		//ad soyad en az iki karakterli
		//üyelik sonucunda kullanýcýya eposta gönderilmeli-doðrulama linki týklandýðýnda 
		//üyelik tamamlandý mesajý almalý
		//hatalý baþarýlý durumu bildirilmeli
		if(checkService.isValid(user)==true) {
			System.out.println(user.getFirstName()+ " ismiyle kaydolundu.");
			verificationService.sendVerifyMail(user.getEmail());
			this.userDao.add(user);
		}
		else {
			System.out.println("Bilgilerinizi kontrol ediniz.");
		}
		
		
		
	}
	
	//dýþ loglamam ile google ile üyelik yapýlmalý

}

//yukarýdaki bilgilerin kontrolü baþka bir interfacede yapýlýp buraya entegre edilcek.