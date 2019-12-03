package com.gitee.ihrm.controller;

import com.gitee.ihrm.bean.Company;
import com.gitee.ihrm.entity.Result;
import com.gitee.ihrm.entity.ResultCode;
import com.gitee.ihrm.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jianghao
 * @date 2019/10/23 17:10
 */
@CrossOrigin
@RestController
@RequestMapping(value = "company")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @GetMapping
    public Result findAll() {
        List<Company> all = companyService.findAll();
        return new Result(true, ResultCode.SUCCESS.getCode(), "", all);
    }

    @GetMapping(value = "{id}")
    public Result findById(@PathVariable Long id) {
        Company byId = companyService.findById(id);
        return new Result(true, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), byId);
    }

    @PostMapping
    public Result save(@RequestBody Company company) {
        companyService.save(company);
        return new Result(true, ResultCode.SAVE_SUCCESS.getCode(), ResultCode.SAVE_SUCCESS.getMessage());
    }

    @PutMapping(value = "{id}")
    public Result update(@PathVariable Long id, @RequestBody Company company) {
        company.setId(id);
        companyService.update(company);
        return new Result(true, ResultCode.UPDATE_SUCCESS.getCode(), ResultCode.UPDATE_SUCCESS.getMessage());
    }

    @DeleteMapping(value = "{id}")
    public Result delete(@PathVariable Long id) {
        companyService.deleteById(id);
        return new Result(true, ResultCode.DELETE_SUCCESS.getCode(), ResultCode.DELETE_SUCCESS.getMessage());
    }

    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map<String,Object> searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Company> pageList = companyService.findSearch(searchMap, page, size);
        return new Result(true, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), pageList);
    }

}
