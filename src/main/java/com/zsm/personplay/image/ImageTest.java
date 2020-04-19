package com.zsm.personplay.image;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ImageTest {
    public static void main(String[] args) throws Exception{
        readAndWrite();
        readComparison();
        imageCorp("G:\\grenzhenghe\\zsm_project\\good.jpg","G:\\grenzhenghe\\zsm_project\\good1.jpg",200,200,100,100,"jpg","jpg");
    }
    public static void readAndWrite() throws Exception{
        BufferedImage image = ImageIO.read(new File("G:\\grenzhenghe\\zsm_project\\good.jpg"));
        System.out.println("图片宽：" + image.getWidth());
        System.out.println("图片高：" + image.getHeight());
        ImageIO.write(image,"jpg",new File("G:\\grenzhenghe\\zsm_project\\test.jpg"));
    }

    /**
     * 加载速度测试
     * @throws Exception
     */
    public static void readComparison() throws Exception{
        System.out.println("加速度测试-----");
        Long starTime = System.nanoTime();
        BufferedImage image = ImageIO.read(new File("G:\\grenzhenghe\\zsm_project\\good.jpg"));
        System.out.println("图片宽：" + image.getWidth());
        System.out.println("图片高：" + image.getHeight());
        Long endTime = System.nanoTime();
        System.out.println((endTime-starTime)/1000000 + "毫秒");

        //指定用jpg Reader来加载，速度会加快
        starTime = System.nanoTime();
        Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("jpg");
        ImageReader reader = (ImageReader)readers.next();
        System.out.println(reader.getClass().getName());
        ImageInputStream lis = ImageIO.createImageInputStream(new File("G:\\grenzhenghe\\zsm_project\\good.jpg"));
        reader.setInput(lis,true);
        System.out.println("图片宽：" + reader.getWidth(0));
        System.out.println("图片高：" + reader.getHeight(0));
        endTime = System.nanoTime();
        System.out.println((endTime - starTime)/1000000 + "毫秒");
    }
    //拆解图片
    /**
     * corpImage 将原始图片文件一个切割矩形，并输出到目标图片文件
     * @parm fromPath 原始图片
     * @parm toPath 目标图片
     * @parm x 坐标起点x
     * @parm y 坐标起点y
     * @parm width 矩形宽度
     * @parm height 矩形高度
     * @parm readImageFormat 原始文件格式
     * @parm writeImageFormat 目标文件格式
     * @throws Exception
     */
    public static void imageCorp(String fromPath,String toPath,int x, int y, int width, int height,String readImageFormat,String writeImageFormat) throws Exception{
        FileInputStream fis = null;
        ImageInputStream iis = null;
        try {
            /**
             * 读取原始图片文件
             */
            fis = new FileInputStream(fromPath);
            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName(readImageFormat);
            ImageReader reader = it.next();
            iis = ImageIO.createImageInputStream(fis);
            reader.setInput(iis,true);
            /**
             * 定义一个矩形并放入切割参数中
             */
            ImageReadParam param = reader.getDefaultReadParam();
            Rectangle rectangle = new Rectangle(x,y,width,height);
            param.setSourceRegion(rectangle);
            /**
             * 从源文件读取一个矩形大小的图像
             */
            BufferedImage bi = reader.read(0,param);

            //写入到目标文件
            ImageIO.write(bi,writeImageFormat,new File(toPath));
        }finally {
            fis.close();
            iis.close();
        }
    }
}
