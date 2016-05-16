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
        url = "https://www.amazon.in/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&prevRID=VDGM8WXDRGZVHFVKEY4H&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0")

   public class CreateAccount extends CustomLocomotive{
    CustomLocomotive custom= new CustomLocomotive();
@Parameters({"email","password"})
    @Test
    public void createAccount(String email, String password){
        setText(ObjectRepository.name,"Deepa");
        setText(ObjectRepository.email,email);
        setText(ObjectRepository.password, password);
        click(ObjectRepository.CreateAccountSubmit);
        //validatePresent(ObjectRepository.logout);
        //custom.logout();
    }


}
