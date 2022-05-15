package com.dsc.stadium.repository;

import com.dsc.stadium.dto.StadiumDto;
import com.dsc.stadium.filter.SearchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomStadiumRepository {
    List<StadiumDto> getList(Double latitude, Double longitude);
}
