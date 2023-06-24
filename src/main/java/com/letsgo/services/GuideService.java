package com.letsgo.services;

import com.letsgo.data.entities.Guide;
import com.letsgo.data.projection.GuideNameSalary;
import com.letsgo.data.repository.GuideRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class GuideService {

    private final GuideRepository guideRepository;
    public Guide findGuideById(final long id) {
        return guideRepository.findById(id).orElseThrow(() -> new NoSuchElementException("guide not found!"));
    }

    public void updateGuide(final Guide guide) {
        guideRepository.save(guide);
    }

    public List<GuideNameSalary> getGuideProjection() {
        return guideRepository.findFirst2BySalaryGreaterThan(new BigDecimal(1800));
    }
}
