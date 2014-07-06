package com.sds.loansys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.loansys.domain.entity.Company;
import com.sds.loansys.domain.entity.mapper.CompanyMapper;

@Service
public class CompanyService {

    @Autowired
    CompanyMapper companyMapper;

    public List<Company> findAll(Company company) {
        return companyMapper.findAll(company);
    }

    public Company findComnaybyid(Long id) {
        return companyMapper.findComnaybyid(id);
    }

    public Company insertCompany(Company company) {
        return companyMapper.insertCompany(company);
    }

    public Long deleteComnaybyid(Long id) {
        return companyMapper.deleteComnaybyid(id);
    }

    public List<Company> searchcompanybydim(String dim_search_value) {
        return companyMapper.searchcompanybydim(dim_search_value);
    }
}
