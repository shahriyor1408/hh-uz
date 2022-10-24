package com.company.hhuz.mappers;

import com.company.hhuz.domains.Company;
import com.company.hhuz.dtos.CompanyCreateDto;
import com.company.hhuz.dtos.CompanyDto;
import com.company.hhuz.dtos.CompanyUpdateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapping extends BaseMapper<Company, CompanyDto, CompanyCreateDto, CompanyUpdateDTO>  {

    @Override
    Company fromCreateDto(CompanyCreateDto dto);
}
