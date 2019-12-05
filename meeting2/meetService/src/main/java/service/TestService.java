package service;

import bean.Test;
import dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestDao testDao;

    public void addTest(){
        Test test = new Test();
        test.setA("haha");
        test.setB("hoho");
        testDao.addTest(test);
    }
}
