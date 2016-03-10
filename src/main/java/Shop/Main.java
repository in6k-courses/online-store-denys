package Shop;

import Shop.Discount.ConstantDiscount;
import Shop.Discount.VolumeDiscount;
import Shop.UI.UIConsole;

public class Main {

    public static void main(String[] args) {
//        // - - - - -Say hello and get what user want - - - - - - -
//        UIConsole.printGreating();
//        UIConsole.printRequest();
//        ShoppingCart cart = new ShoppingCart(UIConsole.getSelectedItems());
//        //- - - - - - - - - - - - - - - -
//        //- - - - - -Working with discount - - - - - - - - - -
//        ArgsChecker argsCheker = new ArgsChecker(args);
//        if (argsCheker.isArgsSetted()) {
//            System.out.print("Constant discount acitated: ");
//            System.out.println(argsCheker.getTotalPercent()*100 + "% off");
//            cart.addDiscount(new ConstantDiscount(argsCheker.getTotalPercent()));
//        } else {
//            System.out.println("Volume discount is active: 5% off");
//            cart.addDiscount(new VolumeDiscount(0.05));
//        }
//        //- - - - - - Working with Sales- - - - - - - - - -
//        UIConsole.printAboutActiveSales(cart.getSalesList());
//        //- - - - - - Check - - - - - - - - - -
//        cart.getTotalCost();
//        cart.applyDiscounts();
//        cart.applySales();
//        UIConsole.printCheck(cart);
    }

}

