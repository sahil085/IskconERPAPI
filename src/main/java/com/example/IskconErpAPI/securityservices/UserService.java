package com.example.IskconErpAPI.securityservices;


import com.example.IskconErpAPI.domain.User;
import com.example.IskconErpAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author kamal berriga
 *
 */
@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String userName) {
		return userRepository.findByEmail(userName);
	}

	public User find(Long id) {
		return userRepository.getOne(id);
	}
}
