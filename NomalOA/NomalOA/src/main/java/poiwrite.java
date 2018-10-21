import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;

public class poiwrite {

    public static void main(String[] args) throws Exception {
        //创建一个excel表格
        //工作薄
        Workbook workbook = new HSSFWorkbook();

        OutputStream outputStream = new FileOutputStream("D:\\805-2.xls");

        //工作表
        Sheet sheet1 = workbook.createSheet("教学部");
        Sheet sheet2 = workbook.createSheet("行政部");
//行对象
        Row row = sheet1.createRow(0);
        Row row2 = sheet1.createRow(1);

        //单元格
        Cell cell1 = row.createCell(0);
        Cell cell2 = row.createCell(1);


        cell1.setCellValue("姓名");
        cell2.setCellValue("工资");

        row2.createCell(0).setCellValue("pfdu");
        row2.createCell(1).setCellValue(100);


        //shee2

        Cell cell = sheet2.createRow(0).createCell(0);

        //为时间格式的单位格制定显示格式， 没有这个会显示毫秒值
        CreationHelper createHelper=workbook.getCreationHelper();
        CellStyle cellStyle=workbook.createCellStyle(); //单元格样式类
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyy-mm-dd hh:mm:ss"));


        cell.setCellStyle(cellStyle);
        cell.setCellValue(Calendar.getInstance());



        //写入到本地文件中
        ((HSSFWorkbook) workbook).write(outputStream);
    }
}
