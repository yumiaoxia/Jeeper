package com.itsherman.web.javagenerator.web.controller;

import com.itsherman.web.common.request.ApiRequest;
import com.itsherman.web.common.response.ApiResponse;
import com.itsherman.web.javagenerator.web.application.CodingApplicationService;
import com.itsherman.web.javagenerator.web.command.ReferencePackages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Coding")
@RestController
@RequestMapping("/api/coding")
public class CodingController {

    @Autowired
    private CodingApplicationService codingApplicationService;

    @ApiOperation("查找匹配类名列表")
    @GetMapping("/{name}")
    public ApiResponse<List<String>> findMatchClassName(@PathVariable("name") String name){
        List<String> result = codingApplicationService.findMatchClassName(name);
        return ApiResponse.createSuccess(result);
    }

    @ApiOperation("查询所有关联包名")
    @GetMapping("/listPackages")
    public ApiResponse<List<String>> listReferencePackages(){
       return ApiResponse.createSuccess(codingApplicationService.listReferencePackages());
    }

    @ApiOperation("添加关联包名")
    @PostMapping("/addReferencePackages")
    public ApiResponse<Void> addReferencePackages(@RequestBody @Validated ApiRequest<ReferencePackages> request){
        codingApplicationService.addReferencePackages(request.getCommand());
        return ApiResponse.createSuccess();
    }

    @ApiOperation("列举所有报名")
    @GetMapping("/listAllPackages")
    public ApiResponse<List<String>> listAllPackages(){
        return ApiResponse.createSuccess(codingApplicationService.listAllPackages());
    }
}
