package net.xdclass.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.xdclass.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void testSend() {

        ResponseEntity<String> forEntity = restTemplate.getForEntity("https://pc.yiyouliao.com/microsoft/article/rivers/newsfeed/1531576099383816194/IC0EMQYW98AZCEN.html?channel=ceb01018b8194276895651098a3c7a5f", String.class);
        String body = forEntity.getBody();
        log.info(body);

    }
}
