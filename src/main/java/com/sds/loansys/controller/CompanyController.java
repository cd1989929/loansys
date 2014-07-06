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

import com.sds.loansys.domain.entity.Company;
import com.sds.loansys.service.CompanyService;

@Controller
public class CompanyController extends BackMethod {

    public Log log = LogFactory.getLog(getClass());

    @Autowired
    public CompanyService companyService;

    public Company company;

    public String dim_search_value;

    public Long id;

    @RequestMapping("/company")
    public String index(ModelMap model, @ModelAttribute Company company) {
        try {
            model.addAttribute("companys", companyService.findAll(company));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "company/index";
    }

    @RequestMapping("/searchcompany")
    public String searchcompany(ModelMap model, @RequestParam("dim_search_value") String dim_search_value)
            throws Exception {
        try {
            model.addAttribute("companys", companyService.searchcompanybydim("%" + dim_search_value + "%"));
            model.addAttribute("dim_search_value", dim_search_value);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "company/index";
    }

    @RequestMapping("/company/toaddcompany")
    public String toadd(ModelMap model) throws Exception {
        Company company = new Company();
        company.setS_NO(getautoCompanyNO());
        try {
            model.addAttribute("company", company);
        }
        catch (Exception e) {
        }
        return "company/addcompany";
    }

    /**
     * 自动获取单位的编号
     * @return
     */
    private String getautoCompanyNO() {
        return "C" + sdfyyyyMMddHHmmssSSS.format(new Date());
    }

    @RequestMapping("/company/addcompany")
    public String add(ModelMap model, @ModelAttribute Company company) throws Exception {
        try {
            company.setT_createtime(new Timestamp(System.currentTimeMillis()));
            company = companyService.insertCompany(company);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return index(model, company);
    }

    @RequestMapping("/company/toeditcompany")
    public String toedit(ModelMap model, @RequestParam("id") Long id) throws Exception {
        company = companyService.findComnaybyid(id);
        try {
            model.addAttribute("company", company);
        }
        catch (Exception e) {
        }
        System.out.println(company.getS_remark());
        return "company/addcompany";
    }

    @RequestMapping("/company/editcompany")
    public String edit(ModelMap model, @RequestParam("company") Company company) throws Exception {

        try {
            model.addAttribute("company", company);
        }
        catch (Exception e) {
        }

        return index(model, company);
    }

    @RequestMapping("/company/toshowcompany")
    public String toshow(ModelMap model, @RequestParam("id") Long id) throws Exception {
        try {
            model.addAttribute("company", companyService.findComnaybyid(id));
        }
        catch (Exception e) {
        }
        return "company/showcompany";
    }

    @RequestMapping("/company/deletecompany")
    public void delete(ModelMap model, @RequestParam("id") Long id, PrintWriter printWriter) throws Exception {
        try {
            companyService.deleteComnaybyid(id);
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

    @RequestMapping("/company/inportcompany")
    public String inportcompany(ModelMap model, @RequestParam MultipartFile[] myfiles, HttpServletRequest request) {
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
                    parseExceltoCompany(realPath + "/" + myfile.getOriginalFilename());
                }
                catch (Exception e) {
                }
            }
        }
        return index(model, company);
    }

    /**
     * 把这个路径的excel转化为company对象并且插入数据库
     * @param path
     */
    private void parseExceltoCompany(String path) {
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
                    Company company1 = new Company();
                    company1.setS_NO(getautoCompanyNO());
                    company1.setT_createtime(new Timestamp(System.currentTimeMillis()));
                    company1.setS_companyname(str[0]);
                    company1.setS_principalname(str[1]);
                    Double d_totalmoney = Double.parseDouble(str[2]);
                    company1.setD_totalmoney(d_totalmoney);
                    company1.setS_address(str[3]);
                    company1.setS_mobile(str[4]);
                    Integer i_gongzibanjihuashu = Integer.parseInt(str[5].replace(".0", ""));
                    company1.setI_gongzibanjihuashu(i_gongzibanjihuashu);
                    Integer i_qiyejihuashu = Integer.parseInt(str[6].replace(".0", ""));
                    company1.setI_qiyejihuashu(i_qiyejihuashu);
                    company1.setS_createuser(str[7] == null ? "" : str[7]);
                    company1.setS_remark(str[8]);
                    company1 = companyService.insertCompany(company1);
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDim_search_value() {
        return dim_search_value;
    }

    public void setDim_search_value(String dim_search_value) {
        this.dim_search_value = dim_search_value;
    }

}
