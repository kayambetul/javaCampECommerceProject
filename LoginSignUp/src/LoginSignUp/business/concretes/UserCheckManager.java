package LoginSignUp.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import LoginSignUp.business.abstracts.UserCheckService;

import LoginSignUp.entities.concretes.User;

public class UserCheckManager implements UserCheckService{

	//Email listeye ekleyip daha önce kullanılıp kullanılmadığının kontrolü sağlancak.
	List<String> email=new ArrayList<String>();
	
	
	@Override
	public boolean checkFirstName(User user) {
		if(user.getFirstName().isEmpty()==true) {
			System.out.println("İsim kısmını doldurunuz..");
			return false;
		}
		else if(user.getFirstName().length()<2){
			System.out.println("İsim en az iki karakter olmalı..");
			return false;

		}else {
		   return true;
		
		}
	}

	@Override
	public boolean checkLastName(User user) {
		if(user.getLastName().isEmpty()==true) {
			System.out.println("Soyisim kısmını doldurunuz..");
			return false;
		}
		else if(user.getLastName().length()<2){
			System.out.println("Soyisim en az iki karakter olmalı..");
			return false;

		}else {
		   return true;
		
		}
		
	}
   //email formatı için 
	@Override
	public boolean checkEmail(User user) {
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
		if(user.getEmail().isEmpty()) {
			System.out.println("Email alaný boþ geçilemez! ");
			return false;
		}else if(pattern.matcher(user.getEmail()).find() == false) {
			System.out.println("Email adresinizi formata uygun giriniz. Örnek: example@example.com ");
			return false;
		}else {
			return true;
		}
		
		
	}
	
   //emailin kullanılıp kullanılmadıpını kontrol edicez..
	@Override
	public boolean checkUnusedEmail(User user) {
		if(email.contains(user.getEmail())) {//kullanılmışsa tekrar dene 
			System.out.println("bu email kullanılmış.Başka bir email ile tekrar dene !");
			return false;
		}
		else {//eğer kullanılmamışsa liste ekle 
			email.add(user.getEmail());
			return true;
		}
		
	}

	//password altı karakter
	@Override
	public boolean checkPassword(User user) {
		if(user.getPassword().isEmpty()==true) {
			System.out.println("Passwordu doldurunuz.");
			return false;
		}
		else if(user.getPassword().length()<6) {
			System.out.println("Password en az 6 karakter olmalı");
			return false;
		}else {
			return true;
			
		}
		
		
	}

	//Üyelik ve Giriş için eğer şartlar uyuyorsa doğrulama yapıcazz..
	@Override
	public boolean isValid(User user) {
		if(checkFirstName(user) && checkLastName(user)&& checkEmail(user)&&checkPassword(user)&&checkUnusedEmail(user)==true) {
			return true;
		}else if(checkFirstName(user) && checkLastName(user)&& checkEmail(user)&&checkPassword(user)&&checkUnusedEmail(user)&&checkGoogle(user) ==true) {
			return true;
		}
		else {
			return false;
		}
		
	}
  //googledan giriş için email formatında olup olmadığına bakılır.
	@Override
	public boolean checkGoogle(User user) {
		String regex = "gmail.com";
		if(user.getEmail().contains(regex)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	
}
