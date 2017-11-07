package com.onik.service;

import com.onik.entity.Outlet;
import com.onik.repository.OutletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by onik on 1/7/17.
 */
@Service
public class OutletService {
    @Autowired
    private OutletRepository outletRepository;

    public Collection<Outlet> findAll() {
    	Collection<Outlet> outletCollection = outletRepository.findAll();
    	Collection<Outlet> responseCollection = new ArrayList<>();
    	
    	for(Outlet outlet : outletCollection) {
    		if(outlet.isDeleted() == false) {
    			responseCollection.add(outlet);
    		}
    	}
    	
        return responseCollection;
    }

    public Outlet findOne(long OUTLET_ID) {
        return outletRepository.findOne(OUTLET_ID);
    }

    public Outlet save(Outlet outlet) {
    	if(outlet == null ||
    		outlet.getOUTLET_ID() == null ||
    		outlet.getOUTLET_ID() < 0 ||
    		outlet.getOUTLET_NAME() == null ||
    		outlet.getOUTLET_NAME().length() == 0) {
    		
    		return outlet;
    	}
    	
        try {
            outletRepository.save(outlet);

            return outlet;
        } catch (Exception ex) {
            outlet = new Outlet();
            return outlet;
        }
    }

    public boolean deletOutlet(long OUTLET_ID) {
        try {
            Outlet outlet = outletRepository.findOne(OUTLET_ID);

            if (outlet == null) {
                return false;
            } else {
                outlet.setDeleted(true);
                outletRepository.save(outlet);
            }

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
