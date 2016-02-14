package train.test.one.reading.excel.test;

import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Pankaj Nimgade on 14-02-2016.
 */
public class ReadTestFive {

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
            Iterator<Sheet> sheetIterator = workbook.sheetIterator();

            HashMap<String, ArrayList<Station>> stringArrayListHashMap = new HashMap<>();
            while (sheetIterator.hasNext()) {
                Sheet current_Sheet = sheetIterator.next();
                System.out.println("Sheet Name: " + current_Sheet.getSheetName());
                ArrayList<Station> stationArrayList = createStationArrayList(current_Sheet);
                stringArrayListHashMap.put(current_Sheet.getSheetName().trim(), stationArrayList);
            }

            String result = (new Gson()).toJson(stringArrayListHashMap);
            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Station> createStationArrayList(Sheet sheet) {
        ArrayList<Station> stations = new ArrayList<>();

        Row topRow_record = sheet.getRow(0);
        Row first_Row_record = sheet.getRow(1);

        Iterator<Row> rowIterator = sheet.rowIterator();
        Iterator<Cell> cellIterator_top_Row = topRow_record.cellIterator();

        boolean first_row = true;
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (!first_row) {

                Iterator<Cell> current_CellIterator = row.cellIterator();
                Iterator<Cell> topRow_CellIterator = topRow_record.cellIterator();
                Station station = new Station();
                while (current_CellIterator.hasNext()) {
                    Cell currentCell = current_CellIterator.next();
                    getStringFromGivenCell(currentCell);
                    Cell top_row_cell = topRow_record.getCell(currentCell.getColumnIndex());
                    String text = getStringFromGivenCell(top_row_cell);
                    String inner_text = "";
                    if (text != null) {

                        switch (text.trim()) {
                            case ColumnNameConstants.STATION_NAME:
//                                    System.out.println("Station Name:====>  " + getStringFromGivenCell(currentCell));
                                station.setStation_Name(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants._id:
//                                    System.out.println("_id:====>  " + getStringFromGivenCell(currentCell));
                                station.setStation_ID(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.FIRST_TRAIN_NORTHBOUND:
//                                    System.out.println("FIRST_TRAIN_NORTHBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setFirst_Train_Northbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.LAST_TRAIN_NORTHBOUND:
//                                    System.out.println("LAST_TRAIN_NORTHBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setLast_Train_Northbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.FIRST_TRAIN_SOUTHBOUND:
//                                    System.out.println("FIRST_TRAIN_SOUTHBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setFirst_Train_Southbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.LAST_TRAIN_SOUTHBOUND:
//                                    System.out.println("LAST_TRAIN_SOUTHBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setLast_Train_Southbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.FIRST_TRAIN_EASTBOUND:
//                                    System.out.println("FIRST_TRAIN_EASTBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setFirst_Train_Eastbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.LAST_TRAIN_EASTBOUND:
//                                    System.out.println("LAST_TRAIN_EASTBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setLast_Train_Eastbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.FIRST_TRAIN_WESTBOUND:
//                                    System.out.println("FIRST_TRAIN_WESTBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setFirst_Train_Westbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.LAST_TRAIN_WESTBOUND:
//                                    System.out.println("LAST_TRAIN_WESTBOUND:====>  " + getStringFromGivenCell(currentCell));
                                station.setLast_Train_Westbound(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.ACCESSIBLE:
//                                    System.out.println("ACCESSIBLE:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setAccessible(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.PRESTO_ENABLED:
//                                    System.out.println("PRESTO_ENABLED:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setPresto_Enabled(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.TOKEN_VENDING_MACHINE:
//                                    System.out.println("TOKEN_VENDING_MACHINE:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setToken_Vending_Machine(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.PASSENGER_PICK_UP_AND_DROP_OFF:
//                                    System.out.println("PASSENGER_PICK_UP_AND_DROP_OFF:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setPassenger_Pick_up_and_Drop_off(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.BICYCLE_REPAIR_STOP:
//                                    System.out.println("BICYCLE_REPAIR_STOP:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setBicycle_Repair_Stop(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.WASHROOMS:
//                                    System.out.println("WASHROOMS:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setWashrooms(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.WI_FI_ENABLED:
//                                    System.out.println("WI_FI_ENABLED:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setWi_fi_Enabled(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.PASS_VENDING_MACHINE:
//                                    System.out.println("PASS_VENDING_MACHINE:====>  " + getStringFromGivenCell(currentCell));
                                inner_text = getStringFromGivenCell(currentCell);
                                if (inner_text != null) {
                                    if (inner_text.contentEquals("Yes")) {
                                        station.setPass_Vending_Machine(true);
                                    }
                                }
                                break;
                            case ColumnNameConstants.PLATFORM_TYPE:
//                                    System.out.println("PLATFORM_TYPE:====>  " + getStringFromGivenCell(currentCell));
                                station.setPlatform_Type(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.STATION_OVERVIEW:
//                                    System.out.println("STATION_OVERVIEW:====>  " + getStringFromGivenCell(currentCell));
                                station.setStation_Overview(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.PARKING:
//                                    System.out.println("PARKING:====>  " + getStringFromGivenCell(currentCell));
                                station.setParking(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.LATITUDE:
//                                    System.out.println("Latitude:====>  " + getStringFromGivenCell(currentCell));
                                station.setLatitude(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.LONGITUDE:
//                                    System.out.println("Longitude:====>  " + getStringFromGivenCell(currentCell));
                                station.setLongitude(getStringFromGivenCell(currentCell));
                                break;
                            case ColumnNameConstants.DETAILS:
//                                    System.out.println("Details:====>  " + getStringFromGivenCell(currentCell));

                                break;
                        }


//                            getStringFromGivenCell(top_row_cell);
                    }

                }
                Cell cell = first_Row_record.getCell(23);
//                    System.out.println("Details==>" + getStringFromGivenCell(cell));
                station.setLast_Train_Westbound(getStringFromGivenCell(cell));
//                System.out.println("" + station.toString());
                stations.add(station);
//                System.out.println("##############################################");
            } else {
                first_row = false;
            }
        }


        return stations;
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
//        System.out.println("" + cell_Text);
        return cell_Text;
    }
}
