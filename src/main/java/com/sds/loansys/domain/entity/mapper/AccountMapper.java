package com.sds.loansys.domain.entity.mapper;

import java.util.List;

import com.sds.loansys.domain.entity.Account;

public interface AccountMapper {
    List<Account> findAll(Account Account);

    Account findComnaybyid(Long id);

    Account insertAccount(Account Account);

    Long deleteComnaybyid(Long id);

    List<Account> searchAccountbydim(String dim_search_value);

}
