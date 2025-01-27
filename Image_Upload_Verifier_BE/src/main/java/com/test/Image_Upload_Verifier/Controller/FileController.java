package com.test.Image_Upload_Verifier.Controller;

import com.test.Image_Upload_Verifier.Model.LanIdStatus;
import com.test.Image_Upload_Verifier.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:4200")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/verify")
    public List<LanIdStatus> verifyImages(@RequestParam("file") MultipartFile file,
                                          @RequestParam("path") String path) throws Exception {
        return fileService.verifyImages(file, path);
    }
}
