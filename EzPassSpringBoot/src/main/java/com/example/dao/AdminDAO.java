package com.example.dao;

import com.example.model.Account;
import com.example.model.Admin;
import com.example.model.EzTag;

public interface AdminDAO {
    public boolean login(Admin admin);
    public boolean VerifyCustomerInfo(Account account);
    public boolean checkCustomerTag(EzTag eztag);
}
