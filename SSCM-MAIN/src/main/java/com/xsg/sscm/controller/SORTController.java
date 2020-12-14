package com.xsg.sscm.controller;

import com.xsg.sscm.api.REData;
import com.xsg.sscm.dto.RandID;
import com.xsg.sscm.dto.SORTLoginParam;
import com.xsg.sscm.dto.SORTinfo;
import com.xsg.sscm.service.SORTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @des:
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/12/14
 **/
@RestController
@RequestMapping("/SORTController")
public class SORTController {

    @Autowired
    private SORTService sortService;

    @PostMapping(value = "/UserLogin")
    public REData UserLogin(@RequestBody SORTLoginParam sortLoginParam) {
        RandID count = sortService.UserLogin(sortLoginParam);
        if (count.getResult() == -1) {
            return REData.failed("账号不存在！！！");
        } else if (count.getResult() == 2) {
            return REData.failed("密码错误!!!");
        } else if (count.getResult() == 1) {
            Map<String, Object> results = new HashMap<>();
            results.put("RandID", count);
            results.put("sortLogin", sortLoginParam);
            return REData.success(sortLoginParam.getUsername() + " 成功登入", results);
        } else {
            return REData.failed("内部后端错误!!!");
        }
    }

    @GetMapping(value = "/getStudentByID/{id}")
    public REData getStudentByID(@PathVariable("id") Long id) {
        return REData.success(sortService.getStudentByID(id));
    }

    @GetMapping(value = "/getTeacherByID/{id}")
    public REData getTeacherByID(@PathVariable("id") Long id) {
        return REData.success(sortService.getTeacherByID(id));
    }


    @GetMapping(value = "/getCourceByID/{id}")
    public REData getCourceByID(@PathVariable("id") Long id) {
        return REData.success(sortService.getCourceByID(id));
    }

    @GetMapping(value = "/getChooseCourceByID/{id}")
    public REData getChooseCourceByID(@PathVariable("id") Long id) {
        return REData.success(sortService.getChooseCourceByID(id));
    }

    @GetMapping(value = "/chooseCource/{id}")
    public REData chooseCource(@PathVariable("id") Long id,
                               @RequestParam(value = "Couseid") Long Couseid) {
        int count = sortService.chooseCource(id, Couseid);
        if (count > 0) {
            return REData.success("选课成功", null);
        } else if (count == -1) {
            return REData.failed("该课程人数已满");
        } else if (count == -2) {
            return REData.failed("你已选过该课, 无法重复选择");
        } else if (count == -3) {
            return REData.failed("只能够选择两门课程，不能多选");
        } else {
            return REData.failed("选课失败");
        }
    }

    @GetMapping(value = "/NochooseCourse/{id}")
    public REData NochooseCourse(@PathVariable("id") Long id,
                                 @RequestParam(value = "Couseid") Long Couseid) {
        int count = sortService.NochooseCourse(id, Couseid);
        if (count > 0) {
            return REData.success("退课成功", null);
        } else {
            return REData.failed("退课失败");
        }
    }

    @GetMapping(value = "/getCourceByTID/{id}")
    public REData getCourceByTID(@PathVariable("id") Long id) {
        return REData.success(sortService.getCourceByTID(id));
    }

    @GetMapping(value = "/getChooseCourceByCID/{id}")
    public REData getChooseCourceByCID(@PathVariable("id") Long id,
                                       @RequestParam(value = "tid") Long tid) {
        return REData.success(sortService.getChooseCourceByCID(id, tid));
    }

    @GetMapping(value = "/ScoreToS")
    public REData ScoreToS(@RequestParam("Tid") Long Tid,
                           @RequestParam("Sid") Long Sid,
                           @RequestParam("Cid") Long Cid,
                           @RequestParam("score") Integer score) {
        return REData.success(sortService.ScoreToS(Tid, Sid, Cid, score));
    }
}
