package com.redhat.fuse.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "model.demo.fuse.redhat.com")
public class Company {

    private String name;
    private String geo;
    private boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

	@Override
	public String toString() {
		return "Company [name=" + name + ", geo=" + geo + ", active=" + active
				+ "]";
	}
    
    
}
