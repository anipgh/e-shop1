package com.eshop.demo.controller;

import com.eshop.demo.model.dao.Product;
import com.eshop.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Ani Poghosyan on 14/02/2022
 */
@Controller
public class AppController {
    @Autowired
    private ProductService service;

    @RequestMapping("/list")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new_product";
    }


    //@RequestMapping(value = "/save", method = RequestMethod.POST)
   // public String saveProduct(@ModelAttribute("product") com.eshop.demo.model.dto.Product product) {
      //  if(product.getId() == null) {
         //   Product productDao = new Product();
           // productDao.setCatagory(product.getCatagory());
           // productDao.setMadein(product.getMadein());
           // productDao.setName(product.getName());
           // productDao.setPrice(product.getPrice());
           // service.save(productDao);
       // }
       // return "/";
    //}

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);

        return "index";
    }


    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("show_edit_product");

        Product product = service.get(id);
        com.eshop.demo.model.dto.Product productDto = new com.eshop.demo.model.dto.Product();
        productDto.setId(id);
        productDto.setCatagory(product.getCatagory());
        productDto.setMadein(product.getMadein());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        mav.addObject("product", productDto);

        return mav;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.PUT)
    public String editProduct(@ModelAttribute("product") com.eshop.demo.model.dto.Product product) {
        Product productDao = service.get(product.getId());
        if(productDao!= null){
            productDao.setCatagory(product.getCatagory());
            productDao.setMadein(product.getMadein());
            productDao.setName(product.getName());
            productDao.setPrice(product.getPrice());
            service.save(productDao);
        }

        return "/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);

        return "/";
    }
}
