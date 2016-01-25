package train.test.one.reading.excel.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by Pankaj Nimgade on 25-01-2016.
 */
public class ReadTestThree {

    private static final String PATH = "\\Reading_TTC_Excel\\excel_files\\TestOneTrain.xlsx";

    public static void main(String[] args) {

        try {

            Path paths = Paths.get("");
            String project_Path = paths.toAbsolutePath().toString();
            String excel_file_path = project_Path + PATH;
            File file = new File(excel_file_path);

            if (file != null) {
                if (file.exists()) {
                    System.out.println("train schedule exists: " + file.exists());

                    readGivenExcelFile(file);
                } else {
                    System.out.println("train schedule exists: " + file.exists());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readGivenExcelFile(File file) {
        try {

            FileInputStream fileInputStream = new FileInputStream(file);

            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);
            Row topRow_record = sheet.getRow(0);

            Iterator<Row> rowIterator = sheet.rowIterator();
            Iterator<Cell> cellIterator = topRow_record.cellIterator();

            while (cellIterator.hasNext()){
                Cell currentCell = cellIterator.next();
                System.out.println(""+currentCell.getColumnIndex());
                getStringFromGivenCell(currentCell);
            }

/*            boolean first_row = true;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                if (!first_row) {

                    Iterator<Cell> current_CellIterator = row.cellIterator();
                    Iterator<Cell> topRow_CellIterator = topRow_record.cellIterator();

                    while (current_CellIterator.hasNext()) {

                        getStringFromGivenCell(topRow_CellIterator.next());
                    }

                    System.out.println("##############################################");
                } else {
                    first_row = false;
                }
            }*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getStringFromGivenCell(Cell cell) {
        String cell_Text = null;
        if (cell != null) {
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                    cell_Text = null;
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    cell_Text = null;
                    break;
                case Cell.CELL_TYPE_ERROR:
                    cell_Text = null;
                    break;
                case Cell.CELL_TYPE_FORMULA:
                    cell_Text = null;
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    cell_Text = String.valueOf(cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    cell_Text = cell.getStringCellValue();
                    break;

            }
        } else {
            System.out.println("cell is null");
        }
        System.out.println("" + cell_Text);
        return cell_Text;
    }
}
