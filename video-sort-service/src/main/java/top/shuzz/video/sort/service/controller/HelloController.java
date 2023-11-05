package top.shuzz.video.sort.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.shuzz.video.sort.service.core.response.ResponseResult;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping
    public ResponseResult hello() {
        return ResponseResult.success();
    }
}
