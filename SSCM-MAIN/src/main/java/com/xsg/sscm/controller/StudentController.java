package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.dto.StudentParam;
import com.xsg.sscm.model.UStudent;
import com.xsg.sscm.service.StudentService;
import com.xsg.sscm.utils.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @des: 学生信息管理端
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/9/5
 **/
@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/AddStudent")
    public REData AddStudent(@Validated @RequestBody StudentParam uStudent, BindingResult bindingResults) {
        int result = studentService.AddStudent(uStudent);
        if (result > 0) {
            return REData.success("添加学生 " + uStudent.getName() + " 成功", uStudent);
        } else if (result == -1) {
            return REData.failed("该学号已有存在的人员！！！");
        } else {
            return REData.failed("Add failed");
        }
    }

    @GetMapping(value = "/getStudent")
    public REData getStudent(@RequestParam(value = "query", required = false) String query,
                             @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return REData.success(CommonPage.resultPage(studentService.getStudent(query, pageSize, pageNum)));
    }

    @PostMapping(value = "/UpdateStudent/{id}")
    public REData UpdateStudent(@PathVariable("id") Long id,
                                @Validated @RequestBody StudentParam uStudent, BindingResult bindingResults) {
        int result = studentService.UpdateStudent(id, uStudent);
        if (result > 0) {
            return REData.success("更改学生 " + uStudent.getName() + " 信息成功", uStudent);
        } else if (result == -1) {
            return REData.failed("该学号已有存在的人员！！！");
        } else {
            return REData.failed("Add failed");
        }
    }

    @GetMapping(value = "/Delete")
    public REData Delete(@RequestParam("ids") List<Long> ids) {
        int count = studentService.Delete(ids);
        if (count < 1) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }

    @GetMapping(value = "/DeleteOne/{id}")
    public REData DeleteOne(@PathVariable("id") Long id) {
        int count = studentService.DeleteOne(id);
        if (count == 0) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }




}
