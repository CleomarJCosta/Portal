package com.analytics.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Table(name = "car_model_analytics")
@Entity
@NoArgsConstructor
@Data
public class CarModelAnalyticsEntity {
    @GeneratedValue()
    private Long id;

    private String model;

    private Long posts;
}
