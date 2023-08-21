package com.portal.api.service;

import com.portal.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {
    public List<CarPostDTO> getCarForSales();

   public void changeCarForSale(CarPostDTO carPost, String id);

   public void removeCarForSale(String id);

}