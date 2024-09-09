package com.BookProject.Control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.BookProject.DTO.BkDTO;
import com.BookProject.Service.BkService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LibraryController {

    private final BkService bkService;
    private static final String IMAGE_DIR = "C:/img/";
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/bookindex")
    public String book(Model model) {
        // 등록된 도서 목록을 조회하여 모델에 추가
        List<BkDTO> bookList = bkService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "book/bookindex";
    }

    @GetMapping("/search")
    public String search() {
        return "book/search";
    }

    @GetMapping("/write")
    public String write(Model model) {
    	BkDTO bkDTO = new BkDTO();
    	model.addAttribute("BkDTO", bkDTO);
        return "book/write";
    }

    @PostMapping("/bookindex")
    public String bookwrite(BkDTO bkDTO, Model model) {
        // Service를 사용하여 DTO를 DAO로 넘깁
        bkService.saveBook(bkDTO);
        return "redirect:/bookindex";
    }
    
    @PostMapping("/write")
    public String bookwrite(@ModelAttribute BkDTO bkDTO, Model model, 
                            @RequestParam("bimg") MultipartFile bimg) {
        if (!bimg.isEmpty()) {
            try {
                // 이미지를 지정된 디렉토리에 저장
                String fileName = bimg.getOriginalFilename();
                Path imagePath = Paths.get(IMAGE_DIR, fileName);
                Files.createDirectories(imagePath.getParent());
                bimg.transferTo(imagePath.toFile());

                // DTO에 이미지 URL 설정 (파일명 사용)
                bkDTO.setBurl(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // 오류 처리 (예: 모델에 오류 메시지 추가)
                model.addAttribute("errorMessage", "이미지 업로드에 실패했습니다. 다시 시도해 주세요.");
                return "book/write"; // 오류 발생 시 다시 작성 페이지로 이동
            }
        }

        // Service를 사용하여 DTO를 DAO로 넘김
        bkService.saveBook(bkDTO);
        return "redirect:/bookindex";
    }
    
    @PostMapping("/update")
    public String update(@ModelAttribute BkDTO bkDTO, Model model, @RequestParam("bimg") MultipartFile bimg) {
    	if (!bimg.isEmpty()) {
            try {
                // 이미지를 지정된 디렉토리에 저장
                String fileName = bimg.getOriginalFilename();
                Path imagePath = Paths.get(IMAGE_DIR, fileName);
                Files.createDirectories(imagePath.getParent());
                bimg.transferTo(imagePath.toFile());

                // DTO에 이미지 URL 설정 (파일명 사용)
                bkDTO.setBurl(fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // 오류 처리 (예: 모델에 오류 메시지 추가)
                model.addAttribute("errorMessage", "이미지 업로드에 실패했습니다. 다시 시도해 주세요.");
                return "book/write"; // 오류 발생 시 다시 작성 페이지로 이동
            }
        }
    	
        bkService.update(bkDTO);
        return "redirect:/bookindex/" + bkDTO.getBid();
    }


    @GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model){
		BkDTO bkDTO=bkService.findById(id);
		model.addAttribute("bkDTO",bkDTO);
		return "book/view";
	}
    
    @GetMapping("/delete")
    public String delete(@RequestParam("bid") int bid) {
        bkService.delete(bid);
        return "redirect:/bookindex";
    }
    
//    @PostMapping("/update")
//    public String update(@ModelAttribute BkDTO bkDTO, @RequestParam("bimg") MultipartFile file) {
//        if (!file.isEmpty()) {
//            String fileName = file.getOriginalFilename();
//            String savePath = "C:/img/" + fileName;
//            try {
//                file.transferTo(new File(savePath));
//                bkDTO.setBurl(savePath);
//            } catch (IOException e) {
//                e.printStackTrace();
//                
//            }
//        }
//        bkService.update(bkDTO);
//        return "redirect:/bookindex/" + bkDTO.getBid();
//    }
//   
    
 
}
