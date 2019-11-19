package com.gitee.ihrm.controller;

import com.gitee.ihrm.bean.Company;
import com.gitee.ihrm.entity.Result;
import com.gitee.ihrm.entity.ResultCode;
import com.gitee.ihrm.service.CompanyService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jianghao
 * @date 2019/10/23 17:10
 */
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

    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @RequestMapping(value = "search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Company> pageList = companyService.findSearch(searchMap, page, size);
        return new Result(true, ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), pageList);
    }

}
