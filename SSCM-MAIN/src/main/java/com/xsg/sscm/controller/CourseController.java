package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.dto.CourseParam;
import com.xsg.sscm.dto.TeacherParam;
import com.xsg.sscm.service.CourseService;
import com.xsg.sscm.service.TeacherService;
import com.xsg.sscm.utils.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @des:
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/12/13
 **/
@RestController
@RequestMapping("/Course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/AddCourse")
    public REData AddCourse(@Validated @RequestBody CourseParam courseParam, BindingResult bindingResults) {
        int result = courseService.AddCourse(courseParam);
        if (result > 0) {
            return REData.success("添加课程 " + courseParam.getName() + " 成功", courseParam);
        }  else {
            return REData.failed("Add failed");
        }
    }

    @GetMapping(value = "/getCourse")
    public REData getCourse(@RequestParam(value = "query", required = false) String query,
                             @RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return REData.success(CommonPage.resultPage(courseService.getCourse(query, pageSize, pageNum)));
    }

    @PostMapping(value = "/UpdateCourse/{id}")
    public REData UpdateCourse(@PathVariable("id") Long id,
                                @Validated @RequestBody  CourseParam courseParam, BindingResult bindingResults) {
        int result = courseService.UpdateCourse(id, courseParam);
        if (result > 0) {
            return REData.success("更改课程 " + courseParam.getName() + " 信息成功", courseParam);
        } else {
            return REData.failed("Add failed");
        }
    }

    @GetMapping(value = "/Delete")
    public REData Delete(@RequestParam("ids") List<Long> ids) {
        int count = courseService.Delete(ids);
        if (count < 1) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }

    @GetMapping(value = "/DeleteOne/{id}")
    public REData DeleteOne(@PathVariable("id") Long id) {
        int count = courseService.DeleteOne(id);
        if (count == 0) {
            return REData.failed("删除失败");
        } else {
            return REData.success("删除成功", null);
        }
    }

    @GetMapping(value = "/UpdateStates/{Id}")
    public REData UpdateStates(@PathVariable("Id") Long ID,
                              @RequestParam("states") Integer states){
        if(courseService.UpdateStates(ID, states) > 0 && states == 1){
            return REData.success("更改为开启状态", null);
        }else if(courseService.UpdateStates(ID, states) > 0 && states == 0){
            return REData.success("更改为关闭状态", null);
        }else{
            return REData.failed("更改状态失败");
        }
    }
}
