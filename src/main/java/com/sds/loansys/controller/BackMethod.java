package com.sds.loansys.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import com.sds.loansys.domain.entity.util.PageInfo;

public class BackMethod {

    static DecimalFormat df00 = new DecimalFormat("#.00");

    static SimpleDateFormat sdfyyyyMMddHHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    protected PageInfo pageinfo = new PageInfo();

    /**
     * 把科学计数法变为数字类型
     * @param money
     * @return
     */
    public static String parseDB2DOUBLE(String money) {
        if (money.indexOf('E') > 0) {
            money = df00.format(Double.parseDouble(money));
        }
        return money;
    }

    public String getPagination(String action) {
        StringBuffer sb = new StringBuffer();
        sb.append("共&nbsp;" + pageinfo.getTotalrow() + "&nbsp;条记录&nbsp;");
        if (pageinfo.getTotalrow() == 0) {
            return sb.toString();
        }
        sb.append("当前" + pageinfo.getPagenum() + "/" + pageinfo.getTotalpage() + "页&nbsp;");
        sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(1);'>首页</a>&nbsp;<span class=\"font_grey_001\">");
        if (pageinfo.hasFront()) {
            sb.append(" <a href='#' class=\"font_grey_001\" onclick='javascript:go(").append(pageinfo.getPagenum() - 1)
                    .append(");'>上一页</a>&nbsp;");
        }
        if (pageinfo.getTotalpage() == 1) {
            sb.append(" <strong>1</strong> ");
        }
        else {
            int pre = pageinfo.getPagenum() - 5; // 前页数
            int bac = pageinfo.getTotalpage() - pageinfo.getPagenum(); // 后页数
            if (pre >= 1 && bac >= 5) {
                for (int i = pageinfo.getPagenum() - 5; i < pageinfo.getPagenum() + 5; i++) {
                    if (i == pageinfo.getPagenum()) {
                        sb.append(" <strong>" + i + "</strong> ");
                    }
                    else {
                        sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(" + i + ");'>" + i
                                + "</a>");
                    }
                }
            }
            else if (pre <= 0) { // 前页数不够5页

                for (int i = 1; i <= 10 && i <= pageinfo.getTotalpage(); i++) {
                    if (i == pageinfo.getPagenum()) {
                        sb.append(" <strong>" + i + "</strong> ");
                    }
                    else {
                        sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(" + i + ");'>" + i
                                + "</a>");
                    }
                }

            }
            else if (bac < 5) { // 后页数不够5页
                int i = 1;
                if (pageinfo.getTotalpage() > 10) {
                    i = pageinfo.getPagenum() - (9 - bac);
                }
                for (; i > 0 && i <= pageinfo.getTotalpage(); i++) {
                    if (i == pageinfo.getPagenum()) {
                        sb.append(" <strong>" + i + "</strong> ");
                    }
                    else {
                        sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(" + i + ");'>" + i
                                + "</a>");
                    }
                }
            }
        }
        if (pageinfo.hasBack()) {
            sb.append(" <a href='#' class=\"font_grey_001\" onclick='javascript:go(")
                    .append((pageinfo.getPagenum() + 1)).append(");'>下一页</a>");
        }

        if (pageinfo.getTotalpage() > 0) {
            sb.append(" <a href=\"#\" class=\"font_grey_001\" onclick='javascript:go(" + pageinfo.getTotalpage()
                    + ");'>尾页</a></span>");
        }
        sb.append("<script>" + "function go(pageno){" + "document.form1.action=" + action + ";"
                + "document.form1.submit();" + "}" + "</script>");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
