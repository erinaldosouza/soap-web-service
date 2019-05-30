package br.com.soap.webservices;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.soap.model.User;
import br.com.soap.services.IUserService;

@Stateless
@WebService(name="user-service")
public class UserWebservice {
	
	@Inject
	private IUserService userService;
	
	@WebMethod(operationName="create")
	public User create(User user) {
		userService.create(user);
		user.setId(5l);
		return user;
	}
	
	@WebMethod(operationName="read")
	public void read(Long id) {
		userService.read(id);
	}
	
	@WebMethod(operationName="readAll")
	public void readAll() {
		userService.readAll();
	}
	
	@WebMethod(operationName="update")
	public void update(Long id, User user) {
		userService.update(id, user);
	}	
	
	@WebMethod(operationName="delete")
	public void delete(Long id) {
		userService.delete(id);
	}

}
