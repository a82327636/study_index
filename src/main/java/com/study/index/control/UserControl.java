package com.study.index.control;

import com.study.common.exception.SysRunException;
import com.study.common.shiro.ShiroUser;
import com.study.common.shiro.ShiroUtil;
import com.study.common.util.StringUtils;
import com.study.index.bean.User;
import com.study.index.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ProjectName: study_card_index
 * @Package: com.study.index.control
 * @ClassName: UserControl
 * @Author: zwj
 * @Description: 注释
 * @Date: 2019/4/22 14:11
 * @Version: 1.0
 */
@Controller
@RequestMapping
public class UserControl {

    @Autowired private UserService userService;

    @RequestMapping(value = "/")
    public String main(){
        return "/back/index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap modelMap){
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            ShiroUser user1 = ShiroUtil.getShiroUser();
            modelMap.addAttribute("user_account",user1.getUserAccount());
            modelMap.addAttribute("user_name",user1.getUserName());
            return "redirect:/";
        }
        return "/login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, ModelMap modelMap){
        try{
            String account = user.getUserAccount();
            String password = user.getPassword();
            if(StringUtils.isNotBlank(account)){
                User authuser = userService.getByAccount(account);
                if(authuser != null){
                    UsernamePasswordToken token = new UsernamePasswordToken(account, password.toCharArray());
                    Subject shiroUser = SecurityUtils.getSubject();
                    token.setRememberMe(true);
                    shiroUser.login(token);
                    ShiroUser user1 = ShiroUtil.getShiroUser();
                    modelMap.addAttribute("user_account",user1.getUserAccount());
                    modelMap.addAttribute("user_name",user1.getUserName());
                }
            }
        }catch (Exception e){
            throw new SysRunException(e);
        }
        return "/back/index";
    }


    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(User user){
        try{
           user.setUserId(StringUtils.getRandomUUIDStr());
           user.setUserAccount(user.getUserName());
           userService.register(user);
        }catch (Exception e){
            throw new SysRunException(e);
        }
        return "/login";
    }

}
