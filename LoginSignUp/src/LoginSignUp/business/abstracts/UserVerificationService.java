package LoginSignUp.business.abstracts;

public interface UserVerificationService {
	
	void sendVerifyMail(String email);
	void verifyMail(String email);
	boolean checkVerifyAccount(String email);
	
	/*�yelik sonucu kullan�c�ya do�rulama e-postas� g�nderilmelidir. (Simulasyon)
	Do�rulama linki t�kland���nda �yelik tamamlanmal�d�r. (Simulasyon)
	Hatal� veya ba�ar�l� durumda kullan�c� bilgilendirilmelidir.*/

}
