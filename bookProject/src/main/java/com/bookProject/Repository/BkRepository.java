package com.bookProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookProject.Entity.Bk;

@Repository
public interface BkRepository extends JpaRepository<Bk, Long>{
	 List<Bk> findByBtitlContainingIgnoreCase(String btitl);
}
