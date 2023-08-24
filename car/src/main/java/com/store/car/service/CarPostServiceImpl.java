package com.store.car.service;

import com.store.car.dto.CarPostDTO;
import com.store.car.entity.CarPostEntity;
import com.store.car.repository.CarPostRepository;
import com.store.car.repository.OwnerPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService{
    @Autowired
    private CarPostRepository carPostRepository;
    @Autowired
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
       List<CarPostDTO> listCarsSales = new ArrayList<>();
       carPostRepository.findAll().forEach(item->{
           listCarsSales.add(mapCarEntityToDTO(item));
       });
       return listCarsSales;
    }

    @Override
    public void changeCarSales(CarPostDTO carPostDTO, Long id) {
        carPostRepository.findById(id).ifPresentOrElse(item->{
            item.setDescription(carPostDTO.getDescription());
            item.setContact(carPostDTO.getContact());
            item.setPrice(carPostDTO.getPrice());
            item.setBrand(carPostDTO.getBrand());
            item.setEngineVersion(carPostDTO.getEngineVersion());
            item.setModel(carPostDTO.getModel());

            carPostRepository.save(item);

        }, ()->{
            throw new NoSuchElementException();
        });

    }

    @Override
    public void removeCarSale(Long postId) {
        carPostRepository.deleteById(postId);
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity){
        return CarPostDTO.builder()
                .brand(carPostEntity.getBrand())
                .city(carPostEntity.getCity())
                .model(carPostEntity.getModel())
                .description(carPostEntity.getDescription())
                .engineVersion(carPostEntity.getEngineVersion())
                .createdDate(carPostEntity.getCreatedDate())
                .ownerName(carPostEntity.getOwnerPost().getName())
                .price(carPostEntity.getPrice()).build();

    }
}
