package com.emanuelalso.database.jparepositories;

import com.emanuelalso.database.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonJpaRepository extends JpaRepository <PersonEntity, Long>{
}
