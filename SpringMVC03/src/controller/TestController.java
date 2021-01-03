package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther Ashen One
 * @Date 2020/12/29
 */
@Controller
public class TestController {
    /**
     * ∨iew作用：处理模型数据，实现页面跳转（转发，重定向）
     * View类型
     *      InternalResourceView：转发视图
     *      JstlView：转发视图
     *      RedirectView：重定向视图
     * @return
     */

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloGet() {
        System.out.println("hello");
        return "redirect:/index.jsp";
        // return "success";
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(String username){
        System.out.println(username);
        return "success";
    }


}
