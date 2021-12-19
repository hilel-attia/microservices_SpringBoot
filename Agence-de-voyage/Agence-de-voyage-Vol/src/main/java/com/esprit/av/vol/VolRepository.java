package com.esprit.av.vol;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VolRepository extends JpaRepository<Vol, Integer> {
	
	@Query("select c from Vol c where c.id_vol like :id_vol")
	public Page<Vol> volById(@Param("id_vol") String n, Pageable pageable);

}