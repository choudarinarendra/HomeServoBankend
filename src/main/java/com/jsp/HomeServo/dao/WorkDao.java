package com.jsp.HomeServo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HomeServo.dto.Work;
import com.jsp.HomeServo.repo.WorkRepo;
@Repository
public class WorkDao {
	@Autowired
	private WorkRepo repo;

	public Work saveWork(Work work) {
		return repo.save(work);
	}

	public Work getWorkById(int id) {
		if (repo.findById(id).isPresent()) {
			Work work = repo.findById(id).get();
			return work;
		}
		return null;
	}

	public List<Work> getAllByWork() {
		List<Work> list = repo.findAll();
		if (list != null) {
			return list;
		} else {
			return null;
		}
	}

	public Work updateWork(Work work) {
		if (repo.findById(work.getId()).isPresent()) {
			Work dataBase = repo.findById(work.getId()).get();
			if (work.getTypeOfWork() == null) {
				work.setTypeOfWork(dataBase.getTypeOfWork());
				
			}
			    return repo.save(work);
					}
		return null;
	}

}
