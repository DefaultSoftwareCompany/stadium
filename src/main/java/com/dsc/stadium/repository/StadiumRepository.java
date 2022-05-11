package com.dsc.stadium.repository;

import com.dsc.stadium.domain.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
    void deleteAllByOwner_Id(Integer ownerId);
}
