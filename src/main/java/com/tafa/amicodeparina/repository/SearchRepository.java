package com.tafa.amicodeparina.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tafa.amicodeparina.models.Search;

@Repository
public interface SearchRepository extends JpaRepository<Search, Long> {
    @Query("SELECT s FROM Search s WHERE s.user.id = ?1")
    List<Search> findByUserid(Long userid);
}