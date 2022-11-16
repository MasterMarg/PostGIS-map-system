package com.cit.PostGISmapsystem.controller;

import com.cit.PostGISmapsystem.dto.DtoFeatureInfo;
import com.cit.PostGISmapsystem.service.FeatureInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feature")
@CrossOrigin
public class FeatureInfoController {

    @Autowired
    private FeatureInfoService service;

    @Transactional
    @PostMapping("/add")
    public String add(@RequestBody DtoFeatureInfo info) {
        return service.save(info);
    }

    @GetMapping("/getAll")
    public List get() {
        return service.loadFeatures();
    }

    @Transactional
    @PutMapping("/update")
    public String update(@RequestBody DtoFeatureInfo info) {
        return service.update(info);
    }
}
