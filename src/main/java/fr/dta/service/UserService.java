package fr.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dta.modele.User;
import fr.dta.repository.UserRepository;

@Service
public class UserService {

	@Autowired 
	UserRepository userRepository;

	public void create(User resource) {
		userRepository.save(resource);
	}
	
	public void update(Long id, User resource) {
		userRepository.save(resource);
	}

	public void delete(Long id, User resource) {
		userRepository.delete(resource);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOneByLogin(String login) {
        return userRepository.findOneByLogin( login );
    }

    public User findById(long l) {
        return userRepository.findById( l );
    }
	
}
