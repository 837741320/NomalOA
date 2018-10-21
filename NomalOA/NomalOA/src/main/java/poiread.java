import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class poiread {


    public static void main(String[] args) throws Exception {
        //读取excel表中的数据
        InputStream inputStream= new FileInputStream("D:/805.xls");
        //负责读取表格中的数据，我们需要对其一层一层的解析
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(inputStream);

        //获取工作薄
        HSSFWorkbook sheets = new HSSFWorkbook(poifsFileSystem);
        //可以通过下标也可以通过sheet的名字进行获取某一个sheet对象
        HSSFSheet sheetAt = sheets.getSheetAt(0);

        //根工作表获取第一行对象
        HSSFRow row = sheetAt.getRow(0);

        for (int i=0;i<row.getLastCellNum();i++){

            HSSFCell cell = row.getCell(i);
                //获取单元格的类型，根据常量进行判断，选择使用具体的方法获取数据
            if(cell.getCellType()==HSSFCell.CELL_TYPE_STRING){
                String stringCellValue = cell.getStringCellValue();
                System.out.println(stringCellValue);

            }

        }


    }
}
