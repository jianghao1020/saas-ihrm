package com.gitee.ihrm.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jianghao
 * @date 2019/10/23 10:16
 */
@Entity
@Table(name = "co_company")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company implements Serializable {

    private static final long serialVersionUID = 1854866517651902973L;

    /**
     * id
     */
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 公司名称
     */
    private String name;
    /**
     * 企业登录账号ID
     */
    private String managerId;
    /**
     * 当前版本
     */
    private String version;
    /**
     * 续期时间
     */
    private Date renewalDate;
    /**
     * 到期时间
     */
    private Date expirationDate;
    /**
     * 公司地区
     */
    private String companyArea;
    /**
     * 公司地址
     */
    private String companyAddress;
    /**
     * 营业执照-图片ID
     */
    private String businessLicenseId;
    /**
     * 法人代表
     */
    private String legalRepresentative;
    /**
     * 公司电话
     */
    private String companyPhone;
    /**
     * 邮箱
     */
    private String mailbox;
    /**
     * 公司规模
     */
    private String companySize;
    /**
     * 所属行业
     */
    private String industry;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 审核状态
     */
    private String auditState;
    /**
     * 状态
     */
    private Integer state;
    /**
     * 当前余额
     */
    private Double balance;
    /**
     * 创建时间
     */
    private Date createTime;
}
