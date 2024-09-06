package com.example.ProjectForTesting.Mapper;


import com.example.ProjectForTesting.Dto.ShippingDto;
import com.example.ProjectForTesting.Entity.Shipping;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShippingMapper {

    ShippingMapper INSTANCE = Mappers.getMapper(ShippingMapper.class);

    ShippingDto toDto(Shipping shipping);
    Shipping toEntity(ShippingDto userDto);
}
