package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther Ashen One
 * @Date 2020/12/23
 */
@Controller
public class RESTController {
    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.GET)
    public String queryUser(@PathVariable("id") Integer id) {
        System.out.println("GET" + "---------" + id);
        return "success";
    }

    @RequestMapping(value = "/testREST", method = RequestMethod.POST)
    public String insertUser() {
        System.out.println("Post");
        return "success";
    }

    @RequestMapping(value = "/testREST", method = RequestMethod.PUT)
    public String updateUser() {
        System.out.println("Put");
        return "success";
    }

    @RequestMapping(value = "/testREST/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        System.out.println("DELETE---------"+id);
        return "success";
    }
}
