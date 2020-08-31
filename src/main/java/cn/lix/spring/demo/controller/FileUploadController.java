package cn.lix.spring.demo.controller;

import cn.lix.spring.demo.utils.LogUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;


@RestController
public class FileUploadController {

    private final String fileDir = "D:\\testFile";

    /**
     * 文件上传
     *
     * @return
     */
    @PostMapping("file/upload")
    public ResponseEntity upload(@RequestParam("file") MultipartFile file) {
        //  判断上传文件是否为空，若为空则返回错误信息
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            // 获取文件原名
            String originalFilename = file.getOriginalFilename();
            LogUtils.log().info(originalFilename);
            // 获取源文件前缀
            String fileNamePrefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            //获取源文件后缀
            String fileNameSuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            // 将源文件前缀之后加上时间戳避免重名
            String newFileNamePrefix = fileNamePrefix + new Date().getTime();
            // 得到上传后新文件的文件名
            String newFileName = newFileNamePrefix + fileNameSuffix;
            // 创建一个新的File对象用于存放上传的文件
            File fileNew = new File(fileDir + File.separator + newFileName);
            try {
                file.transferTo(fileNew);
                return ResponseEntity.ok().build();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }

    /**
     * 文件下载
     *
     * @return
     */
    @GetMapping("file/download")
    public ResponseEntity download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        //2.构建一个文件通过Paths工具类获取一个Path对象
        Path path = Paths.get(fileDir + File.separator, fileName);
        //判断文件是否存在
        if (Files.exists(path)) {
            //存在则下载
            //通过response设定他的响应类型
            //4.获取文件的后缀名
            String fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            // 5.设置contentType ,只有指定contentType才能下载
            response.setContentType("application/" + fileSuffix);
            // 6.添加http头信息
            // 因为fileName的编码格式是UTF-8 但是http头信息只识别 ISO8859-1 的编码格式
            // 因此要对fileName重新编码
            try {
                response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            // 7.使用  Path 和response输出流将文件输出到浏览器
            try {
                Files.copy(path, response.getOutputStream());
                return ResponseEntity.ok().build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }


}
