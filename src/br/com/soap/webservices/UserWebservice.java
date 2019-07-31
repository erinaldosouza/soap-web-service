package br.com.soap.webservices;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.soap.model.User;

@Stateless
@WebService
@SOAPBinding(style = Style.RPC)
public interface UserWebservice {
	
	@WebMethod(operationName="create")
	public void create(User user);
	
	@WebMethod(operationName="read")
	public User read(Long id);
	
	@WebMethod(operationName="update")
	public void update(Long id, User user);
	
	@WebMethod(operationName="delete")
	public void delete(Long id);

}
