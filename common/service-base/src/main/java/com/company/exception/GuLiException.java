package com.company.exception;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: yaochunguang
 * @date: 2021-03-05 17:02
 * @description: 自定义异常
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuLiException extends RuntimeException {

    @ApiModelProperty(value = "状态码")
    private Integer errorCode;

    @ApiModelProperty(value = "错误信息")
    private String message;
}
