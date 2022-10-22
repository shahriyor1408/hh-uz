package team.one.hhuz.map;

import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;
import team.one.hhuz.domain.Company;
import team.one.hhuz.dto.CompanyCreateDto;
import team.one.hhuz.dto.CompanyDto;
import team.one.hhuz.dto.CompanyUpdateDTO;

@Mapper(componentModel = "spring")
public interface CompanyMapping extends BaseMapper<Company, CompanyDto, CompanyCreateDto, CompanyUpdateDTO>  {

    @Override
    Company fromCreateDto(CompanyCreateDto dto);
}
