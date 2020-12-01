package TicketReservationSystemApp;

import User_interface.UIManager;

/**
 * Application for ticket reservation system
 * @author Vic (Vu) Phan, Alex Price, Nitish Pradhan, Luka Petrovic
 *
 */
public class TicketReservationSystem {

	public static void main(String[] args) {
		UIManager uiManager = UIManager.getUIManager();
		uiManager.openHomepage();
	}
}
