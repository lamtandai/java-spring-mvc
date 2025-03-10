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

    public String handleSaveUploadFile(MultipartFile file, String targetFolder) throws IOException{
        byte[] bytes = file.getBytes();
            // return dir webapp
            String rootPath = this.servletContext.getRealPath("/content/images");

            File dir = new File(rootPath + File.separator + targetFolder);
            // separator: "/" -> /content/images/avatar
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            String prefix_name = System.currentTimeMillis() + "-"+ UUID.randomUUID() + "-" + file.getOriginalFilename();
            File serverFile = new File(dir.getAbsolutePath() + File.separator + prefix_name);
            // avoid the similar files
        try (BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile))) {
            stream.write(bytes);
        }
        return prefix_name;
    }

}
