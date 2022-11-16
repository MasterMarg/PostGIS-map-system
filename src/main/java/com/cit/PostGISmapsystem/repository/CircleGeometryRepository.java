package com.cit.PostGISmapsystem.repository;

import com.cit.PostGISmapsystem.model.CircleGeometry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CircleGeometryRepository extends JpaRepository<CircleGeometry, Integer> {
}
