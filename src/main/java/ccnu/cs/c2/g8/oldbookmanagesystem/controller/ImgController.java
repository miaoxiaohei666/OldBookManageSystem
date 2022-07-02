package ccnu.cs.c2.g8.oldbookmanagesystem.controller;

import ccnu.cs.c2.g8.oldbookmanagesystem.data.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@ResponseBody
public class ImgController {

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public Book submit(MultipartFile file, Book book){
        String filename = file.getOriginalFilename();
        String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img";
        if (!new File(filePath).exists()){
            new File(filePath).mkdirs();
        }
        File dest = new File(filePath + File.separator + book.getBno() +"_"+filename);
        try {
            file.transferTo(dest);
        }catch (Exception e){
            e.printStackTrace();
        }
        book.setBpicture( (book.getBno()+"_"+filename));
        return book;
    }
}