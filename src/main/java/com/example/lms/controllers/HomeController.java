package com.example.lms.controllers;

import com.example.lms.Books;
import com.example.lms.BooksDAO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    DataSource dataSource;
    @Autowired
    private BooksDAO dao;

    @RequestMapping("/")
    public String indexPage(Model model){
        return "home";
    }


    @RequestMapping("/books")
    public String viewHomepage(Model model) {
        try {
            List<Books> booksList = dao.list();
            model.addAttribute("booksList", booksList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "books";
    }

    @RequestMapping("/newBook")
    public String showNewForm(Model model){
        try {
            Books books = new Books();
            model.addAttribute("books", books);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "newBook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("books") Books books){
        try{
            dao.save(books);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "redirect:/books";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name= "id") int id){

            ModelAndView mav = new ModelAndView("editBook");
            Books books = dao.get(id);
            mav.addObject("books", books);


        return mav;

    }

    @RequestMapping(value = "/Update", method = RequestMethod.POST)
    public String update(@ModelAttribute("books") Books books){
            dao.update(books);
        return "redirect:/books";
    }


    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name= "id") int id){


        dao.delete(id);



        return "redirect:/books";

    }




}
