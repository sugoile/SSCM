package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.service.DepartmentService;
import com.xsg.sscm.utils.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @des:
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/11/7
 **/
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/getDepartment")
    public REData getDepartment(@RequestParam(value = "query", required = false) String query,
                                @RequestParam(value = "pageSize",defaultValue = "8") Integer pageSize,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum){
        return REData.success(CommonPage.resultPage(departmentService.getDepartment(query, pageSize, pageNum)));
    }

    @GetMapping(value = "/getDepartmentNoSelect")
    public REData getDepartmentNoSelect(){
        return REData.success(departmentService.getDepartmentNoSelect());
    }
}
