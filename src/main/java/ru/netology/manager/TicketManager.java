package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public Ticket[] searchBy(String codFrom, String codTo) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll(codFrom, codTo)) {
            if (matches(ticket, codFrom, codTo)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return Ticket[].sort(result);
    }

    public boolean matches(Ticket ticket, String searchDep, String searchAr) {

        if (ticket.getDepartureAirport().contains(searchDep) && (ticket.getArrivalAirport().contains(searchAr))) {
            return true;
        }
        return false;
    }

    public void add(Ticket ticket) { repository.save(ticket); }
}
