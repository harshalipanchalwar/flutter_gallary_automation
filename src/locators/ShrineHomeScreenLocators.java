package locators;

public class ShrineHomeScreenLocators {
    public final String shrineLogo = "//*[@content-desc='SHRINE']";
    public final String menu = "//android.widget.Button[@content-desc=\"Open menu\"]";
    public final String menuIcon = "//*[@content-desc='MENU']";
    public final String clothing="//android.widget.Button[@content-desc=\"CLOTHING\"]";
    public final String searchIcon ="//*[@content-desc='Search']";
   // public final String shirt = "//android.view.View[@contentDescription='Plaster tunic\\n$38, Add to cart']";
   //public final String shirt = "//*[contains(@contentDescription,'Sea tunic')]";
    //public final String shirt ="(((//*[@class='android.view.View' and ./parent::*[@class='android.view.View'] and (./preceding-sibling::* | ./following-sibling::*)[@contentDescription='Shopping cart, no items']]/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View']])[2]/*/*/*[@class='android.view.View' and ./parent::*[@class='android.view.View' and ./parent::*[@class='android.view.View']]])[1]/*[./*[@class='android.widget.Button']])[2]";
    public final String shirt = "//*[@class='android.view.View'][3]//android.widget.Button[contains(@content-desc,'Clay sweater')]";
}
