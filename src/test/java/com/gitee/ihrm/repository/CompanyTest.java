package com.gitee.ihrm.repository;

import com.gitee.ihrm.IhrmApplicationTests;
import com.gitee.ihrm.bean.Company;
import com.gitee.ihrm.utils.IdWorker;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author jianghao
 * @date 2019/10/23 16:56
 */
class CompanyTest extends IhrmApplicationTests {

    @Resource
    private CompanyRepository companyRepository;

    @Resource
    private IdWorker idWorker;

    @Test
    void testFindAll() {
        List<Company> all = companyRepository.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void testSave() {
        Company company = new Company();
        company.setId(idWorker.nextId());
        company.setName("牛逼的公司");
        company.setManagerId("11111111111111");
        company.setState(1);
        company.setBalance(10000000.00);
        company.setCreateTime(new Date());
        companyRepository.save(company);
    }

    @Test
    void testDelete() {
        companyRepository.deleteById(1189058180810936320L);
    }

    @Test
    void testSaveForBuilder() {
        Company build = Company.builder().id(idWorker.nextId()).name("牛逼的公司").managerId("A1").state(1).balance(100000000.00).createTime(new Date()).build();
        companyRepository.save(build);
    }
}
