package locators;

public class LoginScreenLocators {
    public final String shrineGrid = "(//*[@class='android.view.View' and ./parent::*[@class='android.view.View' and ./parent::*[@class='android.view.View'] and (./preceding-sibling::* | ./following-sibling::*)[@class='android.view.View']]]/*[@class='android.view.View'])[2]";
    public final String username="//*[@class='android.widget.EditText'][1]";
    public final String nextButton="//*[@class='android.widget.Button'][2]";
    public final String password="//*[@class='android.widget.EditText'][2]";
    public final String shrineIcon ="//*[@class='android.view.View'][3]";
}
