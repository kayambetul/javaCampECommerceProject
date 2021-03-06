package LoginSignUp.business.abstracts;

public interface UserVerificationService {
	
	void sendVerifyMail(String email);
	void verifyMail(String email);
	boolean checkVerifyAccount(String email);
	
	/*Üyelik sonucu kullanıcıya doğrulama e-postası gönderilmelidir. (Simulasyon)
	Doğrulama linki tıklandığında üyelik tamamlanmalıdır. (Simulasyon)
	Hatalı veya başarılı durumda kullanıcı bilgilendirilmelidir.*/

}
