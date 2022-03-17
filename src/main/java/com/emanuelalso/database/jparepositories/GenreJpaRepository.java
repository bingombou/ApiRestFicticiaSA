package com.emanuelalso.database.jparepositories;

import com.emanuelalso.database.entities.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreJpaRepository extends JpaRepository<GenreEntity, Long> {
}
