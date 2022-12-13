package com.grokonez.jwtauthentication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.UserRepository;
@Service
public class AdministracionUsuarios implements IAdministracionUsuarios{

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getUsuariosAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public  User createUsuario(User usuarioEntity) {
		return userRepository.save(usuarioEntity);		
	}

	@Override
	public boolean existsByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.existsByUsername(username);
	}

	@Override
	public void deleteByUsername(String username) {
		// TODO Auto-generated method stub
		userRepository.deleteByUsername(username);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	

	
	
	
}
