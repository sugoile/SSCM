package com.xsg.sscm.controller;

import com.google.protobuf.Api;
import com.xsg.sscm.api.REData;
import com.xsg.sscm.dto.EditAdminParam;
import com.xsg.sscm.dto.RoleParam;
import com.xsg.sscm.model.UApi;
import com.xsg.sscm.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @des: Api接口管理
 * @package: com.xsg.sscm.controller
 * @author: xsg
 * @date: 2020/10/25
 **/
@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping(value = "/getApiList")
    public REData getApiList(){
        return REData.success(apiService.getApiList());
    }

    @GetMapping(value = "/getApiTree")
    public REData getApiTree(){
        return REData.success(apiService.getApiTree());
    }

    @GetMapping(value = "/checkLinkRole/{ApiID}")
    public REData checkLinkRole(@PathVariable("ApiID") Long ApiID){
        return  REData.success(apiService.checkLinkRole(ApiID));
    }

    @PostMapping(value = "/assignApiToRole/{apiId}")
    public REData assignApiToRole(@PathVariable("apiId") Long apiId, @RequestParam("ids") List<Long> roleIds){
        int count = apiService.assignApiToRole(apiId, roleIds);
        if(count == -1){
            return REData.failed("没有该Api，分配失败");
        }else {
            return REData.success("分配此Api成功", count);
        }
    }

    @GetMapping(value = "/getOneAndTwoApis")
    public REData getOneAndTwoApis(){
        return REData.success(apiService.getOneAndTwoApis());
    }

    @PostMapping(value = "/addApi")
    public REData addApi(@Validated @RequestBody UApi uapi, BindingResult bindingResult){
        int count = apiService.addApi(uapi);
        if (count > 0) {
            return REData.success("添加新API成功", null);
        } else if (count == -1) {
            return REData.failed("该APIUrl已经存在");
        } else {
            return REData.failed("添加失败");
        }
    }

    @PostMapping(value = "/updateApi/{Id}")
    public REData updateApi(@PathVariable("Id") Long ID,
                              @Validated @RequestBody UApi uApi, BindingResult bindingResult){
        int count = apiService.updateApi(ID, uApi);
        if(count > 0){
            return REData.success("更改成功", null);
        }else{
            return REData.failed("更改失败");
        }
    }

    @PostMapping(value = "/updatePApi")
    public REData updatePApi(@Validated @RequestBody UApi uApi, BindingResult bindingResult){
        int count = apiService.updatePApi(uApi);
        if(count > 0){
            return REData.success("更改成功", null);
        }else{
            return REData.failed("更改失败");
        }
    }

    @GetMapping(value = "/delApi/{Id}")
    public REData delApi(@PathVariable("Id") Long ID){
        int count = apiService.delApi(ID);
        if(count > 0){
            return REData.success("删除成功", null);
        }else if(count == -1){
            return REData.failed("不要删除父类API啦~");
        }
        else{
            return REData.failed("更改失败");
        }
    }
}
