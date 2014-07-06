package com.sds.loansys.domain.entity;

import java.sql.Timestamp;

/**
 * 单位信息变更表
 * @author chend
 *
 */
public class Companychange extends Company {

    private Long l_companyid;

    private Timestamp t_updatetime;

    private String s_updateuser;

    private String s_version;

    public Long getL_companyid() {
        return l_companyid;
    }

    public void setL_companyid(Long l_companyid) {
        this.l_companyid = l_companyid;
    }

    public Timestamp getT_updatetime() {
        return t_updatetime;
    }

    public void setT_updatetime(Timestamp t_updatetime) {
        this.t_updatetime = t_updatetime;
    }

    public String getS_updateuser() {
        return s_updateuser;
    }

    public void setS_updateuser(String s_updateuser) {
        this.s_updateuser = s_updateuser;
    }

    public String getS_version() {
        return s_version;
    }

    public void setS_version(String s_version) {
        this.s_version = s_version;
    }
    /*Name  Code    Data Type   Length  Precision   Mandatory   Primary Identifier  Displayed   Domain
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
    创建人 createuser  Integer         FALSE   FALSE   TRUE    <None>
    修改时间    updatetime  Date            FALSE   FALSE   TRUE    <None>
    修改人 updateuser  Integer         FALSE   FALSE   TRUE    <None>
    版本号 version Varchar(20) 20      FALSE   FALSE   TRUE    <None>*/
}
