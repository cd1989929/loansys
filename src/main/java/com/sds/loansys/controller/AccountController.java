package com.sds.loansys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sds.loansys.domain.entity.Account;
import com.sds.loansys.service.AccountService;

@Controller
public class AccountController extends BackMethod {

    public Log log = LogFactory.getLog(getClass());

    @Autowired
    public AccountService accountService;

    public Account account;

    public String dim_search_value;

    public Long id;

    @RequestMapping("/account")
    public String index(ModelMap model, @ModelAttribute Account Account) {
        try {
            model.addAttribute("accounts", accountService.findAll(Account));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "account/index";
    }

    @RequestMapping("/searchaccount")
    public String searchAccount(ModelMap model, @RequestParam("dim_search_value") String dim_search_value)
            throws Exception {
        try {
            model.addAttribute("accounts", accountService.searchAccountbydim("%" + dim_search_value + "%"));
            model.addAttribute("dim_search_value", dim_search_value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "account/index";
    }

    @RequestMapping("/account/toaddAccount")
    public String toadd(ModelMap model) throws Exception {
        Account Account = new Account();
        Account.setS_NO(getautoAccountNO());
        try {
            model.addAttribute("account", Account);
        }
        catch (Exception e) {
        }
        return "account/addaccount";
    }

    /**
     * 自动获取单位的编号
     * @return
     */
    private String getautoAccountNO() {
        return "C" + sdfyyyyMMddHHmmssSSS.format(new Date());
    }

    @RequestMapping("/account/addaccount")
    public String add(ModelMap model, @ModelAttribute Account Account) throws Exception {
        try {
            Account.setT_createtime(new Timestamp(System.currentTimeMillis()));
            Account = accountService.insertAccount(Account);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return index(model, Account);
    }

    @RequestMapping("/account/toeditaccount")
    public String toedit(ModelMap model, @RequestParam("id") Long id) throws Exception {
        account = accountService.findComnaybyid(id);
        try {
            model.addAttribute("account", account);
        }
        catch (Exception e) {
        }
        System.out.println(account.getS_remark());
        return "account/addAccount";
    }

    @RequestMapping("/account/editaccount")
    public String edit(ModelMap model, @RequestParam("account") Account Account) throws Exception {

        try {
            model.addAttribute("account", Account);
        }
        catch (Exception e) {
        }

        return index(model, Account);
    }

    @RequestMapping("/account/toshowaccount")
    public String toshow(ModelMap model, @RequestParam("id") Long id) throws Exception {
        try {
            model.addAttribute("account", accountService.findComnaybyid(id));
        }
        catch (Exception e) {
        }
        return "account/showaccount";
    }

    @RequestMapping("/account/deleteaccount")
    public void delete(ModelMap model, @RequestParam("id") Long id, PrintWriter printWriter) throws Exception {
        try {
            accountService.deleteComnaybyid(id);
            printWriter.write("1");
            printWriter.flush();
            printWriter.close();
        }
        catch (Exception e) {
            //            e.printStackTrace();
            printWriter.write("0");
            printWriter.flush();
            printWriter.close();
        }
    }

    @RequestMapping("/account/inportaccount")
    public String inportAccount(ModelMap model, @RequestParam MultipartFile[] myfiles, HttpServletRequest request) {
        for (MultipartFile myfile : myfiles) {
            if (myfile.isEmpty()) {
                System.out.println("文件未上传");
            }
            else {
                System.out.println("文件长度: " + myfile.getSize());
                System.out.println("文件类型: " + myfile.getContentType());
                System.out.println("文件名称: " + myfile.getName());
                System.out.println("文件原名: " + myfile.getOriginalFilename());
                System.out.println("========================================");
                String realPath = request.getSession().getServletContext().getRealPath("/WEB-INF/upload");
                try {
                    /*如果用的是Tomcat服务器，则文件会上传到\\%TOMCAT_HOME%\\webapps\\YourWebProject\\WEB-INF\\upload\\文件夹中  
                                            这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()
                                            方法内部会自动把用到的IO流关掉，我是看它的源码才知道的  */
                    FileUtils.copyInputStreamToFile(myfile.getInputStream(),
                            new File(realPath, myfile.getOriginalFilename()));
                    parseExceltoAccount(realPath + "/" + myfile.getOriginalFilename());
                }
                catch (Exception e) {
                }
            }
        }
        return index(model, account);
    }

    /**
     * 把这个路径的excel转化为Account对象并且插入数据库
     * @param path
     */
    private void parseExceltoAccount(String path) {
        try {
            // List<String[]> 中的元素 行数组String[]为excel中的每一行 
            List<String[]> list = new ArrayList<String[]>();
            InputStream is = new FileInputStream(path);
            HSSFWorkbook hwk = new HSSFWorkbook(is);// 将is流实例到 一个excel流里
            HSSFSheet sh = hwk.getSheetAt(0);// 得到book第一个工作薄sheet
            int rows = sh.getLastRowNum() + 1 - sh.getFirstRowNum(); // 总行数
            for (int i = 1; i < rows; i++) {
                HSSFRow row = sh.getRow(i);
                int cols = row.getLastCellNum() + 1 - row.getFirstCellNum(); // 该行的总列数
                String[] str = new String[cols]; // 用来存放该行每一列的值
                for (int j = 0; j < cols; j++) {
                    Object col = row.getCell((short) j);
                    if (col != null) {
                        str[j] = col.toString();
                    }
                    else {
                        break;
                    }
                    System.out.println(str[j]);
                }
                try {
                    Account Account1 = new Account();
                    Account1.setS_NO(getautoAccountNO());
                    Account1.setT_createtime(new Timestamp(System.currentTimeMillis()));
                    //                    Account1.setS_Accountname(str[0]);
                    //                    Account1.setS_principalname(str[1]);
                    //                    Double d_totalmoney = Double.parseDouble(str[2]);
                    //                    Account1.setD_totalmoney(d_totalmoney);
                    //                    Account1.setS_address(str[3]);
                    //                    Account1.setS_mobile(str[4]);
                    //                    Integer i_gongzibanjihuashu = Integer.parseInt(str[5].replace(".0", ""));
                    //                    Account1.setI_gongzibanjihuashu(i_gongzibanjihuashu);
                    //                    Integer i_qiyejihuashu = Integer.parseInt(str[6].replace(".0", ""));
                    //                    Account1.setI_qiyejihuashu(i_qiyejihuashu);
                    Account1.setS_createuser(str[7] == null ? "" : str[7]);
                    Account1.setS_remark(str[8]);
                    Account1 = accountService.insertAccount(Account1);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("e:" + e.getMessage());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account Account) {
        this.account = Account;
    }

    public String getDim_search_value() {
        return dim_search_value;
    }

    public void setDim_search_value(String dim_search_value) {
        this.dim_search_value = dim_search_value;
    }

}
