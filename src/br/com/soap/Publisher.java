package br.com.soap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

import br.com.soap.webservices.impl.UserWebserviceImpl;

@WebListener
public class Publisher implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		Endpoint.publish("http://127.0.0.1:9876/user-service", new UserWebserviceImpl());		
	}
}
