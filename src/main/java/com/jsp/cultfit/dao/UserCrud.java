package com.jsp.cultfit.dao;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.cultfit.entity.User;
import com.jsp.cultfit.repo.UserRepo;

@Repository
public class UserCrud {

	@Autowired
	UserRepo repo;

	public User save(User user) {
		return repo.save(user);
	}

	public User update(User user) {
		Optional<User> db = repo.findById(user.getId());
		if (db.isPresent()) {
			User obj = db.get();
			if (obj.getF_name() == null) {
				obj.setF_name(user.getF_name());
			}
			if (obj.getL_name() == null) {
				obj.setL_name(user.getL_name());
			}
			if (obj.getGender() == null) {
				obj.setGender(user.getGender());
			}
			if (obj.getPassword() == null) {
				obj.setPassword(user.getPassword());
			}
			if (obj.getDateofbirth() == null) {
				obj.setDateofbirth(user.getDateofbirth());
			}
			if (obj.getPhonenumber() == 0) {
				obj.setPhonenumber(user.getPhonenumber());
			}
			if (obj.getEmail() == null) {
				obj.setEmail(user.getEmail());
			}
			return repo.save(obj);
		} else {
			return null;
		}
	}

	public User delete(int id) {
		Optional<User> db = repo.findById(id);
		if (db.isPresent()) {
			User user = db.get();
			repo.delete(db.get());
			return user;
		} else {
			return null;
		}
	}

	public User fetch(int id) {
		Optional<User> db = repo.findById(id);
		if (db.isPresent()) {
			return db.get();
		} else {
			return null;
		}
	}

	public void fetchAll() {
		repo.findAll();
	}

}
