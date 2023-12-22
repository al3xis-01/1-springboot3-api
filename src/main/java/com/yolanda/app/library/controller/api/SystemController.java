package com.yolanda.app.library.controller.api;

import com.yolanda.app.library.util.SystemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/System")
public class SystemController {

    private final SystemService systemService;

}
