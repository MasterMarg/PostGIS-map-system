package com.cit.PostGISmapsystem.service;

import com.cit.PostGISmapsystem.dto.DtoFeatureInfo;

import java.util.List;

public interface FeatureInfoService {

    String save(DtoFeatureInfo featureInfo);

    List loadFeatures();

    String update(DtoFeatureInfo featureInfo);

    String delete(DtoFeatureInfo featureInfo);
}
