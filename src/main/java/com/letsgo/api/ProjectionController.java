package com.letsgo.api;

import com.letsgo.data.projection.GuideNameSalary;
import com.letsgo.services.GuideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectionController {

    private final GuideService guideService;

    @GetMapping("/guides-projection")
    public ResponseEntity<List<GuideNameSalary>> getGuideProjection() {
        List<GuideNameSalary> result = guideService.getGuideProjection();
        return ResponseEntity.ok().body(result);
    }

}
