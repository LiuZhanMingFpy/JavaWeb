package com.example.demo.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping("/saveImage")
	public String saveImage(@RequestParam("file")MultipartFile file) throws IllegalStateException, IOException {
		String filname = file.getOriginalFilename();
		String path = ResourceUtils.getURL("classpath:").getPath() + "static/upload";
		System.out.println(path);
		File dest = new File(path +"/"+filname);
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}
		file.transferTo(dest);
		return "redirect /index.html";
	}
}
