package com.jsp.HomeServo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Vendor;
import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.repo.VendorRepo;

@Repository
public class VendorDao {
	@Autowired
	private VendorRepo repo;
	@Autowired
	WorkDao workDao;

	public Vendor saveVendor(Vendor vendor) {
		return repo.save(vendor);
	}

	public Vendor updateVendor(Vendor vendor) {
		if (repo.findById(vendor.getId()).isPresent()) {
			Vendor dataBase = repo.findById(vendor.getId()).get();
			vendor.setCost(dataBase.getCost());
			if(vendor.getPassword()==null) {
				vendor.setPassword(dataBase.getPassword());
			}
			return repo.save(vendor);

		}else {
		return null;
		}
	}

	public Vendor getByIdVendor(int id) {
		if (repo.findById(id).isPresent()) {
			Vendor vendor = repo.findById(id).get();
			return vendor;
		} else {
			return null;
		}
	}

	public Vendor getByEmailVendor(String email) {
		return repo.findByEmail(email);
	}

	public Vendor deleteVendor(int id) {
		if(repo.findById(id).isPresent()) {
			Vendor v1=repo.findById(id).get();
			List<Work>list=workDao.getAllByWork();
		if(list!=null) {

				for(Work work:list) {
					Vendor ven=work.getVendor();
				if(ven !=null) {
					
						if(ven.getId()==id) {
							work.setVendor(null);
							workDao.updateWork(work);
						}
					
				}
		
			}
		}
		v1.setCost(null);
			repo.deleteById(id);
		return v1;
	}else {
			return null;
		}
		
		
	}

	public List<Vendor> getAllVendors() {
		return repo.findAll();
	}

}
