package LoginSignUp.business.abstracts;

public interface UserVerificationService {
	
	void sendVerifyMail(String email);
	void verifyMail(String email);
	boolean checkVerifyAccount(String email);
	
	/*Üyelik sonucu kullanýcýya doðrulama e-postasý gönderilmelidir. (Simulasyon)
	Doðrulama linki týklandýðýnda üyelik tamamlanmalýdýr. (Simulasyon)
	Hatalý veya baþarýlý durumda kullanýcý bilgilendirilmelidir.*/

}
