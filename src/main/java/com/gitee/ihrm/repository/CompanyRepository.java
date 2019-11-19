package com.gitee.ihrm.repository;

import com.gitee.ihrm.bean.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jianghao
 * @date 2019/10/23 16:52
 */
public interface CompanyRepository extends JpaRepository<Company, Long>, JpaSpecificationExecutor<Company> {
}
