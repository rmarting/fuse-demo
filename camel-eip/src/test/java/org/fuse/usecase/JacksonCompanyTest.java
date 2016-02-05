package org.fuse.usecase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.globex.Account;
import org.globex.Company;
import org.globex.Contact;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonCompanyTest {

	@Test
	public void testAccountToJson() throws IOException {
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

		String result = new ObjectMapper().writeValueAsString(account);
		
		assertThat("There is a company", result, CoreMatchers.containsString("company"));
		assertThat("There is a contact", result, CoreMatchers.containsString("contact"));
	}

	@Test
	public void testJSonToAccount() throws IOException {
		String json = "{\"company\":{\"name\":\"Rotobots\",\"geo\":\"NA\",\"active\":true},\"contact\":{\"firstName\":\"Bill\",\"lastName\":\"Smith\",\"streetAddr\":\"100 N Park Ave.\",\"city\":\"Phoenix\",\"state\":\"AZ\",\"zip\":\"85017\",\"phone\":\"602-555-1100\"}}";
		Account account = new ObjectMapper().readValue(json, Account.class);
		assertNotNull("There is an account", account);
		assertEquals("Rotobots company", "Rotobots", account.getCompany().getName());
	}

}
