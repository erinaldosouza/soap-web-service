package br.com.soap.webservices.impl;
import javax.inject.Inject;
import javax.jws.WebService;

import br.com.soap.model.User;
import br.com.soap.services.IUserService;
import br.com.soap.webservices.UserWebservice;

@WebService(
		name = "user-service",
		serviceName = "user-service",
		endpointInterface = "br.com.soap.webservices.UserWebservice")
public class UserWebserviceImpl implements UserWebservice {
	
	@Inject
	private IUserService userService;
	
	@Override
	public User create(User user) {
		return userService.create(user);
	}
	
	@Override
	public void read(Long id) {
		userService.read(id);
	}
	
	@Override
	public void update(Long id, User user) {
		userService.update(id, user);
	}
	
	@Override
	public void delete(Long id) {
		userService.delete(id);
	}
}
