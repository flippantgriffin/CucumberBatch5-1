package utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.List;

public class ExcelTest {

    public static void main(String[] args) {
//        File file= new File("src/test/resources/Data/TestCaseData.xlsx");
//
//        try {
//            FileInputStream input = new FileInputStream(file);
//           Workbook workbook= new XSSFWorkbook(input);
//            Sheet excelSheet=  workbook.getSheet("Sheet1");
//            String value= excelSheet.getRow(0).getCell(0).toString(); // it will get the very first raw
//            System.out.println(value);
//
//            Row row= excelSheet.getRow(1);
//            //Looping through the file to get the whole row.
//            for(int i=0; i<5; i++){
//                System.out.println();
//                System.out.println(row.getCell(i).toString());
//            }
//           //Adding text to a file by using Row and Cell
//            Row row1= excelSheet.getRow(1);
//            Cell cell1= row1.createCell(6);
//            cell1.setCellType(CellType.STRING);
//            cell1.setCellValue("PASS");
//            FileOutputStream fileOutputStream= new FileOutputStream("src/test/resources/Data/TestCaseData.xlsx");
//           workbook.write(fileOutputStream);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }



        ExcelUtils.openExcelFile("Book3", "Sheet1");
        String expectedResults = ExcelUtils.getValue(1,1);
        System.out.println(expectedResults);
        ExcelUtils.setValue(1,1,"TEC-2011");
        List<String> values = ExcelUtils.getRowValues(0);
        System.out.println(values);




    }

}
