package com.cit.PostGISmapsystem.service;

import com.cit.PostGISmapsystem.dto.DtoFeatureInfo;
import com.cit.PostGISmapsystem.model.FeatureInfo;
import com.cit.PostGISmapsystem.repository.FeatureInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;

@Service
public class FeatureInfoImpl implements FeatureInfoService {

    @Autowired
    private FeatureInfoRepository repository;
    @Autowired
    private EntityManager manager;


    @Override
    public String save(DtoFeatureInfo featureInfo) {
        int newId = 1;
        FeatureInfo info = repository.findAll().stream().max(Comparator.comparing(FeatureInfo::getId)).orElse(null);
        if (info != null) {
            newId = newId + info.getId();
        }
        manager.createNativeQuery("INSERT into feature_info (ID, NAME, DESCRIPTION, GEOMETRY) VALUES (:id, :name, :description, ST_GeomFromEWKT(:geometry))")
                .setParameter("id", newId)
                .setParameter("description", featureInfo.getDescription())
                .setParameter("name", featureInfo.getName())
                .setParameter("geometry", featureInfo.getGeometry())
                .executeUpdate();
        return "New feature info has been added";
    }

    @Override
    public List loadFeatures() {
        return manager.createNativeQuery("select e.id, e.name, e.description, ST_AsEWKT(e.geometry) from feature_info e").getResultList();
    }

    @Override
    public String update(DtoFeatureInfo featureInfo) {
        if (repository.existsById(featureInfo.getId())) {
            manager.createNativeQuery("UPDATE feature_info SET NAME=:name, DESCRIPTION=:description, GEOMETRY=ST_GeomFromEWKT(:geometry) WHERE ID=:id")
                    .setParameter("name", featureInfo.getName())
                    .setParameter("description", featureInfo.getDescription())
                    .setParameter("geometry", featureInfo.getGeometry())
                    .setParameter("id", featureInfo.getId())
                    .executeUpdate();
            return "Feature info has been updated";
        }
        return "There is no feature with provided ID";
    }
}
