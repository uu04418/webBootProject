package com.bootproject.sklweb.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bootproject.sklweb.common.APIResponse;
import com.bootproject.sklweb.common.CheckDataUtil;
import com.bootproject.sklweb.common.HandleData;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * @Description 通用上传方法支持单张图片上传 和多张同时上传
 * @author  uu04418
 * @date  2019年8月1日  下午6:31:51
 */

@RestController
@RequestMapping("/upload")
public class UploadController {
	
	public static final String ACCESS_KEY = "r8DLGf0BLmN3QjnAoSCe-PiYzNfARLQZD4BccI2i";

	public static final String SECRET_KEY = "o8llqqKfAMyd3BU86hGL-IPjtn25IGETLjoADIEl";
	
	public static final String gene_bucketName = "genealogy";
	
	public static final String return_path = "http://www.genealogy.zzw777.com/";
	
	static Auth auth = Auth.create(ACCESS_KEY,SECRET_KEY);
	static Configuration cfg = new Configuration(Zone.zone0());
	static UploadManager uploadManager = new UploadManager(cfg);
	
	
	/**
	 * 
	**@Desctription 文件上传
	**@author  uu04418
	**@date  2019年8月1日  下午6:32:33
	**@param contents 请求的数据集合
	**@return		返回图片列表 , 分割
	*
	 */
	@RequestMapping( "/imageUpload")
	public APIResponse videoUpload(MultipartFile [] contents  ) {
		if (CheckDataUtil.checkisEmpty(contents)) 
			return APIResponse.build(400, "请选择文件");
		String returnPath = "";
		for (int index = 0 ;index<contents.length;index++) {
			/***获取图片名称**/
			String originName = contents[index].getOriginalFilename();
			String lastName = originName.substring(originName.lastIndexOf("."), originName.length());
			// 设置上传的key
			String key = HandleData.generateKey() + lastName;
			// 上传到远程服务器
			doUpload(contents[index] ,key);
			// 设置返回的路径
			returnPath  += return_path + key +"," ;
		}
		if (CheckDataUtil.checkNotEmpty(returnPath)) 
			returnPath = returnPath.substring(0,returnPath.length()-1);
		return APIResponse.build(200, "图片上传成功" ,returnPath);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**视频上传*/
	@SuppressWarnings("unused")
	public static String doUpload (MultipartFile file , String key) {
		try {
			Response res  = uploadManager.put(file.getBytes(), key, getUpToken(gene_bucketName,key));
		} catch (QiniuException e) {
			Response r = e.response;
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}


	public static String getUpToken(String bucketName, String key) {
		StringMap putPolicy = new StringMap();
		putPolicy.put("insertOnly", 1);
		return auth.uploadToken(bucketName, key, 3600, putPolicy);

	}

}
