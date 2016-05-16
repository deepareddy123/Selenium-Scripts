package co.deepa.checkoutflow;

import co.deepa.CustomLocomotive;
import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by admin on 4/24/2016.
 */
@Config(browser = Browser.CHROME,
        url = "https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin")
public class amazonlogin extends CustomLocomotive{
    @Parameters({"email","password"})
    @Test
    public void login(String email, String password) {
        setText(ObjectRepository.loginemail,email);
        setText(ObjectRepository.loginpassword,password);
        click(ObjectRepository.signInButton);
        //validatePresent(ObjectRepository.logout);
    }
}
