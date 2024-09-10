package com.lastWeb.디비;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lastWeb.Entity.방명록;

@Repository
public interface Repo방명록 extends JpaRepository<방명록, Long>{

}
