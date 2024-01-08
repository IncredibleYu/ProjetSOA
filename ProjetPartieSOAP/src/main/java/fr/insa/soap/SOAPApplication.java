package fr.insa.soap;

import java.net.MalformedURLException;

import javax.xml.ws.Endpoint;

public class SOAPApplication {
	public void demarrerService() {
		String url1 = "http://localhost:2222/";
		String url2 = "http://localhost:2223/";
		Endpoint.publish(url1, new GestionPers());
		Endpoint.publish(url2, new GestionMiss());
	}
	public static void main(String [] args) throws MalformedURLException{
		new SOAPApplication().demarrerService();
		System.out.println("Service a d¨¦marr¨¦");
	}
}
