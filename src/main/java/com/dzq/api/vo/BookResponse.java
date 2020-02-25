package com.dzq.api.vo;

import com.dzq.demo.pojo.Books;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("书籍返回对象")
public class BookResponse extends  ResponseBody {
    @ApiModelProperty("书籍数据")
    private Books data;
}
