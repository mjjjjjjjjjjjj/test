package service;

import bean.Order;
import bean.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private JedisPool jedisPool;

    public void addOrderInSql(Order order,String uuid){
        delOrderInRedis(uuid);
        order.setOrderTime(new Date());
        orderDao.addOrder(order);
    }

    public void delOrderInRedis(String uuid){
        Jedis jedis = jedisPool.getResource();
        jedis.del(uuid);
    }

    public void delOrder(int id){
        orderDao.delOrder(id);
    }

    public List<Order> findOrderByMeetId(int id){
        List<Order> orders = orderDao.findOrderByMeetId(id);
        if(orders.size() == 0){
            return null;
        }else {
            return orders;
        }
    }


    public Result isOverLap(Date start, Date end, List<Order> orders){
        Result result = new Result();
        int i = 0;
        if(orders == null){
            i = 0;
        }else {
            for(Order o:orders){
                if(start.getTime() >= o.getStartTime().getTime() && start.getTime() < o.getEndTime().getTime()){
                    i++;
                }else if(end.getTime() > o.getStartTime().getTime() && end.getTime() <= o.getEndTime().getTime()){
                    i++;
                }else if(start.getTime() == o.getStartTime().getTime() && end.getTime() == o.getEndTime().getTime()){
                    i++;
                }
            }
        }
        if(i > 0){
            result.setResult(false);
            result.setMessage("预定失败,已被占用");
        }else {
            result.setResult(true);
            result.setMessage("预定成功");
        }
        return result;
    }


    public String addOrderInRedis(Order order) {
        String uuid = UUID.randomUUID().toString();//激活码
        Jedis jedis = jedisPool.getResource();
        ObjectMapper o = new ObjectMapper();
        String orders = null;
        try {
            orders = o.writeValueAsString(order);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("addInRedis : "+orders);
        jedis.setex(uuid,90,orders);
//        将订单号返回
        return uuid;
    }

    public Order payOrder(String uuid){
        Jedis jedis = jedisPool.getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        String orderString = jedis.get(uuid);
        Order order = null;
        try {
            order = objectMapper.readValue(orderString, Order.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("payOrder : "+order);
        return order;
    }

    public List<Order> viewRedis(int mid){
//        Map map = new HashMap();
        List<Order> list = new ArrayList<>();
        Jedis jedis = jedisPool.getResource();
        ObjectMapper objectMapper = new ObjectMapper();
        Set<String> keys = jedis.keys("*");
        Iterator i = keys.iterator();
        while (i.hasNext()){
            String key = (String)i.next();
            Order order =null;
            try {
                order = objectMapper.readValue(jedis.get(key), Order.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(order.getMid() == mid){
                list.add(order);
            }
        }
        return list;
    }
}
