package com.test;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.UUID;

/**
 * @auther Ashen One
 * @Date 2021/1/6
 */
@Controller
public class TestUploadAndDownController {

    @RequestMapping("/down")
    public ResponseEntity<byte[]> down(HttpSession session) throws IOException {
        String realPath = session.getServletContext().getRealPath("img");
        String finalPath = realPath + File.separator + "1.jpg";
        FileInputStream fileInputStream = new FileInputStream(finalPath);
        //available()获取输入流读取文件的最大字节
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        //设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attachment;filename=zzz.jpg");
        //设置响应状态
        HttpStatus ok = HttpStatus.OK;
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, httpHeaders, ok);
        return responseEntity;
    }

    @RequestMapping(value="/up", method= RequestMethod.POST)
    public String up(String desc, MultipartFile uploadFile, HttpSession session) throws IOException {
        //获取上传文件的名称
        String fileName = uploadFile.getOriginalFilename();
        String finalFileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."));
        String path = session.getServletContext().getRealPath("photo") + File.separator + finalFileName;
        File file = new File(path);
        uploadFile.transferTo(file);
        return "success";
    }

    @RequestMapping(value="/up_old", method=RequestMethod.POST)
    public String up_old(String desc, MultipartFile uploadFile, HttpSession session) throws IOException {
        //获取上传文件的名称
        String fileName = uploadFile.getOriginalFilename();
        String path = session.getServletContext().getRealPath("photo") + File.separator + fileName;
        //获取输入流
        InputStream is = uploadFile.getInputStream();
        //获取输出流
        File file = new File(path);
        OutputStream os = new FileOutputStream(file);
		/*int i = 0;
		while((i = is.read()) != -1) {
			os.write(i);
		}*/

		/*int i = 0;
		byte[] b = new byte[1024];
		while((i = is.read(b)) != -1) {
			os.write(b, 0, i);
		}*/
      
        os.close();
        is.close();
        return "success";
    }

}
