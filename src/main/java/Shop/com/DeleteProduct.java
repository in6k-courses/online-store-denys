package Shop.com;

import Shop.ShopBase.PurchaseItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by employee on 3/16/16.
 */
public class DeleteProduct extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int id = Integer.valueOf(req.getParameter("id"));

        List<PurchaseItem> purchaseList = (List<PurchaseItem>) session.getAttribute("purchaseList");

        purchaseList.remove(id);

        session.setAttribute("purchaseList", purchaseList);

        resp.sendRedirect("cart.jsp");
    }

}
