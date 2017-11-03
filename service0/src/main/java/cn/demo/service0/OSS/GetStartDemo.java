package cn.demo.service0.OSS;

import cn.g2link.storage.api.IStorageUtil;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * @author: chenhongwei
 * @data: Created in 上午9:59 2017/11/1
 * @version: 1.0
 */
public class GetStartDemo {

    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com/";
    private static String accessKeyId = "LTAImGQNrHKJO9Z8";
    private static String accessKeySecret = "rkcpdcbkrMovxGLvcOkb2bVWEChGeV";
    private static String bucketName = "ucenter-test";

    private static final Logger LOGGER = LoggerFactory.getLogger(GetStartDemo.class);

    @Autowired
    private IStorageUtil storageUtil;

    public static void main(String[] args) throws IOException {

//        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
//
//        if (!ossClient.doesBucketExist(bucketName)) {
//            System.out.println("----------------the bucketName is not exist----------------");
//            // 创建bucket，并设置bucket的权限为公开读
//            CreateBucketRequest request = new CreateBucketRequest(bucketName);
//            request.setCannedACL(CannedAccessControlList.PublicRead);
//            ossClient.createBucket(request);
//        }
//
//        // 设置要上传的文件
//        File target = new File("/Users/g2/Downloads/874aa55c0fd12aefd4b924a13d30de38.jpg");
//
//
//        // 设置下载的属性
//        ObjectMetadata objectMetadata = new ObjectMetadata();
//        objectMetadata.setCacheControl("no-cache");
//        objectMetadata.setHeader("Pragma", "no-cache");
//        objectMetadata.setContentDisposition(String.format("attachment; filename=%s", "test.jpg"));
//
//        Date expiration = new Date(System.currentTimeMillis() + 120L * 1000);
//        objectMetadata.setExpirationTime(null);
//        /*
//         * Upload an object to your bucket
//         */
//        System.out.println("Uploading a new object to OSS from a file\n");
//        InputStream inputStream = new FileInputStream(target);
//        String random = UUID.randomUUID().toString().replaceAll("-", "");
//        PutObjectResult putObjectResult = ossClient.putObject(bucketName, "testDate", inputStream, objectMetadata);
//
////        LOGGER.info("the result is: {}", getUri(ossClient, putObjectResult.getETag()));
//        LOGGER.info("the result is: {}", getUri(ossClient, "testDate"));



//        OSSObject ossObject = ossClient.getObject(bucketName, putObjectResult.getETag());
//        InputStream in = ossObject.getObjectContent();
//        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
//        int ch;
//        while ((ch = in.read()) != -1) {
//            swapStream.write(ch);
//        }
        // new BufferedOutputStream(swapStream).flush();
//        swapStream.write();

    }

    private static String getUri(OSSClient client, String etag) throws RuntimeException{
        if (StringUtils.isBlank(etag)) {
            return null;
        }

        Date expiration = new Date(System.currentTimeMillis() + 3600L * 1000 * 24 * 365 * 10);
        URL url = client.generatePresignedUrl(bucketName, etag, expiration);
        if (url != null) {
            return url.toString().replace("+","%2B");
        }
        return null;
    }
}
