package dao;

import bean.Test;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {

    @Insert("insert into test values (#{a},#{b})")
    void addTest(Test t);
}
