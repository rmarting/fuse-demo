package com.redhat.fuse.demo.service.ws;

import javax.jws.WebService;

import com.redhat.fuse.demo.model.Account;
import com.redhat.fuse.demo.model.CorporateAccount;

@WebService
public interface CustomerWS {

    CorporateAccount updateAccount(Account account);

}
