package com.analytics.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarPriceAnalyticsRepository extends JpaRepository<CarPriceAnalyticsRepository, Long> {
}
