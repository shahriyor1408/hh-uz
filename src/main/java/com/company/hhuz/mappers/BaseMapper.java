package com.company.hhuz.mappers;

import java.util.List;



public interface BaseMapper<E, D, CD, UD> extends GenericMapper {

    E fromDto(D dto);

    E fromCreateDto(CD dto);

    E fromUpdateDto(UD dto);

    D toDto(E domain);

    List<D> toDto(List<E> domains);
}