package com.gitee.ihrm.service;

import com.gitee.ihrm.bean.Company;
import com.gitee.ihrm.repository.CompanyRepository;
import com.gitee.ihrm.utils.IdWorker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jianghao
 * @date 2019/10/23 17:07
 */
@Service
public class CompanyService {

    @Resource
    private CompanyRepository companyRepository;

    @Resource
    private IdWorker idWorker;

    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    /**
     * 保存企业
     * 1.配置idwork到工程
     * 2.在service中注入idwork
     * 3.通过idwork生成id
     * 4.保存企业
     */
    public void save(Company company) {
        company.setId(idWorker.nextId());
        // 默认的状态
        //0：未审核，1：已审核
        company.setAuditState("0");
        //0.未激活，1：已激活
        company.setState(1);
        companyRepository.save(company);
    }

    /**
     * 根据id查询企业
     */
    public Company findById(Long id) {
        return companyRepository.findById(id).get();
    }

    /**
     * 删除企业
     */
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    /**
     * 更新企业
     * 1.参数：Company
     * 2.根据id查询企业对象
     * 3.设置修改的属性
     * 4.调用dao完成更新
     */
    public void update(Company company) {
        Company company1 = companyRepository.findById(company.getId()).get();
        company1.setName(company.getName());
        company1.setCompanyPhone(company.getCompanyPhone());
        companyRepository.save(company1);
    }

    /**
     * 条件查询+分页
     *
     * @param whereMap 查询条件
     * @param page     page
     * @param size     size
     * @return page
     */
    public Page<Company> findSearch(Map<String,Object> whereMap, int page, int size) {
        Specification<Company> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return companyRepository.findAll(specification, pageRequest);
    }

    /**
     * 动态条件构建
     *
     * @param searchMap 查询条件
     * @return specification
     */
    private Specification<Company> createSpecification(Map<String,Object> searchMap) {

        return (Specification<Company>) (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            // 公司名称
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                predicateList.add(cb.like(root.get("name").as(String.class), "%" + searchMap.get("name") + "%"));
            }
            // 企业登录账号ID
            if (searchMap.get("managerId") != null && !"".equals(searchMap.get("managerId"))) {
                predicateList.add(cb.like(root.get("managerId").as(String.class), "%" + searchMap.get("managerId") + "%"));
            }
            // 当前版本
            if (searchMap.get("version") != null && !"".equals(searchMap.get("version"))) {
                predicateList.add(cb.like(root.get("version").as(String.class), "%" + searchMap.get("version") + "%"));
            }
            // 公司地区
            if (searchMap.get("companyArea") != null && !"".equals(searchMap.get("companyArea"))) {
                predicateList.add(cb.like(root.get("companyArea").as(String.class), "%" + searchMap.get("companyArea") + "%"));
            }
            // 公司地址
            if (searchMap.get("companyAddress") != null && !"".equals(searchMap.get("companyAddress"))) {
                predicateList.add(cb.like(root.get("companyAddress").as(String.class), "%" + searchMap.get("companyAddress") + "%"));
            }
            // 营业执照-图片ID
            if (searchMap.get("businessLicenseId") != null && !"".equals(searchMap.get("businessLicenseId"))) {
                predicateList.add(cb.like(root.get("businessLicenseId").as(String.class), "%" + searchMap.get("businessLicenseId") + "%"));
            }
            // 法人代表
            if (searchMap.get("legalRepresentative") != null && !"".equals(searchMap.get("legalRepresentative"))) {
                predicateList.add(cb.like(root.get("legalRepresentative").as(String.class), "%" + searchMap.get("legalRepresentative") + "%"));
            }
            // 公司电话
            if (searchMap.get("companyPhone") != null && !"".equals(searchMap.get("companyPhone"))) {
                predicateList.add(cb.like(root.get("companyPhone").as(String.class), "%" + searchMap.get("companyPhone") + "%"));
            }
            // 邮箱
            if (searchMap.get("mailbox") != null && !"".equals(searchMap.get("mailbox"))) {
                predicateList.add(cb.like(root.get("mailbox").as(String.class), "%" + searchMap.get("mailbox") + "%"));
            }
            // 公司规模
            if (searchMap.get("companySize") != null && !"".equals(searchMap.get("companySize"))) {
                predicateList.add(cb.like(root.get("companySize").as(String.class), "%" + searchMap.get("companySize") + "%"));
            }
            // 所属行业
            if (searchMap.get("industry") != null && !"".equals(searchMap.get("industry"))) {
                predicateList.add(cb.like(root.get("industry").as(String.class), "%" + searchMap.get("industry") + "%"));
            }
            // 备注
            if (searchMap.get("remarks") != null && !"".equals(searchMap.get("remarks"))) {
                predicateList.add(cb.like(root.get("remarks").as(String.class), "%" + searchMap.get("remarks") + "%"));
            }
            // 审核状态
            if (searchMap.get("auditState") != null && !"".equals(searchMap.get("auditState"))) {
                predicateList.add(cb.like(root.get("auditState").as(String.class), "%" + searchMap.get("auditState") + "%"));
            }
            return cb.and(predicateList.toArray(new Predicate[0]));
        };
    }
}
