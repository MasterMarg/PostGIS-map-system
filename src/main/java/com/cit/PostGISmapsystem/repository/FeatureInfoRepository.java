package com.cit.PostGISmapsystem.repository;

import com.cit.PostGISmapsystem.model.FeatureInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeatureInfoRepository extends JpaRepository<FeatureInfo, Integer> {
}
