package data_control;

import transaction_elements.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketList {
    List<Ticket> tickets;

    public TicketList(){
        tickets = new ArrayList<>();
    }
}
