package com.letsgo.services;

import com.letsgo.data.entities.Ticket;
import com.letsgo.data.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    @Transactional
    public void bookTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    public Optional<Ticket> getTicketById(final Long id){
        return ticketRepository.findById(id);
    }
}
