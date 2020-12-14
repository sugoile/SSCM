package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.dto.TeacherParam;
import com.xsg.sscm.service.TeacherService;
import com.xsg.sscm.service.TeacherService;
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
@RequestMapping("/Teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping(value = "/AddTeacher")
    public REData AddTeacher(@Validated @RequestBody TeacherParam uTeacher, BindingResult bindingResults) {
        int result = teacherService.AddTeacher(uTeacher);
        if (result > 0) {
            return REData.success("添加教师 " + uTeacher.getTname() + " 成功", uTeacher);
        } else if (result == -1) {
            return REData.failed("该教工号已有存在的人员！！！");
        } else {
            return REData.failed("Add failed");
        }
    }

    @GetMapping(value = "/getTeacher")
    public REData getTeacher(@RequestParam(value = "query", required = false) String query,
                             @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return REData.success(CommonPage.resultPage(teacherService.getTeacher(query, pageSize, pageNum)));
    }

    @GetMapping(value = "/getTeacherNoSelect")
    public REData getTeacherNoSelect() {
        return REData.success(teacherService.getTeacherNoSelect());
    }

    @PostMapping(value = "/UpdateTeacher/{id}")
    public REData UpdateTeacher(@PathVariable("id") Long id,
                                @Validated @RequestBody TeacherParam uTeacher, BindingResult bindingResults) {
        int result = teacherService.UpdateTeacher(id, uTeacher);
        if (result > 0) {
            return REData.success("更改教师 " + uTeacher.getTname() + " 信息成功", uTeacher);
        } else if (result == -1) {
            return REData.failed("该教工号已有存在的人员！！！");
        } else {
            return REData.failed("Add failed");
        }
    }

    @GetMapping(value = "/Delete")
    public REData Delete(@RequestParam("ids") List<Long> ids) {
        int count = teacherService.Delete(ids);
        if (count < 1) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }

    @GetMapping(value = "/DeleteOne/{id}")
    public REData DeleteOne(@PathVariable("id") Long id) {
        int count = teacherService.DeleteOne(id);
        if (count == 0) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }




}
