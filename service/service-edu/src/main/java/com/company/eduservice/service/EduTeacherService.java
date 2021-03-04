package com.company.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.company.eduservice.entity.query.EduTeacherQueryVO;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author yaochunguang
 * @since 2021-02-27
 */
public interface EduTeacherService extends IService<EduTeacher> {

    /**
     * 带条件分页查询讲师信息
     * @param pageParam
     * @param eduTeacherQueryVO
     */
    void pageQuery(Page<EduTeacher> pageParam, EduTeacherQueryVO eduTeacherQueryVO);
}
