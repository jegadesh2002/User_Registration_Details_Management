package com.example.UserRegistreationform;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository repo;

	public List<User> listAll() {
		return repo.findAll();
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	public User get(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}
	public void delete(int id)
	{
		repo.deleteById(id);
	}
}
