package com.bookProject.Repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookProject.Entity.Bk;

@Repository
public interface BkRepository extends JpaRepository<Bk, Long>{
	@Query("select b from Bk b where (:btitl is null or lower(b.btitl) like lower(concat('%', :btitl, '%'))) and (:bwrit is null or lower(b.bwrit) like lower(concat('%', :bwrit, '%'))) and (:bpubl is null or lower(b.bpubl) like lower(concat('%', :bpubl, '%'))) and (:bsort is null or lower(b.bsort) like lower(concat('%', :bsort, '%')))")
	List<Bk> findByMultipleCriteria(@Param("btitl") String btitl, @Param("bwrit") String bwrit, @Param("bpubl") String bpubl, @Param("bsort") String bsort);
}
