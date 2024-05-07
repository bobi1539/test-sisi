package tes.sis.testsisi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tes.sis.testsisi.constant.Endpoint;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(Endpoint.REPORT)
public class ReportController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "dunia");
        return map;
    }
}
