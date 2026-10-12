package com.rgukt.evs.controllers;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;

import org.springframework.stereotype.Controller;

@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize=124532)
@Controller
public class Upload {
}
