package controller;

import bean.Order;
import bean.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/judge")
    public String judgeReservationTime(String mid, String startTime, String endTime, ModelMap m) throws ParseException {
//      将参数封装到Order对象中
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date start = sdf.parse(startTime);
        Date end = sdf.parse(endTime);
        Order order = new Order();
        order.setMid(Integer.parseInt(mid));
        order.setStartTime(start);
        order.setEndTime(end);

//      判断时间与数据库中的订单是否冲突
        List<Order> orderByMeetId = orderService.findOrderByMeetId(order.getMid());
        Result result1 = orderService.isOverLap(order.getStartTime(), order.getEndTime(), orderByMeetId);

//        判断时间与redis库中的订单是否冲突
        List<Order> orderByRedis = orderService.viewRedis(Integer.parseInt(mid));
        Result result2 = orderService.isOverLap(order.getStartTime(), order.getEndTime(), orderByRedis);

//      若时间不冲突,生成订单并存入redis中
        if(result1.isResult() && result2.isResult()){
            String uuid = orderService.addOrderInRedis(order);
            m.addAttribute("uuid",uuid);
            return "/pay.jsp";
        }else {
//          若时间冲突,返回错误界面,重新进行预订
            Result result = new Result();
            result.setResult(false);
            result.setMessage("订单已存在或有其它用户正在预订该时间段");
            m.addAttribute("result",result1);
            return "/result.jsp";
        }
    }

    @RequestMapping("/genOrder")
    public String generateOrder(HttpServletRequest req,String uuid){
        //支付并将订单存入数据库中
        Order order = orderService.payOrder(uuid);
        orderService.addOrderInSql(order,uuid);
        return "/result.jsp";
    }

    @RequestMapping("/dele")
    public String delOrder(HttpServletRequest req,String uuid) throws ParseException {
        orderService.delOrderInRedis(uuid);
        return "/result.jsp";
    }

    @RequestMapping("/redis")
    public String viewRedis(HttpServletRequest req,String uuid){
        List<Order> list = orderService.viewRedis(Integer.parseInt(uuid));
        System.out.println(list);
        return "/result.jsp";
    }
}
