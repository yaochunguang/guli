package com.company.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.eduservice.entity.EduTeacher;
import com.company.eduservice.entity.query.EduTeacherQueryVO;
import com.company.eduservice.mapper.EduTeacherMapper;
import com.company.eduservice.service.EduTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author yaochunguang
 * @since 2021-02-27
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> pageParam, EduTeacherQueryVO eduTeacherQueryVO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (eduTeacherQueryVO == null) {
            baseMapper.selectPage(pageParam, queryWrapper);
        }
        String name = eduTeacherQueryVO.getName();
        Integer level = eduTeacherQueryVO.getLevel();
        String begin = eduTeacherQueryVO.getBegin();
        String end = eduTeacherQueryVO.getEnd();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(level)) {
            queryWrapper.eq("level", level);
        }
        if (!StringUtils.isEmpty(begin)) {
            queryWrapper.ge("begin", begin);
        }
        if (!StringUtils.isEmpty(end)) {
            queryWrapper.le("end", end);
        }
        baseMapper.selectPage(pageParam, queryWrapper);
    }
}
