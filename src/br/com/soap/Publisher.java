package br.com.soap;

import org.apache.juddi.api_v3.AccessPointType;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BindingTemplates;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.Name;

public class Publisher {
	private static UDDIClerk clerk = null;

	/**
	 * This function shows you how to publish to UDDI using a fairly generic
	 * mechanism that should be portable (meaning use any UDDI v3 library with this
	 * code)
	 */
	public void publish() {
		try {
			
			// Creating the parent business entity that will contain our service.
			BusinessEntity myBusEntity = new BusinessEntity();
			Name myBusName = new Name();
			
			myBusName.setValue("My Business");
			myBusEntity.getName().add(myBusName);
			// myBusEntity.setBusinessKey("my-business-key");

			// Adding the business entity to the "save" structure, using our publisher's
			// authentication info and saving away.
			BusinessEntity register = clerk.register(myBusEntity);
			
			if (register == null) {
				System.out.println("Save failed!");
				System.exit(1);
			}
			
			String myBusKey = register.getBusinessKey();
			System.out.println("myBusiness key:  " + myBusKey);

			// Creating a service to save. Only adding the minimum data: the parent business
			// key retrieved from saving the business
			// above and a single name.
			BusinessService myService = new BusinessService();
			myService.setBusinessKey(myBusKey);
			
			Name myServName = new Name();
			myServName.setValue("My Service");
			myService.getName().add(myServName);
			// myService.setServiceKey("my-service-key");


			// Add binding templates, etc...
			BindingTemplate myBindingTemplate = new BindingTemplate();
			AccessPoint accessPoint = new AccessPoint();
			
			accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
			accessPoint.setValue("http://localhost:8080/juddiv3/services/publish?wsdl");
			
			myBindingTemplate.setAccessPoint(accessPoint);
			BindingTemplates myBindingTemplates = new BindingTemplates();
			
			// optional but recommended step, this annotations our binding with all the
			// standard SOAP tModel instance infos
			myBindingTemplate = UDDIClient.addSOAPtModels(myBindingTemplate);
			myBindingTemplates.getBindingTemplate().add(myBindingTemplate);
			myService.setBindingTemplates(myBindingTemplates);
			
			// Adding the service to the "save" structure, using our publisher's
			// authentication info and saving away.
			BusinessService svc = clerk.register(myService);

			if (svc == null) {
				System.out.println("Save failed!");
				System.exit(1);
			}

			String myServKey = svc.getServiceKey();
			System.out.println("myService key:  " + myServKey);

			clerk.discardAuthToken();
			
			// Now you have a business and service via
			// the jUDDI API!
			System.out.println("Success!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) throws Exception {
		
		// create a client and read the config in the archive;
//		// you can use your config file name
		UDDIClient uddiClient = new UDDIClient("META-INF/uddi.xml");

		// get the clerk
		clerk = uddiClient.getClerk("clerk-1");
		if (clerk == null)
			throw new Exception("the clerk wasn't found, check the config file!");

		new Publisher().publish();
	}
}
