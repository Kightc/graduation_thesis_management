package usts.cs2020.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usts.cs2020.utils.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 *  后台登录管理
 *
 * @Author Kight
 * @Date 2023/6/22 20:42
 * @Version 1.0
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("/system/index")
public class IndexController {

    /**
     * 登录
     * @return
     */
    @PostMapping("login")
    public Result login() {
        Map<String, Object> map = new HashMap<>();
        map.put("token","admin");
        return Result.ok(map);
    }
    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("roles","[admin]");
        map.put("name","Kight");
        map.put("avatar","https://tse4-mm.cn.bing.net/th/id/OIP-C.QrD_0ltt0faRssPwbUeFXQAAAA?w=197&h=197&c=7&r=0&o=5&pid=1.7.jpg");
        return Result.ok(map);
    }
    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    public Result logout(){
        return Result.ok();
    }
}
