package com.itsherman.web.javagenerator.web.controller;

import com.itsherman.commonweb.response.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Jeeper")
@RestController
@RequestMapping("/api/jeeper")
public class IndexController {

    @ApiOperation("测试")
    @GetMapping
    public ApiResponse<Void> index() {
        return ApiResponse.createSuccess();
    }
}
