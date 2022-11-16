package com.cit.PostGISmapsystem.service;

import com.cit.PostGISmapsystem.model.CircleGeometry;
import com.cit.PostGISmapsystem.repository.CircleGeometryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CircleGeometryServiceImpl implements CircleGeometryService {

    @Autowired
    private CircleGeometryRepository repository;

    @Override
    public CircleGeometry saveCircle(CircleGeometry circleGeometry) {
        return repository.save(circleGeometry);
    }

    @Override
    public List<CircleGeometry> loadCircles() {
        return repository.findAll();
    }

    @Override
    public void update(CircleGeometry circleGeometry) {
        CircleGeometry geometry = repository.findById(circleGeometry.getId()).orElse(null);
        if (geometry != null) {
            geometry.setName(circleGeometry.getName());
            geometry.setDescription(circleGeometry.getDescription());
            geometry.setCenter(circleGeometry.getCenter());
            geometry.setRadius(circleGeometry.getRadius());
            repository.save(geometry);
        }
    }
}
