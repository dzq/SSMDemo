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

    @RequestMapping(value = "/allBook", method = RequestMethod.GET)
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping(value = "/toAddBook", method = RequestMethod.GET)
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String addPaper(Books books) {
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping(value = "/toUpdateBook", method = RequestMethod.GET)
    public String toUpdateBook(Model model, int id) {
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("book",books );
        return "updateBook";
    }

    @RequestMapping(value = "/updateBook", method = RequestMethod.POST)
    public String updateBook(Model model, Books book) {
        System.out.println(book);
        bookService.updateBook(book);
        Books books = bookService.queryBookById(book.getBookID());
        model.addAttribute("books", books);
        return "redirect:/book/allBook";
    }
    @RequestMapping(value = "/del/{bookId}", method = RequestMethod.GET)
    public String deleteBookByIdeBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

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
