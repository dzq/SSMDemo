package com.dzq.demo.controller;

import com.dzq.demo.pojo.Books;
import com.dzq.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@Controller
@RequestMapping("/book")
@ApiIgnore
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    /**
     * 书籍列表
     * @param model
     * @return
     */
    @RequestMapping(value = "/allBook", method = RequestMethod.GET)
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    /**
     * 跳转到添加书籍页面
     * @return
     */
    @RequestMapping(value = "/toAddBook", method = RequestMethod.GET)
    public String toAddPaper() {
        return "addBook";
    }

    /**
     * 添加书籍
     * @param books 书籍数据
     * @return
     */
    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    /**
     * 跳转到更新书籍页面
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/toUpdateBook", method = RequestMethod.GET)
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    /**
     * 更新书籍信息
     * @param model
     * @param book 书籍数据
     * @return
     */
    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }

    /**
     * 删除书籍
     * @param id 书籍id
     * @return
     */
    @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
    public String deleteBookByIdeBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    /**
     * 根据名称查询书籍
     * @param bookName 书籍名称
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryBook", method = RequestMethod.POST)
    public String queryBook(String bookName, Model model) {
        List<Books> list = bookService.queryBookByName(bookName);
        if( list.size() == 0  ){
            model.addAttribute("error","未找到名称包含 "+bookName+" 的书籍");
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
