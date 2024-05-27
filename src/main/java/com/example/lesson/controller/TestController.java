package com.example.lesson.controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.form.AddForm;
import com.example.lesson.form.UpForm;
import com.example.lesson.service.PgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @Autowired
    PgProductService pgProductService;


    @GetMapping("/product-list")
    public String productList(Model model) {
        model.addAttribute("products", pgProductService.findAll());
        return "showAll";
    }

    @PostMapping("/product-list")
    public String indexAdd(@ModelAttribute("addProduct") AddForm addForm) {
//        return "addProduct";
        return "redirect:/product-add";
    }


    @GetMapping("/product/{id}")
    public String aProduct(@PathVariable("id") int aaaaa, Model model) {
        model.addAttribute("aProduct", pgProductService.findById(aaaaa));
        return "findById";
    }

    @PostMapping("/product/{id}")
    public String dePro(@PathVariable("id") int id, Model model) {
        model.addAttribute("upProduct", pgProductService.findById(id));
        //return "updateProduct";
        return "redirect:/product/update/{id}";
    }

    @RequestMapping(value = "/product/{id}", params = "delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") int id, Model model) {
        pgProductService.delete(id);
        model.addAttribute("products", pgProductService.findAll());
        return "redirect:/product-list";
    }


    @GetMapping("/product-add")
    public String index(@ModelAttribute("addProduct") AddForm addForm) {
        return "addProduct";
    }

    @PostMapping("/product-add")
    public String addProduct(@Validated @ModelAttribute("addProduct") AddForm addForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        ProductRecord add = new ProductRecord(-1, addForm.getName(), addForm.getPrice());
        pgProductService.insert(add);
        model.addAttribute("products", pgProductService.findAll());
        //return "showAll";
        return "redirect:/product-list";
    }


    @GetMapping("/product/update/{id}")
    public String indexUpdate(@PathVariable("id") int id, @ModelAttribute("upProduct") UpForm upForm, Model model) {
        model.addAttribute("upProduct", pgProductService.findById(id));
        return "updateProduct";
    }

    @PostMapping("/product/update/{id}")
    public String updateProduct(@PathVariable("id") int id, @Validated @ModelAttribute("upProduct") UpForm upForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("upProduct", upForm);
            return "updateProduct";
        }
        ProductRecord up = new ProductRecord(id, upForm.getName(), upForm.getPrice());
        pgProductService.update(up);
        model.addAttribute("products", pgProductService.findAll());
        return "redirect:/product-list";
    }

    @GetMapping("/product-management")
    public String screenSend(){
        return "productsOneScreen";
    }
}

