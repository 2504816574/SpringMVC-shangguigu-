package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther Ashen One
 * @Date 2020/12/22
 */
@Controller
// @RequestMapping("/mvc")
public class TestController {
    /**
     * @RequestMapping:设置请求映射，把请求和控制层中的方法设置映射关系
     * 当请求路径和@RequestMapping的value属性值一致时，则该注解所标注的方法即为处理请求的方法
     *
     * @RequestMapping可以加在类上，也可以加在方法上
     * 若类和方法上都加得有，应该一层一层的访问，先访问类，在访问类中的方法
     *
     * method:用来设置请求方式，只有客户端发送请求的方式和method的值一致，才能处理请求
     * 请求方式:GET 查询  POST 添加  PUT  修改  DELETE  删除
     * params:用来设置客户端传到服务器的数据，支持表达式
     * username !username username=admin username!=admin
     * headers:用来设置请求头信息，所发送的请求的请求头信息一定要和headers属性中所设置的一致
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloGet() {
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String helloPost() {
        System.out.println("helloP");
        return "success";
    }
    @RequestMapping(value = "/ok", params = {"username"})
    public String ok() {
        System.out.println("ok");
        return "success";
    }


    /**
     * springMVC支持Ant方式的请求路径
     * 在Ant中，有3中匹配符
     * *:任意字符
     * ?:任意一个字符
     * **:任意多层目录
     */
    @RequestMapping(value="/*/ /**/testAnt")
    public String testAnt() {
        System.out.println("SUCCESS:testAnt");
        return "success";
    }


    /**
     * 以前：localhost:8080/springMVC02/testREST?id=1001&username=admin
     * 现在：localhost:8080/springMVC02/testREST/1001/admin
     */
    @RequestMapping("/testREST/{id}/{username}")
    public String testREST(@PathVariable("id")Integer id, @PathVariable("username")String username) {
        System.out.println("id:"+id+",username="+username);
        return "success";
    }
}
