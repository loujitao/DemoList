package com.steve.poi;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.CellRangeAddressList;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ImporTest {


    public static void main(String[] args) {
        String fileName="d:\\test.xls";
        try {
            importPerson(fileName);
//            download(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

     public  static void importPerson(String fileName) throws Exception {
         FileInputStream in=new FileInputStream(fileName);
         Workbook workbook = POIExcelUtil.getWorkBookByStream(in);
        final   Sheet sheet=workbook.getSheet("test");
        long time1=System.currentTimeMillis();

         ExecutorService es=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
         final List<Person> effetiveData=new ArrayList<>();
         for (int rownum = 1; rownum <= sheet.getLastRowNum(); rownum++) {
             final Integer num=rownum;
             //多线程锁
             final Lock lock=new ReentrantLock();
             //提出有效数据
             es.execute(new Runnable() {
                 @Override
                 public void run() {
                     lock.lock();
                     try {
                         getData(sheet,num,effetiveData);
                     } finally {
                         lock.unlock();
                     }
                 }
             });
         }
         es.shutdown();

//         for (int rownum = 1; rownum <= sheet.getLastRowNum(); rownum++) {
//             getData(sheet,rownum);
//         }

         //关闭线程池后判断所有任务是否都已完成
         while (!es.isTerminated()){
         }


         long time2=System.currentTimeMillis();
         System.out.println("总耗时："+(time2-time1));
         in.close();

         if (es.isTerminated()) {
             for (Person p : effetiveData) {
                 System.out.println(p);
             }
         }
     }

     public static  void  download(String fileName) throws  Exception{
        String filename="d:\\test.xls";
         FileInputStream is = new FileInputStream(fileName);
         Workbook wb = null;
         InputStream in=is;
         if(!is.markSupported()){
             in = new PushbackInputStream(is,8);
         }
         if (POIFSFileSystem.hasPOIFSHeader(in)) {       //Excel2003及以下版本
             wb = (Workbook) new HSSFWorkbook(in);
         }else if (POIXMLDocument.hasOOXMLHeader(in)) {      //Excel2007及以上版本
             wb = new XSSFWorkbook(in);
         }else{
             throw new IllegalArgumentException("你的Excel版本目前poi无法解析！");
         }
            //获得需要操作的sheet表
         Sheet   sheet=wb.createSheet("test");
         for(int i=1;i<15;i++){
             //获得需要操作的行
         Row row=sheet.createRow(i);
            //获取需要操作的单元格，并填充数据
         row.createCell(0).setCellValue("test"+i);
         row.createCell(1).setCellValue(new Random().nextInt(100));
         row.createCell(2).setCellValue(i%2==0?"男":"女");
         row.createCell(3).setCellValue(new Random().nextInt(10000));
         row.createCell(4).setCellValue(new Random().nextInt(100));
         }

         OutputStream out =new FileOutputStream(filename);
         wb.write(out);//保存Excel文件
         out.close();//关闭文件流
         in.close();
     }

    public static void getData(Sheet sheet,int rownum ,List<Person> list) {
        try {
            Row row = sheet.getRow(rownum);
            Person person=new Person();

            Cell cell0 = row.getCell(0); //name 姓名
            String name = POIExcelUtil.getCellData(cell0);
            person.setName(name);
            Thread.sleep(100);

            Cell cell1 = row.getCell(1);//第二列
            String age = POIExcelUtil.getCellData(cell1);//age 年龄
            person.setAge(Long.parseLong(age));
            Thread.sleep(100);

            Cell cell2 = row.getCell(2);//第三列
            String sex = POIExcelUtil.getCellData(cell2);//sex 性别
             if("男".equals(sex)||"女".equals(sex)){
                 person.setSex("女".equals(sex)?false:true);
             }else {
                 throw  new Exception("性别有误");
             }
            Thread.sleep(1000);

            Cell cell3 = row.getCell(3);//第四列
            String phote = POIExcelUtil.getCellData(cell3);//phone 电话号码
            person.setPhone(phote);
            Thread.sleep(100);

            Cell cell4 = row.getCell(4);//第五列
            String grade = POIExcelUtil.getCellData(cell4);//grade  成绩
             person.setGrade(Integer.parseInt(grade));
            Thread.sleep(100);

            list.add(person);

            System.out.println("第"+(rownum+1)+"行数据：name:"+name+",age:"+age+",sex:"+sex+",phote:"+phote+",grade:"+grade);
        } catch (Exception e) {
           // e.printStackTrace();
            System.out.println("==============错误行号："+rownum+",错误原因："+e.getLocalizedMessage());
        }
    }


}
