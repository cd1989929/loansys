package com.sds.loansys.domain.entity;

import java.sql.Timestamp;

/**
 * 单位信息表
 * @author chend
 *
 */
public abstract class AbstractCompany {

    public static final String COL_no = "NO";

    public static final String COL_companyname = "companyname";

    public static final String COL_principalname = "principalname";

    public static final String COL_mobile = "mobile";

    public static final String COL_address = "address";

    public static final String COL_remark = "remark";

    public static final String COL_createuser = "createuser";

    private Long id = 0L;

    private String s_NO;

    private String s_companyname;

    private String s_principalname;

    private Double d_totalmoney;

    private String s_mobile;

    private String s_address;

    private String s_remark;

    private Integer i_gongzibanjihuashu;

    private Integer i_qiyejihuashu;

    private Timestamp t_createtime;

    private String s_createuser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getS_NO() {
        return s_NO;
    }

    public void setS_NO(String s_NO) {
        this.s_NO = s_NO;
    }

    public String getS_companyname() {
        return s_companyname;
    }

    public void setS_companyname(String s_companyname) {
        this.s_companyname = s_companyname;
    }

    public String getS_principalname() {
        return s_principalname;
    }

    public void setS_principalname(String s_principalname) {
        this.s_principalname = s_principalname;
    }

    public Double getD_totalmoney() {
        return d_totalmoney;
    }

    public void setD_totalmoney(Double d_totalmoney) {
        this.d_totalmoney = d_totalmoney;
    }

    public String getS_mobile() {
        return s_mobile;
    }

    public void setS_mobile(String s_mobile) {
        this.s_mobile = s_mobile;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_remark() {
        return s_remark;
    }

    public void setS_remark(String s_remark) {
        this.s_remark = s_remark;
    }

    public Integer getI_gongzibanjihuashu() {
        return i_gongzibanjihuashu;
    }

    public void setI_gongzibanjihuashu(Integer i_gongzibanjihuashu) {
        this.i_gongzibanjihuashu = i_gongzibanjihuashu;
    }

    public Integer getI_qiyejihuashu() {
        return i_qiyejihuashu;
    }

    public void setI_qiyejihuashu(Integer i_qiyejihuashu) {
        this.i_qiyejihuashu = i_qiyejihuashu;
    }

    public Timestamp getT_createtime() {
        return t_createtime;
    }

    public void setT_createtime(Timestamp t_createtime) {
        this.t_createtime = t_createtime;
    }

    public String getS_createuser() {
        return s_createuser;
    }

    public void setS_createuser(String s_createuser) {
        this.s_createuser = s_createuser;
    }

    /*Name    Code    Data Type   Length  Precision   Mandatory   Primary Identifier  Displayed   Domain
    ID  ID  Long binary         FALSE   FALSE   TRUE    <None>
    编号  NO  Varchar(20) 20      FALSE   FALSE   TRUE    <None>
    单位名称    companyname Varchar(100)    100     FALSE   FALSE   TRUE    <None>
    负责人 principalname   Varchar(5)  5       FALSE   FALSE   TRUE    <None>
    集资款数量   totalmoney  Decimal (18,2)  18  2   FALSE   FALSE   TRUE    <None>
    联系电话    mobile  Varchar(11) 11      FALSE   FALSE   TRUE    <None>
    地址  address Varchar(100)    100     FALSE   FALSE   TRUE    <None>
    备注  remark  Varchar(2000)   2000        FALSE   FALSE   TRUE    <None>
    公资办考核计划数    gongzibanjihuashu   Varchar(100)    100     FALSE   FALSE   TRUE    <None>
    企业计划数   qiyejihuashu    Characters (50) 50      FALSE   FALSE   TRUE    <None>
    创建时间    createtime  Date            FALSE   FALSE   TRUE    <None>
    创建人 createuser  Integer         FALSE   FALSE   TRUE    <None>*/

}
