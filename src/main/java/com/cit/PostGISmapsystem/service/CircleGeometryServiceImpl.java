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
    public String update(CircleGeometry circleGeometry) {
        if (circleGeometry == null) {
            return "Request body is empty";
        }
        CircleGeometry geometry = repository.findById(circleGeometry.getId()).orElse(null);
        if (geometry == null) {
            return "Circle with given ID does not exist";
        }
        geometry.setName(circleGeometry.getName());
        geometry.setDescription(circleGeometry.getDescription());
        geometry.setCenter(circleGeometry.getCenter());
        geometry.setRadius(circleGeometry.getRadius());
        repository.save(geometry);
        return "Circle has been updated";
    }

    @Override
    public String delete(CircleGeometry circleGeometry) {
        if (circleGeometry == null) {
            return "Request body is empty";
        }
        if (!repository.existsById(circleGeometry.getId())) {
            return "Circle with given ID does not exist";
        }
        repository.deleteById(circleGeometry.getId());
        return "Circle has been removed";
    }
}
