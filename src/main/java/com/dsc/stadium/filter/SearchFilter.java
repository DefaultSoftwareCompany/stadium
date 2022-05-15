package com.dsc.stadium.filter;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchFilter {
    private String name;
    private String address;
    private String description;
    private Double latitude;
    private Double longitude;
    private Pageable pageable = PageRequest.of(0, 20);
}
