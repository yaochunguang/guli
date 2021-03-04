package com.company.eduservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.common.Result;
import com.company.eduservice.entity.EduTeacher;
import com.company.eduservice.entity.query.EduTeacherQueryVO;
import com.company.eduservice.service.EduTeacherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.element.VariableElement;
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
     *
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
     *
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

    @ApiOperation("讲师分页列表数据")
    @GetMapping("/eduTeacherPageList/{pageIndex}/{pageSize}")
    public Result eduTeacherPageList(@ApiParam(name = "pageIndex", value = "当前页码", required = true) @PathVariable Integer pageIndex,
                                     @ApiParam(name = "pageSize", value = "每页记录数", required = true)@PathVariable Integer pageSize,
                                     @ApiParam(name = "teacherQuery", value = "查询对象", required = false)EduTeacherQueryVO eduTeacherQueryVO) {
        Page<EduTeacher> pageParams = new Page<>(pageIndex, pageSize);
        eduTeacherService.pageQuery(pageParams, eduTeacherQueryVO);
        List<EduTeacher> eduTeacherList = pageParams.getRecords();
        long total = pageParams.getTotal();
        return Result.ok().data("total", total).data("rows", eduTeacherList);
    }
}

