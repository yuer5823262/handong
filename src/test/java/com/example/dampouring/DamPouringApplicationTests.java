package com.example.dampouring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@SpringBootTest
class DamPouringApplicationTests {

    public static void main(String[] args)
    {
        AsyncService asyncService = new AsyncService();
        int count = 10;
        for (int i = 0; i < count; i++) {
            asyncService.doSomething("index = " + i);
        }
        System.out.println("sadadasdzczdsa");
    }

}

class AsyncService {
    // 指定使用beanname为doSomethingExecutor的线程池
    @Async("doSomethingExecutor")
    public String doSomething(String message) {
        System.out.println("do something, message="+message);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("do something error: "+e);
        }
        return message;
    }
}
