package dao;

import bean.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Insert("insert into orders values (null,#{mid},#{startTime},#{endTime},#{orderTime})")
    void addOrder(Order order);

    @Delete("delete from orders where id = #{id}")
    void delOrder(int id);

    @Select("select * from orders where mid = #{id}")
    List<Order> findOrderByMeetId(int id);
}
