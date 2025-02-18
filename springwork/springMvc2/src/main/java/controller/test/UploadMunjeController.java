package controller.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import data.dto.FilenameChange;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UploadMunjeController {
	@GetMapping("/munjeupload1")
	public String munje1() {
		return "uploadmunje/munje1";
	}
	
	@PostMapping("/munje1process")
	@ResponseBody
	public Map<String, String> upload1(HttpServletRequest request,
			@RequestParam String subject,
			@RequestParam("upload") MultipartFile upload) {
		Map<String, String> map = new HashMap<>();
		
		String uploadPath = request.getSession().getServletContext().getRealPath("/save");
		String uploadFile = FilenameChange.getDateChangeFileName(upload.getOriginalFilename());
		
		try {
			upload.transferTo(new File(uploadPath+"/"+uploadFile));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		map.put("subject", subject);
		map.put("photo", uploadFile);
		
		return map;
	}
	
	@GetMapping("/munjeupload2")
	public String munje2() {
		return "uploadmunje/munje2";
	}
	
	@PostMapping("/munje2process")
	public String multiUpload(Model model, HttpServletRequest request,
			@RequestParam String title,
			@RequestParam("upload") List<MultipartFile> uploadList) {
		String uploadFolder = request.getSession().getServletContext().getRealPath("/save");
		
		List<String> list = new Vector<>();
		
		for(MultipartFile mf : uploadList) {
			String uploadFile = FilenameChange.getRandomChangeFileName(mf.getOriginalFilename());

			try {
				mf.transferTo(new File(uploadFolder+"/"+uploadFile));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
			list.add(uploadFile);
		}
		
		model.addAttribute("title", title);
		model.addAttribute("list", list);
		
		return "uploadmunje/munje2resultview";
	}
	
}
