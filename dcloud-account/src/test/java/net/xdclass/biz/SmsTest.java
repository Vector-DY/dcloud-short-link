package net.xdclass.biz;


import lombok.extern.slf4j.Slf4j;
import net.xdclass.AccountApplication;
import net.xdclass.component.SmsComponent;
import net.xdclass.config.SmsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= AccountApplication.class)
@Slf4j
public class SmsTest {

    @Autowired
    private SmsComponent smsComponent;

    @Autowired
    private SmsConfig smsConfig;

    @Test
    public void testSendSms(){
        for (int i = 0;i < 3;i++) {
            smsComponent.send("13258275592", smsConfig.getTemplateId(), "666888");
        }
    }

}
