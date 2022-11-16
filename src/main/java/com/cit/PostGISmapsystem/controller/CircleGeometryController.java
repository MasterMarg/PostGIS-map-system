package com.cit.PostGISmapsystem.controller;

import com.cit.PostGISmapsystem.model.CircleGeometry;
import com.cit.PostGISmapsystem.service.CircleGeometryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/circle")
@CrossOrigin
public class CircleGeometryController {
    @Autowired
    private CircleGeometryService circleService;

    @PostMapping("/add")
    public String add(@RequestBody CircleGeometry circle) {
        circleService.saveCircle(circle);
        return "New circle has been added";
    }

    @GetMapping("/getAll")
    public List<CircleGeometry> get() {
        return circleService.loadCircles();
    }

    @PutMapping("/update")
    public String update(@RequestBody CircleGeometry circle) {
        circleService.update(circle);
        return "Circle has been updated";
    }
}
