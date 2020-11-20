package com.xsg.sscm.utils;

import com.github.pagehelper.PageInfo;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页配件的处理类
 * 用于PagrHelper分页的操作
 * Created by xsg on 2020/2/14 19:22
 */
@Setter
@Getter
public class CommonPage<T>{

    private Integer PageNum;        //当前页
    private Integer PageSize;       //当前分页数量
    private Integer TotalPage;      //分页数
    private Long Total;             //总记录数
    private List<T> lists;           //分页数组

    /**
     * PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> resultPage(List<T> list){
        CommonPage<T> commonpage = new CommonPage<>();

        //开启分页后结果操作
        PageInfo<T> pageInfo = new PageInfo<>(list);
        commonpage.setPageNum(pageInfo.getPageNum());
        commonpage.setPageSize(pageInfo.getPageSize());
        commonpage.setTotalPage(pageInfo.getPages());
        commonpage.setTotal(pageInfo.getTotal());
        commonpage.setLists(pageInfo.getList());

        return commonpage;
    }
}
