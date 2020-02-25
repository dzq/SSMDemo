package com.dzq.api.controller;

import com.dzq.api.vo.BookListResponse;
import com.dzq.api.vo.BookResponse;
import com.dzq.api.vo.ResponseBody;
import com.dzq.demo.pojo.Books;
import com.dzq.demo.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "书籍管理")
@RestController
/**
 * 书籍API
 */
public class BookAPIController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;



    @GetMapping(value = "/book/list")
    @ApiOperation(value = "查询所有书籍", notes = "无需添加参数", code = 200, produces = "application/json")
    public BookListResponse list() {
        BookListResponse body = new BookListResponse();
        List<Books> list =  bookService.queryAllBook();
        body.setData(list);
        return body;
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "查询指定ID的书籍", notes = "书籍ID", code = 200, produces = "application/json")
    public BookResponse queryBookById(@PathVariable("id") int id) {
        BookResponse body = new BookResponse();
        body.setData(bookService.queryBookById(id));
        return body;
    }
}
