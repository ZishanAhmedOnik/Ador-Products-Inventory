package com.onik.controller;

import com.onik.entity.Outlet;
import com.onik.service.OutletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by onik on 1/7/17.
 */
@RestController
@CrossOrigin
@RequestMapping("/outlet")
public class OutletController {
    @Autowired
    private OutletService outletService;

    @GetMapping("/")
    public Collection<Outlet> get() {
        return outletService.findAll();
    }

    @GetMapping("/{OUTLET_ID}")
    public Outlet get(@PathVariable("OUTLET_ID") long OUTLET_ID) {
        return outletService.findOne(OUTLET_ID);
    }

    @PostMapping("/save")
    public Outlet save(@RequestBody Outlet outlet) {
        return outletService.save(outlet);
    }

    @DeleteMapping("/delete/{OUTLET_ID}")
    public boolean delete(@PathVariable("OUTLET_ID") long OUTLET_ID) {
        return outletService.deletOutlet(OUTLET_ID);
    }
}
