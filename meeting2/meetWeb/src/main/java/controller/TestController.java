package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.TestService;
import util.test1;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;


    @RequestMapping("/new")
    public void newCodeImg(){
        test1.createQrCode("http://192.168.2.107:8080/test/test", "D:\\", "code.jpg");
    }

    @RequestMapping("/test")
    public void addTest(){
        testService.addTest();
    }

}
