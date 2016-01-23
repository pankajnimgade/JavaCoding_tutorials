package train.test.one.reading.excel.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import train.test.one.reading.excel.module.classes.ColumnName;
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

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {

                Row singleRow = rowIterator.next();

                Iterator<Cell> cellIterator = singleRow.iterator();
                ColumnName[] columnName = ColumnName.values();
                Station station = new Station();
                while (cellIterator.hasNext()) {
                    Cell topRowCell = cellIterator.next();
                    String text = "";
                    if (topRowCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        text = String.valueOf(topRowCell.getNumericCellValue());
                    } else if (topRowCell.getCellType() == Cell.CELL_TYPE_STRING) {
                        text = topRowCell.getStringCellValue();
                    }
                    switch (text) {
                        case ColumnNameConstants.STATION_NAME:
                            if (getStringFromGivenCell(topRowCell) != null) {
                                station.setStation_Name(getStringFromGivenCell(topRowCell));
                            } else {
                                station.setStation_Name(null);
                            }
                            break;
                        case ColumnNameConstants._id:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.FIRST_TRAIN_NORTHBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.LAST_TRAIN_NORTHBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.FIRST_TRAIN_SOUTHBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.LAST_TRAIN_SOUTHBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.FIRST_TRAIN_EASTBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.LAST_TRAIN_EASTBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.FIRST_TRAIN_WESTBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.LAST_TRAIN_WESTBOUND:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.ACCESSIBLE:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.PRESTO_ENABLED:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.TOKEN_VENDING_MACHINE:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.PASSENGER_PICK_UP_AND_DROP_OFF:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.BICYCLE_REPAIR_STOP:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.WASHROOMS:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.WI_FI_ENABLED:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.PASS_VENDING_MACHINE:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.PLATFORM_TYPE:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.STATION_OVERVIEW:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.PARKING:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.LATITUDE:
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.LONGITUDE:
                            if (getStringFromGivenCell(topRowCell) != null) {
                                station.setLongitude("" + getStringFromGivenCell(topRowCell));
                            } else {
                                station.setLongitude(null);
                            }
                            station.setStation_Name("" + getStringFromGivenCell(topRowCell));
                            break;
                        case ColumnNameConstants.DETAILS:
                            if (getStringFromGivenCell(topRowCell) != null) {
                                station.setStationDetails(getStringFromGivenCell(topRowCell));
                            } else {
                                station.setStationDetails(null);
                            }
                            break;
                    }
                }


                System.out.println("" + station.getStationDetails());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getStringFromGivenCell(Cell cell) {
        String cell_Text = null;
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
        return cell_Text;
    }


}
