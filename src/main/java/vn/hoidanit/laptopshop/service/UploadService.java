package vn.hoidanit.laptopshop.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;

@Service
public class UploadService {
    private final ServletContext servletContext;

    public UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) throws IOException {
        byte[] bytes = file.getBytes();
        // return dir webapp

        String rootPath = this.servletContext.getRealPath("/content/images");

        File dir = new File(rootPath + File.separator + targetFolder);
        // separator: "/" -> /content/images/avatar
        if (!dir.exists())
            dir.mkdirs();

        String postfix_path = "";

        if (bytes.length == 0) {
            postfix_path = "defaultImg.jpeg";
        } else {
            postfix_path = System.currentTimeMillis() + "-" + UUID.randomUUID() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + postfix_path);
            try (BufferedOutputStream stream = new BufferedOutputStream(
                    new FileOutputStream(serverFile))) {
                stream.write(bytes);
                stream.close();
            }
        }
        // avoid the similar files
        return postfix_path;
    }

}
