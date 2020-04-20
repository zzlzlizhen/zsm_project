package com.zsm.personplay.qrcode;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;
import org.springframework.boot.autoconfigure.web.ServerProperties;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * created by zsm on 2020/4/20
 * 一维码二维码生成跟解析
 */
public class QrCodeTest {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;
    private static final String FORMAT = "png"; //图片格式
    public static void main(String[] args) {
        generateCode(new File("1dcode.png"),"123456789012",500,250);
        readCode(new File("1dcode.png"));
        generateQRCode(new File("2dcode.png"),"www.baidu.com");
        readQRCode(new File("2dcode.png"));
    }

    /**
     * 生成二维码，并且把二维码保存为一张图片
     * @param file
     * @param code
     * @param width
     * @param height
     */
    private static void generateCode(File file, String code, int width, int height) {
        //定义位图矩阵BitMatrix
        BitMatrix matrix = null;
        try {
            //使用code_128格式进行编码生成100*25的条形码
            MultiFormatWriter writer = new MultiFormatWriter();
            matrix = writer.encode(code, BarcodeFormat.CODE_128,width,height,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        //将位图矩阵BitMatrix保存为图片
        try(FileOutputStream outputStream = new FileOutputStream(file)) {
            ImageIO.write(MatrixToImageWriter.toBufferedImage(matrix),"png",outputStream);
            outputStream.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void readCode(File file){
        try {
            BufferedImage image = ImageIO.read(file);
            if(image == null){
                return;
            }
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(source));
            Map<DecodeHintType,Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET,"GBK");
            hints.put(DecodeHintType.PURE_BARCODE,Boolean.TRUE);
            hints.put(DecodeHintType.TRY_HARDER,Boolean.TRUE);

            Result result = new MultiFormatReader().decode(binaryBitmap,hints);
            System.out.println("条形码内容为：" + result.getText());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void generateQRCode(File file,String content){
        //定义二维码参数
        Map<EncodeHintType,Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET,"utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);//设置容错等级
        hints.put(EncodeHintType.MARGIN,2);//设置边距默认值
        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE,WIDTH,HEIGHT,hints);
            Path path = file.toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, FORMAT,path);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void readQRCode(File file){
        MultiFormatReader reader = new MultiFormatReader();
        try {
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            Map<DecodeHintType,Object> hints = new HashMap<>();
            hints.put(DecodeHintType.CHARACTER_SET,"utf-8");//设置编码格式
            Result result = reader.decode(binaryBitmap,hints);
            System.out.println("解析结果为"+ result.toString());
            System.out.println("二维码格式"+ result.getBarcodeFormat());
            System.out.println("二维码文本内容"+ result.getText());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
