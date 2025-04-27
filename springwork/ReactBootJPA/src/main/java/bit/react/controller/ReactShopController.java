package bit.react.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.react.data.ShopDto;
import bit.react.data.ShopEntity;
import bit.react.repository.ShopDao;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/react")
public class ReactShopController {
	
	private final ShopDao shopDao;
	private final NcpObjectStorageService storageService;
	
	private String bucketName = "bitcamp-bucket-139";
	private String folderName = "jpashop";
	private String uploadFilename;
	
	@PostMapping("/addshop")
	public String addShop(@RequestBody ShopDto dto) { // json 데이터를 java 객체로 변환
		ShopEntity shopEntity = ShopEntity.builder()
				.sangpum(dto.getSangpum())
				.price(dto.getPrice())
				.sangguip(dto.getSangguip())
				.color(dto.getColor())
				.photo(dto.getPhoto())
				.build();
		// db 저장
		shopDao.insertShop(shopEntity);
		uploadFilename = null;
		return "insert ok!";
	}
	
	// 사진 따로 업로드
//	swagger 테스트용
//	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PostMapping("/upload")
	public String uploadPhoto(@RequestParam("upload") MultipartFile upload) {
		System.out.println("업로드한 파일명 : "+upload.getOriginalFilename());
		if(uploadFilename != null)
			storageService.deleteFile(bucketName, folderName, uploadFilename); // 이전 업로드 사진 지우기
		// 네이버 클라우드 업로드
		uploadFilename = storageService.uploadFile(bucketName, folderName, upload);
		return uploadFilename;
	}
	
	@GetMapping("/detail")
	public ShopEntity getSelectData(@RequestParam("num") int num) {
		return shopDao.getData(num);
	}
	
	@GetMapping("/shoplist")
	public List<ShopEntity> selectAll() {
		return shopDao.getAllShops();
	}
	
	@DeleteMapping("/shopdelete")
	public String deleteShop(@RequestParam("num") int num) {
		// db 전에 스토리지 사진 삭제
		String photoName = shopDao.getData(num).getPhoto();
		storageService.deleteFile(bucketName, folderName, photoName);
		
		shopDao.deleteShop(num);
		
		return "delete ok!!";
	}
	
	
}
