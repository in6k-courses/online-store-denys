package Shop.com;

import Shop.ShopBase.PurchaseItem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by employee on 3/17/16.
 */
public class ChangeProductAmount extends HttpServlet{
    HttpSession session;
    int changingProcut;
    boolean up;
    boolean down;
    List<PurchaseItem> purchaseItems;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        purchaseItems = (List<PurchaseItem>) session.getAttribute("purchaseItems");
        changingProcut = Integer.valueOf(req.getParameter("product"));

                //TODO rewrite this piece of
        if(req.getParameter("up") != null){
            purchaseItems.get(changingProcut).addAmount(BigDecimal.ONE);
        } else if (req.getParameter("down") != null) {
            if(purchaseItems.get(changingProcut).getAmount().doubleValue() > 1)
            purchaseItems.get(changingProcut).addAmount(BigDecimal.ONE.negate());
        }

        resp.sendRedirect("cart.jsp");
    }
}
