package com.cit.PostGISmapsystem.service;

import com.cit.PostGISmapsystem.model.CircleGeometry;

import java.util.List;

public interface CircleGeometryService {

    CircleGeometry saveCircle(CircleGeometry circleGeometry);

    List<CircleGeometry> loadCircles();

    String update(CircleGeometry circleGeometry);

    String delete(CircleGeometry circleGeometry);
}
