package com.sds.loansys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.loansys.domain.entity.Account;
import com.sds.loansys.domain.entity.mapper.AccountMapper;

@Service
public class AccountService {

    @Autowired
    AccountMapper AccountMapper;

    public List<Account> findAll(Account Account) {
        return AccountMapper.findAll(Account);
    }

    public Account findComnaybyid(Long id) {
        return AccountMapper.findComnaybyid(id);
    }

    public Account insertAccount(Account Account) {
        return AccountMapper.insertAccount(Account);
    }

    public Long deleteComnaybyid(Long id) {
        return AccountMapper.deleteComnaybyid(id);
    }

    public List<Account> searchAccountbydim(String dim_search_value) {
        return AccountMapper.searchAccountbydim(dim_search_value);
    }
}
