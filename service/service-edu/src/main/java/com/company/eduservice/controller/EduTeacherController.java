package com.company.eduservice.controller;


import com.company.common.Result;
import com.company.eduservice.entity.EduTeacher;
import com.company.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author yaochunguang
 * @since 2021-02-27
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    /**
     * 查询所有讲师
     * @return
     */
    @ApiOperation("查询所有讲师")
    @GetMapping("/findAllTeacher")
    public Result findAllTeacher() {
        List<EduTeacher> eduTeacherList = eduTeacherService.list(null);
        return Result.ok().data("item", eduTeacherList);
    }

    /**
     * 根据id删除讲师信息
     * @param id
     * @return
     */
    @ApiOperation("根据id删除讲师信息")
    @DeleteMapping("/removeTeacherById/{id}")
    public Result removeTeacherById(@PathVariable String id) {
        boolean res = eduTeacherService.removeById(id);
        if (res) {
            return Result.ok();
        } else {
            return Result.error();
        }
    }
}

