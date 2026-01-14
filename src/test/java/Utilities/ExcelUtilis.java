package Utilities;

//esto se usa para el formato viejo de excel import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilis {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public ExcelUtilis(String excelPath, String sheetName){
        try {

            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);


        }
        catch (Exception e){
            e.printStackTrace();
            }
    }

    public int getRowCount(){
        int rowCount=0;
        try {

            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows "+rowCount);
            }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
            }
        return rowCount;
     }

    public int getColCount(){
        int colCount=0;
        try {

            colCount = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("No of Col "+colCount);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
     return colCount;
    }


    public String getCellDataString(int rowNum, int colNum){
        String cellData=null;
        try {
             cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            //System.out.println(cellData);
            }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    return cellData;
    }

    public void getCellDataNumber(int rowNum, int colNum){

        try {
            double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
            //System.out.println(cellData);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
    }

}

