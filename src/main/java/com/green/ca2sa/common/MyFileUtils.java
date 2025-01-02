package com.green.ca2sa.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Getter
@Component
public class MyFileUtils {
    private final String uploadPath;

    public MyFileUtils(@Value("${file.directory}") String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String makeFolders(String path) {
        File file = new File(uploadPath, path);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public String getExt(String fileName) {
        int lastIdx = fileName.lastIndexOf(".");
        return fileName.substring(lastIdx);
    }

    public String makeRandomFileName() {
        return UUID.randomUUID().toString();
    }

    public String makeRandomFileName(MultipartFile mf) {
        return mf == null ? null : makeRandomFileName() + getExt(mf.getOriginalFilename());
    }

    public boolean deleteFolder(String path, boolean delRootFolder) {
        File dir = new File(uploadPath, path);
        if (dir.exists() && dir.isDirectory()) {
            File[] includedFiles = dir.listFiles();
            if (includedFiles != null) {
                for (File file : includedFiles) {
                    if (file.isDirectory()) {
//                        Path filePath = Paths.get(file.getAbsolutePath());
//                        return deleteFolder(filePath.subpath(3, filePath.getNameCount()).toString(), true);
                        return deleteFolder(file.getPath(), true);
                    }
                    if (!file.delete()) {
                        return false;
                    }
                }
            }
            if (delRootFolder) {
                return dir.delete();
            }
        }
        return false;
    }

    public boolean deleteFile(String path) {
        File dir = new File(uploadPath, path);
        if (dir.exists() && dir.isDirectory()) {
            File[] includedFiles = dir.listFiles();
            if (includedFiles != null) {
                for (File file : includedFiles) {
                    if (file.isFile() && !file.delete()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }


    public void transferTo(MultipartFile mf, String path) throws IOException {
        File file = new File(uploadPath, path);
        mf.transferTo(file);
    }
}
