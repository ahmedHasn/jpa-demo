package com.letsgo.client;

import com.letsgo.data.entities.Guide;
import com.letsgo.services.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

//@Component
@RequiredArgsConstructor
public class User1Client implements Runnable{

    private final GuideService guideService;

    @Override
    public void run() {
        Guide guide = guideService.findGuideById(2L);
        guide.setSalary(new BigDecimal(3000));
        guideService.updateGuide(guide);
    }
}
