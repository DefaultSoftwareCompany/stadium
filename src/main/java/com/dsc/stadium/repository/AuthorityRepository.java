package com.dsc.stadium.repository;

import com.dsc.stadium.domain.Authority;
import com.dsc.stadium.utils.AuthorityConstants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, AuthorityConstants> {
}