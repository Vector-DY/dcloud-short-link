package net.xdclass.controller;

import net.xdclass.service.NotifyService;
import net.xdclass.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account/v1")
public class NotifyController {
    @Autowired
    private NotifyService notifyService;

    /**
     * 测试发送验证码接口--主要用于对比优化前后区别
     * @return
     */
    @RequestMapping("send_code")
    public JsonData sendCode(){
        notifyService.testSend();
        return JsonData.buildSuccess();
    }
}
