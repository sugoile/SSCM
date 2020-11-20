package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.model.UStudent;
import com.xsg.sscm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @des:    学生信息管理端
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/9/5
 **/
@RestController
@RequestMapping("/StudentController")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/AddStudent")
    public REData AddStudent(@Validated  @RequestBody UStudent uStudent){
        int result = studentService.AddStudent(uStudent);
        if(result == 1){
            return REData.success(uStudent);
        }else{
            return REData.failed("Add failed");
        }
    }
}
