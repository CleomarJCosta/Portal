package com.store.car.service;

import com.store.car.dto.CarPostDTO;

import java.util.List;

public interface CarPostService {
    void newPostDetails(CarPostDTO carPostDTO);
    List<CarPostDTO> getCarSales();
    void changeCarSales(CarPostDTO carPostDTO, Long id);

    void removeCarSale(Long postId);
}
