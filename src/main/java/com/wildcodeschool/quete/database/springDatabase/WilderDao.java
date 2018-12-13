package com.wildcodeschool.quete.database.springDatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WilderDao extends JpaRepository<Wilder, Long> {
}
