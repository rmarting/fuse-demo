package org.fuse.usecase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.redhat.fuse.demo.model.Account;
import com.redhat.fuse.demo.model.Company;
import com.redhat.fuse.demo.model.Contact;

public class CxfRestClient {

	@Test
	public void callRS() throws IOException {
        Account account = new Account();

        Company company = new Company();
        company.setName("Rotobots");
        company.setGeo("NA");
        company.setActive(true);

        Contact contact = new Contact();
        contact.setFirstName("Bill");
        contact.setLastName("Smith");
        contact.setStreetAddr("100 N Park Ave.");
        contact.setCity("Phoenix");
        contact.setState("AZ");
        contact.setZip("85017");
        contact.setPhone("602-555-1100");

        account.setCompany(company);
        account.setContact(contact);

        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target("http://localhost:9191/rs/customerservice/enrich");

        Account a = target.request(MediaType.APPLICATION_JSON).post(Entity.json(account), Account.class);
        
        assertNotNull("There is a response", a);
        assertEquals("It is from NA", "NORTH_AMERICA", a.getCompany().getGeo());
    }
    

}
