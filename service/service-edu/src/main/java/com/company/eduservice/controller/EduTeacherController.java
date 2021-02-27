package com.company.eduservice.controller;


import com.company.eduservice.entity.EduTeacher;
import com.company.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/findAllTeacher")
    public List<EduTeacher> findAllTeacher() {
        return eduTeacherService.list(null);
    }
}

