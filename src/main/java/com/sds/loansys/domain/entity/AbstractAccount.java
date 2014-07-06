package com.sds.loansys.domain.entity;

import java.sql.Timestamp;

/**
 * 单位信息表
 * @author chend
 *
 */
public abstract class AbstractAccount {

    public static final String COL_no = "NO";

    public static final String COL_companyname = "companyname";

    public static final String COL_principalname = "principalname";

    public static final String COL_mobile = "mobile";

    public static final String COL_address = "address";

    public static final String COL_remark = "remark";

    public static final String COL_createuser = "createuser";

    private Long id = 0L;

    private String s_NO;

    private Long l_companyid = 0L;

    private String s_accountname;

    private Double d_money;

    private Integer i_moneytype;

    private Timestamp t_savetime;

    private Timestamp t_tacktime;

    private Timestamp t_interesttime;

    private Double d_interest;

    private Integer i_payflag;

    private Integer i_isbankbook;

    private String s_bankno;

    private String s_idno;

    private String s_mobile;

    private String s_address;

    private String s_remark;

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

    public Long getL_companyid() {
        return l_companyid;
    }

    public void setL_companyid(Long l_companyid) {
        this.l_companyid = l_companyid;
    }

    public String getS_accountname() {
        return s_accountname;
    }

    public void setS_accountname(String s_accountname) {
        this.s_accountname = s_accountname;
    }

    public Double getD_money() {
        return d_money;
    }

    public void setD_money(Double d_money) {
        this.d_money = d_money;
    }

    public Integer getI_moneytype() {
        return i_moneytype;
    }

    public void setI_moneytype(Integer i_moneytype) {
        this.i_moneytype = i_moneytype;
    }

    public Timestamp getT_savetime() {
        return t_savetime;
    }

    public void setT_savetime(Timestamp t_savetime) {
        this.t_savetime = t_savetime;
    }

    public Timestamp getT_tacktime() {
        return t_tacktime;
    }

    public void setT_tacktime(Timestamp t_tacktime) {
        this.t_tacktime = t_tacktime;
    }

    public Timestamp getT_interesttime() {
        return t_interesttime;
    }

    public void setT_interesttime(Timestamp t_interesttime) {
        this.t_interesttime = t_interesttime;
    }

    public Double getD_interest() {
        return d_interest;
    }

    public void setD_interest(Double d_interest) {
        this.d_interest = d_interest;
    }

    public Integer getI_payflag() {
        return i_payflag;
    }

    public void setI_payflag(Integer i_payflag) {
        this.i_payflag = i_payflag;
    }

    public Integer getI_isbankbook() {
        return i_isbankbook;
    }

    public void setI_isbankbook(Integer i_isbankbook) {
        this.i_isbankbook = i_isbankbook;
    }

    public String getS_bankno() {
        return s_bankno;
    }

    public void setS_bankno(String s_bankno) {
        this.s_bankno = s_bankno;
    }

    public String getS_idno() {
        return s_idno;
    }

    public void setS_idno(String s_idno) {
        this.s_idno = s_idno;
    }

}
