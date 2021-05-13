package zatribune.spring.ex_mongodb_docker.controllers;

import zatribune.spring.ex_mongodb_docker.commands.ProductCommand;
import zatribune.spring.ex_mongodb_docker.converters.ProductToProductCommand;
import zatribune.spring.ex_mongodb_docker.entities.Product;
import zatribune.spring.ex_mongodb_docker.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
/**
 * Created by ZaTribune on 22/jan/2021.
 */
@Controller
public class ProductController {
    private ProductService productService;

    private ProductToProductCommand productToProductCommand;

    @Autowired
    public void setProductToProductCommand(ProductToProductCommand productToProductCommand) {
        this.productToProductCommand = productToProductCommand;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/")
    public String redirectToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getById(id));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(id);
        ProductCommand productCommand = productToProductCommand.convert(product);

        model.addAttribute("productCommand", productCommand);
        return "/product/productForm";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productCommand", new ProductCommand());
        return "/product/productForm";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid ProductCommand productCommand, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "/product/productForm";
        }

        Product savedProduct = productService.saveOrUpdateProductForm(productCommand);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(id);
        return "redirect:/product/list";
    }
}
