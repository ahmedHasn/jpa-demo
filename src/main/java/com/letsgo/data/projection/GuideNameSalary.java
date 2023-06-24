package com.letsgo.data.projection;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface GuideNameSalary {

    String getName();
    BigDecimal getSalary();

    LocalDateTime getCreatedAt();
    LocalDateTime getUpdatedAt();
}
