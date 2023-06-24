package com.letsgo.client;

import com.letsgo.data.entities.Guide;
import com.letsgo.data.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

//@Component
@RequiredArgsConstructor
@Order(1)
public class PopulateDBClient implements ApplicationRunner {

    private final GuideRepository guideRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        final var guide_1 = Guide.builder().name("Ahmed").salary(new BigDecimal(1800)).build();
        final var guide_2 = Guide.builder().name("Rawan").salary(new BigDecimal(2000)).build();
        final var guide_3 = Guide.builder().name("Lucinda").salary(new BigDecimal(3000)).build();
        guideRepository.saveAll(List.of(guide_1,guide_2,guide_3));
    }
}
