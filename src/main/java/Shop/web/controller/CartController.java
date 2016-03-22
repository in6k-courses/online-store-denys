package Shop.web.controller;

import Shop.core.entity.Product;
import Shop.core.model.PurchaseItem;
import Shop.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 3/22/16.
 */
//TODO CLEAN this
@Controller
public class CartController {
    @Autowired
    private ProductService productService;

    private List<PurchaseItem> purchaseItems;

    @RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
    public String doAddProduct(ModelMap model, HttpServletRequest request){

        getPuchaseItems(request.getSession());

        Integer id = Integer.valueOf(request.getParameter("id"));
        System.out.println(id);

        Product addedProduct = productService.getProductById(id);
        addNewProduct(addedProduct, BigDecimal.ONE);

        setPurchaseItems(request.getSession());

        model.addAttribute("purchaseItems", purchaseItems);

        return "redirect:/cart";
    }

    private void getPuchaseItems(HttpSession session){
        purchaseItems = (List<PurchaseItem>) session.getAttribute("purchaseItems");
        if(purchaseItems == null){
            purchaseItems = new ArrayList<>();
        }
    }

    private void setPurchaseItems(HttpSession session){
        session.setAttribute("purchaseItems", purchaseItems);
    }

    private void addNewProduct(Product product, BigDecimal amount){
        PurchaseItem pi = new PurchaseItem();
        pi.setProduct(product);
        pi.setAmount(amount);
        purchaseItems.add(pi);
    }

    @RequestMapping(value = "cart", method = RequestMethod.GET)
    public String showCartContent(HttpSession session, ModelMap model){
        List<PurchaseItem> purchaseItems = (List<PurchaseItem>) session.getAttribute("purchaseItems");
        if(purchaseItems == null) purchaseItems = new ArrayList<>();
        model.addAttribute(purchaseItems);
        return "cart";
    }

}
