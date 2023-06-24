package com.letsgo.client;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//@Component
@RequiredArgsConstructor
@Order(2)
public class OptimisticLockingClient implements ApplicationRunner {

    private final User1Client user1Client;
    private final User2Client user2Client;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(user1Client);
        executor.execute(user2Client);
        executor.shutdown();
    }
}
