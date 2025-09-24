package com.faik.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.faik.Entites.Home;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long>{

}
