package com.letsgo.client;

import com.letsgo.data.entities.Ticket;
import com.letsgo.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

//@Component
@RequiredArgsConstructor
public class TicketClient implements ApplicationRunner {

    private final TicketService ticketService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        final var ticket = new Ticket();
//        ticket.setOrigin("egypt");
//        ticket.setDestination("KSA");
//        ticketService.bookTicket(ticket);

        Thread.sleep(5000);
        final var ticket = ticketService.getTicketById(1L);
        System.out.println(ticket.get().getCreatedAt());
        Thread.sleep(2000);
    }
}
