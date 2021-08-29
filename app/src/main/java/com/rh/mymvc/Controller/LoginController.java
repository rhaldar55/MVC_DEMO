package com.rh.mymvc.Controller;

import com.rh.mymvc.Model.User;
import com.rh.mymvc.View.ILoginView;

public class LoginController implements ILoginController{

    ILoginView loginView;

    public LoginController(ILoginView iLoginView) {
        this.loginView = iLoginView;
    }

    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValid();
        if(loginCode == 0)
        {
            loginView.OnLoginError("Please enter Email");
        }else  if (loginCode == 1){
            loginView.OnLoginError("Please enter A valid Email");
        } else  if (loginCode == 2)
        {
            loginView.OnLoginError("Please enter Password");
        }else  if(loginCode == 3){
            loginView.OnLoginError("Please enter Password greater the 6 char");
        }
        else {
            loginView.OnLoginSuccess("login Successful");
        }
    }
}
