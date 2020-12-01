package User_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Data_control.DataController;

/**
 * manages the user interface
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class UIManager {
	/**
	 * Home page
	 */
	private static Homepage homepage;
	/**
	 * Page to cancel ticket
	 */
	private static CancellationPage cancelpage;
	/**
	 * Page that handles new registration of users
	 */
	private static RegisterForm registerpage;
	/**
	 * Page that handles login 
	 */
	private static LoginPage loginpage;
	/**
	 * Page that displays movies, theatres, and its showings
	 */
	private static MoviePage moviepage;
	
	/**
	 * Ensure that only one copy of this class is constructed during
	 * the lifetime of the program 
	 */
	private static UIManager singleInstance;
	
	/**
	 * Constructs an object of UIManager
	 */
	private UIManager() {
		homepage = new Homepage();
		cancelpage= new CancellationPage();
		registerpage = new RegisterForm();
		loginpage = new LoginPage();
	}
	
	/**
	 * If UIManager does not exist, constructs a new one; otherwise
	 * returns the object that already exists
	 * @return UIManager
	 */
	public static UIManager getUIManager() {
		if (singleInstance==null) {
			singleInstance= new UIManager();
		}
		return singleInstance;
	}
	
	/**
	 * Opens homepage and adds listeners to homepage
	 */
	public void openHomepage() {
		homepage.setVisible(true);
		addListenersToHome();
	}
	
	/**
	 * Closes homepage
	 */
	public void closeHomepage() {
		homepage.closeHomepage();
	}
	
	/**
	 * Opens cancel page and adds listeners to cancellation page
	 */
	public void openCancelPage() {
		cancelpage.setVisible(true);
		addListenersToCancel();
	}
	
	/**
	 * Closes cancel page
	 */
	public void closeCancelPage() {
		cancelpage.setVisible(false);
		cancelpage.dispose();
	}
	
	/**
	 * Opens registration form and add listeners to registration page
	 */
	public void openRegisterForm() {
		registerpage.setVisible(true);
		addListenersToRegister();
	}
	
	/**
	 * Closes registration form
	 */
	public void closeRegisterForm() {
		registerpage.setVisible(false);
		registerpage.dispose();
	}
	
	/**
	 * Opens login page and adds listeners to login page
	 */
	public void openLogin() {
		loginpage.setVisible(true);
		addListenersToLogin();
	}
	
	/**
	 * Closes login page
	 */
	public void closeLogin() {
		loginpage.setVisible(false);
		loginpage.dispose();
	}
	
	/**
	 * Opens movie page and add listeners to movie page
	 */
	public void openMoviePage() {
		if (moviepage==null) {
			moviepage = new MoviePage();
		}
		else {
			closeMoviePage();
			moviepage = new MoviePage();
		}
		moviepage.setVisible(true);
		addListenersToPurchase();
	}
	
	/**
	 * Closes movie page
	 */
	public void closeMoviePage() {
		moviepage.setVisible(false);
		moviepage.dispose();
	}
	
	/**
	 * Returns whether or not user is registered/logged in
	 * @return registeredUser 
	 */
	public boolean registeredUser() {
		return homepage.getRegisteredUser();
	}
	
	/**
	 * Sets admin member in homepage
	 */
	public void setAdmin() {
		homepage.setIsAdmin();
	}
	
	/**
	 * Adds listeners to home page 
	 */
	public void addListenersToHome(){
		homepage.addCancelTicketListener(new navigateHomeToCancel());
		homepage.addRegisterListener(new navigateHomeToRegister());
		homepage.addLoginListener(new navigateHomeToLogin());
		homepage.addPurchaseTicketListener(new navigateHomeToMovie());
	}
	
	/**
	 * Adds listeners to registration page
	 */
	public void addListenersToRegister() {
		registerpage.addBackListener(new navigateRegisterToHome());
		registerpage.addLoginListener(new navigateRegisterToLogin());
	}
	
	/**
	 * Adds listeners to login page
	 */
	public void addListenersToLogin() {
		loginpage.addBackListener(new navigateLoginToHome());
		loginpage.addRegisterListener(new navigateLoginToRegister());
	}
	
	/**
	 * Adds listeners to movie page
	 */
	public void addListenersToPurchase() {
		moviepage.addBackListener(new navigateMovieToHome());
		
	}
	
	/**
	 * Adds listeners to cancellation page
	 */
	public void addListenersToCancel() {
		cancelpage.addBackListener(new navigateCancelToHome());
	}
	
	/**
	 * Sets username member on the homepage
	 * @param username: String
	 */
	public void setUsername(String username) {
		homepage.setUsername(username);
	}
	
	/**
	 * Returns username member from homepage
	 * @return username
	 */
	public String getUsername() {
		return homepage.getUsername();
	}
	
	/**
	 * Button listener, navigates from home page to cancellation page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateHomeToCancel implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openCancelPage();
		}
	}
	
	/**
	 * Button listener, navigates from home page to registration page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateHomeToRegister implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openRegisterForm();
		}
	}
	
	/**
	 * Button listener, navigates from home page to login page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateHomeToLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openLogin();
		}
	}
	
	/**
	 * Listener class, navigates from registration page to home page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateRegisterToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeRegisterForm();
			openHomepage();
		}
	}
	
	/**
	 * Listener class, navigates from login page to home page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateLoginToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeLogin();
			openHomepage();
		}
	}
	
	/**
	 * Listener class, navigates from login page to registration page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateLoginToRegister implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeLogin();
			openRegisterForm();
		}
	}
	
	/**
	 * Listener class, navigates from registration page to login page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateRegisterToLogin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeRegisterForm();
			openLogin();
		}
	}
	
	/**
	 * Listener class, navigates from home page to movie page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateHomeToMovie implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeHomepage();
			openMoviePage();
		}
	}
	
	/**
	 * Listener class, navigate from movie page to home page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateMovieToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeMoviePage();
			openHomepage();
		}
	}
	
	/**
	 * Listener class, navigate from cancellation page to home page
	 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
	 *
	 */
	public class navigateCancelToHome implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			closeCancelPage();
			openHomepage();
		}
	}
	
}
