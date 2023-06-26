package net.xdclass.component;

import com.google.errorprone.annotations.Var;
import lombok.extern.slf4j.Slf4j;
import net.xdclass.config.SmsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class SmsComponent {

    /**
     * 发送地址
     */
    private static final String URL_TEMPLATE = "https://jmsms.market.alicloudapi.com/sms/send?mobile=%s&templateId=%s&value=%s";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SmsConfig smsConfig;

    /**
     * 发送短信验证码
     * @param to
     * @param templateId
     * @param value
     */

    public void send(String to,String templateId,String value){

        String url = String.format(URL_TEMPLATE,to,templateId,value);
        HttpHeaders headers = new HttpHeaders();
        //最后在header中的格式(中间是英⽂空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.set("Authorization","APPCODE "+smsConfig.getAppCode());
        HttpEntity entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,entity,String.class);
        log.info("url={},body={}",url,response.getBody());
        if(response.getStatusCode().is2xxSuccessful()) {
            log.info("发送短信验证码成功");
        } else {
            log.info("发送短信验证码失败:{}",response.getBody());
        }
    }

}