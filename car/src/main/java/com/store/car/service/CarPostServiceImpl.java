package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class CarPostServiceImpl implements CarPostService{
    @Autowired
    private CarPostRepository carPostRepository;

    private OwnerPostRepository ownerPostRepository;
    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO) {
        CarPostEntity carPostEntity = new CarPostEntity();
        ownerPostRepository.findById(carPostDTO.getOwnerId()).ifPresentOrElse(item->{
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(carPostDTO.getContact());
        }, ()->{
            throw new RuntimeException();
        });
        carPostEntity.setModel(carPostDTO.getModel());
        carPostEntity.setBrand(carPostDTO.getBrand());
        carPostEntity.setCity(carPostDTO.getCity());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));
        carPostEntity.setDescription(carPostDTO.getDescription());
        carPostEntity.setEngineVersion(carPostDTO.getEngineVersion());
        carPostEntity.setPrice(carPostDTO.getPrice());

        return carPostEntity;

    }

    @Override
    public List<CarPostDTO> getCarSales() {
        return null;
    }

    @Override
    public void changeCarSales(CarPostDTO carPostDTO, Long id) {

    }

    @Override
    public void removeCarSale(Long postId) {

    }
}
