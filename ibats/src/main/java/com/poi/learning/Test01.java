package com.poi.learning;

import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.record.cf.FontFormatting;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Test01 {

    public static void main(String[] args) throws IOException {
        String filePath="d:\\excltest\\test01.xls";//文件路径
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
        HSSFSheet sheet = workbook.createSheet();//创建工作表(Sheet)
        sheet = workbook.createSheet("Test");//创建工作表(Sheet)
//        cellTest(workbook);
//        cellTest2(workbook);
//        cellTest3(workbook);
//        fileTest(workbook);
//        pizhuTest(sheet);
//        topAndButtom(sheet);
//        fixedTest(workbook);
//        selectTest(workbook);
//        linkedTest(workbook);
//            borderTest(workbook);
//            fontTest(workbook);
//            cellSizeTest(workbook);
//            backgroudTest(workbook);
//            LineTest(workbook);
//            spaceTest(workbook);
        try {
            imageTest(workbook);
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);//保存Excel文件
        out.close();//关闭文件流
        System.out.println("OK!");
    }
    /**
     * @Author Loujitao
     * @Date 2018/7/2
     * @Time  15:08
     * @Description: 操作单元格以及格式转换
     */
    public static void cellTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//创建工作表(Sheet)
        HSSFRow row = sheet.createRow(0);// 创建行,从0开始
        HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
        cell.setCellValue("stevetao");// 设置单元格内容
        row.createCell(1).setCellValue(false);// 设置单元格内容
        row.createCell(2).setCellValue(new Date());// 设置单元格内容
        row.createCell(3).setCellValue(12.345);// 设置单元格内容
//        设置日期格式--使用Excel内嵌的格式
        HSSFCellStyle style=workbook.createCellStyle();
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        cell=row.createCell(4);
        cell.setCellValue(new Date());
        cell.setCellStyle(style);
        //设置保留2位小数--使用Excel内嵌的格式
        cell=row.createCell(5);
        cell.setCellValue(12.3456789);
        style=workbook.createCellStyle();//getBuiltinFormat()是静态方法
        style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
        cell.setCellStyle(style);
        //设置货币格式--使用自定义的格式
        cell=row.createCell(6);
        cell.setCellValue(12345.6789);
        style=workbook.createCellStyle();//getFormat()是实例方法
        style.setDataFormat(workbook.createDataFormat().getFormat("￥#,##0"));
        cell.setCellStyle(style);
//设置百分比格式--使用自定义的格式
        cell=row.createCell(7);
        cell.setCellValue(0.123456789);
        style=workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("0.00%"));
        cell.setCellStyle(style);
//设置中文大写格式--使用自定义的格式
        cell=row.createCell(8);
        cell.setCellValue(12345);
        style=workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("[DbNum2][$-804]0"));
        cell.setCellStyle(style);
//设置科学计数法格式--使用自定义的格式
        cell=row.createCell(9);
        cell.setCellValue(12345);
        style=workbook.createCellStyle();
        style.setDataFormat(workbook.createDataFormat().getFormat("0.00E+00"));
        cell.setCellStyle(style);
    }

    public static  void cellTest2(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//创建工作表(Sheet)
        HSSFRow row = sheet.createRow(0);// 创建行,从0开始
        HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
        //合并列
        cell.setCellValue("合并列");
        CellRangeAddress region=new CellRangeAddress(0, 0, 0, 5);
        sheet.addMergedRegion(region);
        //合并行
        cell=row.createCell(6);
        cell.setCellValue("合并行");
        region=new CellRangeAddress(0, 5, 6, 6);
        sheet.addMergedRegion(region);
    }

    public static  void cellTest3(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//创建工作表(Sheet)
        HSSFRow row = sheet.createRow(0);// 创建行,从0开始
        HSSFCell cell=row.createCell(0);
        cell.setCellValue("单元格对齐");
        HSSFCellStyle style=workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        style.setWrapText(true);//自动换行
        style.setIndention((short)5);//缩进
        style.setRotation((short)60);//文本旋转，这里的取值是从-90到90，而不是0-180度。
        cell.setCellStyle(style);
//        水平对齐相关参数
//        如果是左侧对齐就是 HSSFCellStyle.ALIGN_FILL;
//        如果是居中对齐就是 HSSFCellStyle.ALIGN_CENTER;
//        如果是右侧对齐就是 HSSFCellStyle.ALIGN_RIGHT;
//        如果是跨列举中就是 HSSFCellStyle.ALIGN_CENTER_SELECTION;
//        如果是两端对齐就是 HSSFCellStyle.ALIGN_JUSTIFY;
//        如果是填充就是 HSSFCellStyle.ALIGN_FILL;

//        垂直对齐相关参数
//        如果是靠上就是 HSSFCellStyle.VERTICAL_TOP;
//        如果是居中就是 HSSFCellStyle.VERTICAL_CENTER;
//        如果是靠下就是 HSSFCellStyle.VERTICAL_BOTTOM;
//        如果是两端对齐就是 HSSFCellStyle.VERTICAL_JUSTIFY;
    }

    /**
     * @Author Loujitao
     * @Date 2018/7/2
     * @Time  15:47
     * @Description: 锁定表头 锁定列
     */
    public static  void fixedTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//创建工作表(Sheet)
        sheet.createFreezePane(2, 3, 3, 4);//冻结行列
    }

    /**
     * @Author Loujitao
     * @Date 2018/7/2
     * @Time  15:51
     * @Description: 生成超链接
     */
    public static  void linkedTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//创建工作表(Sheet)
        CreationHelper createHelper = workbook.getCreationHelper();
// 关联到网站
        Hyperlink link =createHelper.createHyperlink(Hyperlink.LINK_URL);
        link.setAddress("http://poi.apache.org/");
        sheet.createRow(0).createCell(0).setHyperlink(link);
// 关联到当前目录的文件
        link = createHelper.createHyperlink(Hyperlink.LINK_FILE);
        link.setAddress("test01.xls");
        sheet.createRow(0).createCell(1).setHyperlink(link);
// e-mail 关联
        link = createHelper.createHyperlink(Hyperlink.LINK_EMAIL);
        link.setAddress("mailto:poi@apache.org?subject=Hyperlinks");
        sheet.createRow(0).createCell(2).setHyperlink(link);
//关联到工作簿中的位置
        link = createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
        link.setAddress("'test'!C3");//Sheet名为Test0的C3位置
        sheet.createRow(0).createCell(3).setHyperlink(link);
    }

    /**
     * @Author Loujitao
     * @Date 2018/7/2
     * @Time  15:49
     * @Description:   生成下拉菜单
     */
    public static  void selectTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//创建工作表(Sheet)
        HSSFRow row=sheet.createRow(2);
        HSSFCell cell=row.createCell(3);
        cell.setCellValue("日期列");
        CellRangeAddressList regions = new CellRangeAddressList(0, 65535,0, 0);
        DVConstraint constraint =DVConstraint.createExplicitListConstraint(new String[] { "C++","Java", "C#" });
        HSSFDataValidation dataValidate = new HSSFDataValidation(regions,constraint);
        sheet.addValidationData(dataValidate);
    }
    /**
     * @Author Loujitao
     * @Date 2018/7/2
     * @Time  15:09
     * @Description: 操作文件信息
     */
    public static void fileTest(HSSFWorkbook workbook){
        workbook.createInformationProperties();//创建文档信息
        DocumentSummaryInformation dsi=workbook.getDocumentSummaryInformation();//摘要信息
        dsi.setCategory("类别项-Excel文件");//类别
        dsi.setManager("管理者-steve");//管理者
        dsi.setCompany("公司-2号工地");//公司
        SummaryInformation si = workbook.getSummaryInformation();//摘要信息
        si.setSubject("主题-测试");//主题
        si.setTitle("标题:测试文档");//标题
        si.setAuthor("作者-steve");//作者
        si.setComments("备注-POI测试文档");//备注
    }
    /**
     * @Author Loujitao
     * @Date 2018/7/2
     * @Time  15:09
     * @Description: 操作批注
     */
    public static void pizhuTest(HSSFSheet sheet){
        HSSFPatriarch patr = sheet.createDrawingPatriarch();
        //创建批注位置
        HSSFClientAnchor anchor = patr.createAnchor(0, 0, 0, 0, 5, 1, 8,3);
        HSSFComment comment = patr.createCellComment(anchor);//创建批注
        comment.setString(new HSSFRichTextString("这是一个批注段落！"));//设置批注内容
        comment.setAuthor("steve");//设置批注作者
        comment.setVisible(true);//设置批注默认显示
        HSSFCell cell = sheet.createRow(2).createCell(1);
        cell.setCellValue("测试");
        cell.setCellComment(comment);//把批注赋值给单元格
    }
    //没有起效果
    public static void topAndButtom(HSSFSheet sheet){
        HSSFHeader header =sheet.getHeader();//得到页眉
        header.setLeft("页眉左边");
        header.setRight("页眉右边");
        header.setCenter("页眉中间");
        HSSFFooter footer =sheet.getFooter();//得到页脚
        footer.setLeft("页脚左边");
        footer.setRight("页脚右边");
        footer.setCenter("页脚中间");
//        其余参数：
//        HSSFHeader.tab &A 表名
//        HSSFHeader.file &F 文件名
//        HSSFHeader.startBold &B 粗体开始
//        HSSFHeader.endBold &B 粗体结束
//        HSSFHeader.startUnderline &U 下划线开始
//        HSSFHeader.endUnderline &U 下划线结束
//        HSSFHeader.startDoubleUnderline &E 双下划线开始
//        HSSFHeader.endDoubleUnderline &E 双下划线结束
//        HSSFHeader.time &T 时间
//        HSSFHeader.date &D 日期
//        HSSFHeader.numPages &N 总页面数
//        HSSFHeader.page &P 当前页号
    }

    public static  void borderTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//获取工作表(Sheet)
        HSSFRow row = sheet.createRow(2);// 创建行,从0开始
        HSSFCell cell=row.createCell(1);

        cell.setCellValue("设置边框");
        HSSFCellStyle style=workbook.createCellStyle();
        style.setBorderTop(HSSFCellStyle.BORDER_DOTTED);//上边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THICK);//下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_DOUBLE);//左边框
        style.setBorderRight(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);//右边框
        style.setTopBorderColor(HSSFColor.RED.index);//上边框颜色
        style.setBottomBorderColor(HSSFColor.BLUE.index);//下边框颜色
        style.setLeftBorderColor(HSSFColor.GREEN.index);//左边框颜色
        style.setRightBorderColor(HSSFColor.PINK.index);//右边框颜色
        cell.setCellStyle(style);
    }

    public static  void cellSizeTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//获取工作表(Sheet)
        HSSFRow row = sheet.createRow(2);// 创建行,从0开始
        HSSFCell cell=row.createCell(1);
        cell.setCellValue("123456789012345678901234567890");
        sheet.setColumnWidth(1, 31 * 256);//设置第一列的宽度是31个字符宽度
        row.setHeightInPoints(50);//设置行的高度是50个点
    }

    public static  void fontTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//获取工作表(Sheet)
        HSSFRow row = sheet.createRow(2);// 创建行,从0开始
        HSSFCell cell=row.createCell(1);

        cell.setCellValue("设置字体");
        HSSFCellStyle style = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setFontName("华文行楷");//设置字体名称
        font.setFontHeightInPoints((short)28);//设置字号
        font.setColor(HSSFColor.RED.index);//设置字体颜色
        font.setUnderline(FontFormatting.U_SINGLE);//设置下划线
        font.setTypeOffset(FontFormatting.SS_SUPER);//设置上标下标
        font.setStrikeout(true);//设置删除线
        style.setFont(font);
        cell.setCellStyle(style);
    }

    public static  void backgroudTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//获取工作表(Sheet)
        HSSFRow row = sheet.createRow(2);// 创建行,从0开始
        HSSFCell cell=row.createCell(1);

        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor(HSSFColor.GREEN.index);//设置图案颜色
        style.setFillBackgroundColor(HSSFColor.RED.index);//设置图案背景色
        style.setFillPattern(HSSFCellStyle.SQUARES);//设置图案样式
        cell.setCellStyle(style);
    }

    public static  void LineTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//获取工作表(Sheet)
        HSSFPatriarch patriarch=sheet.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short)1, 0,(short)4, 4);
        HSSFSimpleShape line = patriarch.createSimpleShape(anchor);
        line.setShapeType(HSSFSimpleShape.OBJECT_TYPE_LINE);//设置图形类型
        line.setLineStyle(HSSFShape.LINESTYLE_SOLID);//设置图形样式
        line.setLineWidth(6350);//在POI中线的宽度12700表示1pt,所以这里是0.5pt粗的线条。
    }

    public static  void spaceTest(HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.getSheet("Test");//获取工作表(Sheet)
        HSSFPatriarch patriarch=sheet.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(255,122,255, 122, (short)1, 0,(short)4, 3);
        HSSFSimpleShape rec = patriarch.createSimpleShape(anchor);
        rec.setShapeType(HSSFSimpleShape.OBJECT_TYPE_RECTANGLE);//长方形
        rec.setShapeType(HSSFSimpleShape.OBJECT_TYPE_OVAL);// 圆形
        rec.setLineStyle(HSSFShape.LINESTYLE_DASHGEL);//设置边框样式
        rec.setFillColor(255, 0, 0);//设置填充色
        rec.setLineWidth(25400);//设置边框宽度
        rec.setLineStyleColor(0, 0, 255);//设置边框颜色
    }

    public static  void imageTest(HSSFWorkbook workbook) throws Exception{
        HSSFSheet sheet = workbook.getSheet("Test");//获取工作表(Sheet)
        FileInputStream stream=new FileInputStream("d:\\timo.jpg");
        byte[] bytes=new byte[(int)stream.getChannel().size()];
        stream.read(bytes);//读取图片到二进制数组
        int pictureIdx = workbook.addPicture(bytes,HSSFWorkbook.PICTURE_TYPE_JPEG);
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,(short)0, 0, (short)5, 5);
        HSSFPicture pict = patriarch.createPicture(anchor,pictureIdx);
//      pict.resize();//自动调节图片大小,图片位置信息可能丢失
    }



}
