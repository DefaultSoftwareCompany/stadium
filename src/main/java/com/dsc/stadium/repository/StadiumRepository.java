package com.dsc.stadium.repository;

import com.dsc.stadium.domain.Stadium;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer>, CustomStadiumRepository {
    Page<Stadium> findAllByNameContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrAddressContainingIgnoreCase(@Nullable String name, @Nullable String description, @Nullable String address, Pageable pageable);
}
