package com.redhat.fuse.demo.service.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import com.redhat.fuse.demo.model.Account;
import com.redhat.fuse.demo.model.CorporateAccount;

@WebService
@SOAPBinding(style = Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerWS {

	@WebMethod
	// @RequestWrapper(targetNamespace = "model.demo.fuse.redhat.com")
	// @ResponseWrapper(targetNamespace = "model.demo.fuse.redhat.com")
	// @WebResult(targetNamespace = "model.demo.fuse.redhat.com")
	CorporateAccount updateAccount(Account account);

}
