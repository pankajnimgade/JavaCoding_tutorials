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
 * Created by Pankaj Nimgade on 23-01-2016.
 */
public class ReadTestOne {

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

            Iterator<Row> rowIterator = sheet.iterator();
            boolean first_row = true;

            while (rowIterator.hasNext()) {
                if (first_row) {
                    first_row = false;
                } else {
                    Row singleRow = rowIterator.next();

                    Iterator<Cell> cellIterator = singleRow.iterator();
                    Iterator<Cell> topRow_CellIterator = topRow_record.iterator();

                    Station station = new Station();
                    while (topRow_CellIterator.hasNext()) {
                        Cell topRowCell = topRow_CellIterator.next();
                        if (topRowCell != null) {
                            if (singleRow != null) {
                                populateStation(station, topRowCell, singleRow);
                            }
                        }
                    }
                    System.out.println("" + station.getStationDetails());
                    System.out.println("" + station.getStation_ID());
                    System.out.println("" + station.getStation_Name());
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void populateStation(Station station, Cell topRowCell, Row currentRow) {
        String text = "";
        if (topRowCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            text = String.valueOf(topRowCell.getNumericCellValue());
        } else if (topRowCell.getCellType() == Cell.CELL_TYPE_STRING) {
            text = topRowCell.getStringCellValue();
        }
        int currentColumnLocation = 0;
        switch (text) {
            case ColumnNameConstants.STATION_NAME:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setStation_Name(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants._id:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setStation_ID(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.FIRST_TRAIN_NORTHBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setFirst_Train_Northbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.LAST_TRAIN_NORTHBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setLast_Train_Northbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.FIRST_TRAIN_SOUTHBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setFirst_Train_Southbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.LAST_TRAIN_SOUTHBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setLast_Train_Southbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.FIRST_TRAIN_EASTBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setFirst_Train_Eastbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.LAST_TRAIN_EASTBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setLast_Train_Eastbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.FIRST_TRAIN_WESTBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setFirst_Train_Westbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.LAST_TRAIN_WESTBOUND:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setLast_Train_Westbound(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.ACCESSIBLE:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                        station.setAccessible(true);
                    }
                }
                break;
            case ColumnNameConstants.PRESTO_ENABLED:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                        station.setPresto_Enabled(true);
                    }
                }
                break;
            case ColumnNameConstants.TOKEN_VENDING_MACHINE:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                        station.setToken_Vending_Machine(true);
                    }
                }
                break;
            case ColumnNameConstants.PASSENGER_PICK_UP_AND_DROP_OFF:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                        station.setPassenger_Pick_up_and_Drop_off(true);
                    }
                }
                break;
            case ColumnNameConstants.BICYCLE_REPAIR_STOP:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                        station.setBicycle_Repair_Stop(true);
                    }
                }
                break;
            case ColumnNameConstants.WASHROOMS:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                        station.setWashrooms(true);
                    }
                }
                break;
            case ColumnNameConstants.WI_FI_ENABLED:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    Cell current_Cell = currentRow.getCell(currentColumnLocation);
                    if (current_Cell != null) {
                        if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)) != null) {
                            if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                                station.setWi_fi_Enabled(true);
                            }
                        } else {
                            System.out.println("getStringFromGivenCell is empty");
                        }
                    } else {
                        System.out.println("current_Cell is empty");
                    }
                }
                break;
            case ColumnNameConstants.PASS_VENDING_MACHINE:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    if (getStringFromGivenCell(currentRow.getCell(currentColumnLocation)).contentEquals("Yes")) {
                        station.setPass_Vending_Machine(true);
                    }
                }
                break;
            case ColumnNameConstants.PLATFORM_TYPE:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setPlatform_Type(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.STATION_OVERVIEW:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setStation_Overview(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.PARKING:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setParking(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.LATITUDE:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setLatitude(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.LONGITUDE:
                if (getStringFromGivenCell(topRowCell) != null) {
                    currentColumnLocation = topRowCell.getColumnIndex();
                    station.setLongitude(getStringFromGivenCell(currentRow.getCell(currentColumnLocation)));
                }
                break;
            case ColumnNameConstants.DETAILS:
                if (getStringFromGivenCell(topRowCell) != null) {
//                    station.setStationDetails(getStringFromGivenCell(topRowCell));
                }
                break;
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
        }
        return cell_Text;
    }
}
