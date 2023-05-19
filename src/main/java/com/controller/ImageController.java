package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.Entity.UserBeanFileUploding;

@Controller
public class ImageController {

	@GetMapping("/newprofile")
	public String newProfile()
	{
		System.out.println("Hello");
		return "NewProfile";
	}
	
	@ PostMapping("/saveprofile")
	public String saveProfile(@RequestParam("profile") MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		String path = "C:\\STSWorkSpace\\SpringBoot_Angular\\src\\main\\resources\\static\\imsges\\";
		
		try
		{
		   File localFile = new File(path,file.getOriginalFilename());	
		   byte b[] = file.getBytes();
		   FileOutputStream fos = new FileOutputStream(localFile);
		   fos.write(b);
		   fos.close();
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();		}
		
		return "NewProfile";
		
		
	}
	
	@GetMapping("/newprofile2")
	public String newProfile2()
	{
		System.out.println("Hello");
		return "NewProfile2";
	}
	
	@PostMapping("/saveprofile2")
	public String saveProfile2(UserBeanFileUploding userBean)
	{
		
		Integer userId = (int)(Math.random()*100000);
		String path = "C:\\STSWorkSpace\\SpringBoot_Angular\\src\\main\\resources\\static\\imsges\\";
		
		File dir = new File(path,userId+"");
		dir.mkdir();
		
		MultipartFile file = userBean.getProfile();
		
		System.out.println("Firstname =>"+userBean.getFirstname());
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		
		
		try
		{
			Date d = new Date();
		   File localFile = new File(path,d.getTime()+file.getOriginalFilename());	
		   byte b[] = file.getBytes();
		   FileOutputStream fos = new FileOutputStream(localFile);
		   fos.write(b);
		   fos.close();
		   
		}
		catch(Exception e)
		{
			e.printStackTrace();		}
		
		return "NewProfile2";
		
		
	}
 }
