package com.ScuSoftware.Factorio.controller;

import com.ScuSoftware.Factorio.dao.AnnounceMapper;
import com.ScuSoftware.Factorio.dto.Response;
import com.ScuSoftware.Factorio.model.Announce;
import com.ScuSoftware.Factorio.service.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("Announce/")
public class AnnounceController {

    private AnnounceService announceService;
    @Autowired
    public AnnounceController(AnnounceService announceService){
        this.announceService = announceService;
    }
    @GetMapping("list")
    public Response getAllAnnounces(HttpSession session){
        System.out.println("被请求");
        return new Response(200,announceService.getAllAnnounce());
    }
}
