package br.com.soap.webservices;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class UserWebservice {
	
	@WebMethod(operationName="insert")
	public void insert(String text) {
		System.out.println(text);
	}

}
