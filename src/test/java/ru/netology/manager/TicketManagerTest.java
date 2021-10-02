package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket first = new Ticket(1, "DME", "KUF", 11000, 2);
    Ticket second = new Ticket(1, "DME", "LED", 14000, 3);
    Ticket third = new Ticket(1, "DME", "LED", 12000, 3);
    Ticket fourth = new Ticket(1, "DME", "KUF", 10000, 2);
    Ticket fifth = new Ticket(1, "DME", "KUF", 14000, 2);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
    }

    @Test
    public void shouldSearchByTickedKUF() {

        Ticket[] actual = manager.searchBy("DME", "KUF");
        Ticket[] expected = new Ticket[]{fourth, first, fifth};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByTickedLED() {

        Ticket[] actual = manager.searchBy("DME", "LED");
        Ticket[] expected = new Ticket[]{third, second};
        assertArrayEquals(expected, actual);
    }

}