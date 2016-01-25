package train.test.one.reading.excel.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import train.test.one.reading.excel.module.classes.ColumnNameConstants;
import train.test.one.reading.excel.module.classes.Station;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by Pankaj Nimgade on 24-01-2016.
 */
public class ReadTestTwo {

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
            boolean first_row = true;
            while (rowIterator.hasNext()) {

                Row currentRow = rowIterator.next();
                if (!first_row) {

                    Station station = new Station();
                    populateStationObject(station, topRow_record, currentRow);
                } else {
                    first_row = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Station populateStationObject(Station station, Row topRow_record, Row currentRow) {
        Iterator<Cell> cellIterator = currentRow.cellIterator();
        Iterator<Cell> cellIterator_top_Row = topRow_record.cellIterator();
        while (cellIterator.hasNext()) {
            Cell cell_Top_Row = cellIterator_top_Row.next();
            Cell cell_Current_Row = cellIterator.next();
            String text = getStringFromGivenCell(cell_Top_Row);
            int current_cell_position = cell_Top_Row.getColumnIndex();
            Cell myCell = null;
            switch (text) {
                case ColumnNameConstants.STATION_NAME:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setStation_Name(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants._id:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setStation_ID(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.FIRST_TRAIN_NORTHBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setFirst_Train_Northbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.LAST_TRAIN_NORTHBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setLast_Train_Northbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.FIRST_TRAIN_SOUTHBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setFirst_Train_Southbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.LAST_TRAIN_SOUTHBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setLast_Train_Southbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.FIRST_TRAIN_EASTBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setFirst_Train_Eastbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.LAST_TRAIN_EASTBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setLast_Train_Eastbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.FIRST_TRAIN_WESTBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setFirst_Train_Westbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.LAST_TRAIN_WESTBOUND:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setLast_Train_Westbound(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.ACCESSIBLE:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setAccessible(true);
                        }
                    }
                    break;
                case ColumnNameConstants.PRESTO_ENABLED:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setPresto_Enabled(true);
                        }
                    }
                    break;
                case ColumnNameConstants.TOKEN_VENDING_MACHINE:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setToken_Vending_Machine(true);
                        }
                    }
                    break;
                case ColumnNameConstants.PASSENGER_PICK_UP_AND_DROP_OFF:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setPassenger_Pick_up_and_Drop_off(true);
                        }
                    }
                    break;
                case ColumnNameConstants.BICYCLE_REPAIR_STOP:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setBicycle_Repair_Stop(true);
                        }
                    }
                    break;
                case ColumnNameConstants.WASHROOMS:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setWashrooms(true);
                        }
                    }
                    break;
                case ColumnNameConstants.WI_FI_ENABLED:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setWi_fi_Enabled(true);
                        }
                    }
                    break;
                case ColumnNameConstants.PASS_VENDING_MACHINE:
                    myCell = currentRow.getCell(current_cell_position);
                    if (getStringFromGivenCell(myCell) != null) {
                        if (getStringFromGivenCell(myCell).contentEquals("Yes")) {
                            station.setPass_Vending_Machine(true);
                        }
                    }
                    break;
                case ColumnNameConstants.PLATFORM_TYPE:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setPlatform_Type(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.STATION_OVERVIEW:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setStation_Overview(getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.PARKING:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setParking(getStringFromGivenCell(myCell));
                    System.out.println(""+getStringFromGivenCell(myCell));

                    break;
                case ColumnNameConstants.LATITUDE:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setLatitude(getStringFromGivenCell(myCell));
                    System.out.println(""+getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.LONGITUDE:
                    myCell = currentRow.getCell(current_cell_position);
                    station.setLongitude(getStringFromGivenCell(myCell));
                    System.out.println(""+getStringFromGivenCell(myCell));
                    break;
                case ColumnNameConstants.DETAILS:
                    break;
            }
        }
//        System.out.println("Station: " + station.toString());
        System.out.println("##################################################################");
        return station;
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
        }else{
            System.out.println("cell is null");
        }
//        System.out.println("" + cell_Text);
        return cell_Text;
    }
}
