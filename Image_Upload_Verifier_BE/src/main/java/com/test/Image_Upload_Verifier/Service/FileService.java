package com.test.Image_Upload_Verifier.Service;

import com.test.Image_Upload_Verifier.Model.LanIdStatus;
import com.test.Image_Upload_Verifier.Utility.ExcelReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Service
public class FileService {
    public List<LanIdStatus> verifyImages(MultipartFile excelFile, String imagePath) throws Exception {
        List<String> lanIds = ExcelReader.readLanIds(excelFile);
        File folder = new File(imagePath);
        File[] files = folder.listFiles();

        List<LanIdStatus> statuses = new ArrayList<>();
        for (String lanId : lanIds) {
            boolean imageExists = false;
            if (files != null) {
                for (File file : files) {
                    if (file.getName().startsWith(lanId)) {
                        imageExists = true;
                        break;
                    }
                }
            }
            LanIdStatus status = new LanIdStatus();
            status.setLanId(lanId);
            status.setImageUploaded(imageExists);
            statuses.add(status);
        }
        return statuses;
    }
}
