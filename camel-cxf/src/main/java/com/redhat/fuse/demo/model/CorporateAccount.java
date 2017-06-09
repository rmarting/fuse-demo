package com.redhat.fuse.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "model.demo.fuse.redhat.com")
public class CorporateAccount {

    private Company company;
    private Contact contact;
    private int id;
    private String salesContact;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesContact() {
        return salesContact;
    }

    public void setSalesContact(String salesContact) {
        this.salesContact = salesContact;
    }

	@Override
	public String toString() {
		return "CorporateAccount [company=" + company + ", contact=" + contact
				+ ", id=" + id + ", salesContact=" + salesContact + "]";
	}
    
    

}
