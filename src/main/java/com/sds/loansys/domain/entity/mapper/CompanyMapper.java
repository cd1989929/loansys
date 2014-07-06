package com.sds.loansys.domain.entity.mapper;

import java.util.List;

import com.sds.loansys.domain.entity.Company;

public interface CompanyMapper {
    List<Company> findAll(Company company);

    Company findComnaybyid(Long id);

    Company insertCompany(Company company);

    Long deleteComnaybyid(Long id);

    List<Company> searchcompanybydim(String dim_search_value);

}
