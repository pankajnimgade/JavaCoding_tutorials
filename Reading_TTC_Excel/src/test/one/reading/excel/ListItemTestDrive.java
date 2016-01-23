package test.one.reading.excel;

import com.google.gson.Gson;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ListItemTestDrive {

    private static Workbook workbook;

    public static void main(String[] args) {
        ArrayList<ListItem> listItems = new ArrayList<>();
        final String dir = System.getProperty("user.dir");
        File file = new File("" + dir + "\\Reading_TTC_Excel\\excel_files\\Nov.xlsx");
        File fileText = new File("" + dir
                + "\\Reading_TTC_Excel\\excel_files\\list_information.txt");
        File fileNewJsonText = new File("" + dir
                + "\\Reading_TTC_Excel\\excel_files\\new_json.json");

        try {

            System.out.println("sze: " + file.length());
            FileInputStream inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);

            for (int i = 1; i <= firstSheet.getLastRowNum(); i++) {
                ListItem item = new ListItem();
                item.setJapanesePlace(populateOnwRecordRow(workbook.getSheetAt(0).getRow(i), 0));
                item.setEnglishPlace(populateOnwRecordRow(workbook.getSheetAt(1).getRow(i), 1));
                item.setChinesePlace(populateOnwRecordRow(workbook.getSheetAt(2).getRow(i), 2));
                listItems.add(item);
            }

            System.out.println("Size: " + listItems.size());
            for (int i = 0; i < listItems.size(); i++) {
                System.out.println("Latitude: " + listItems.get(i).getJapanesePlace().getPicture_Filename());
//				System.out.println("Longitude: "+ listItems.get(i).getJapanesePlace().getLongitude());
                //
            }

            FileOutputStream fileOut = new FileOutputStream(fileText);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listItems);
            out.close();
            fileOut.close();


            FileInputStream fileIn = new FileInputStream("" + dir+ "\\Reading_TTC_Excel\\excel_files\\list_information.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<ListItem> resultList = (ArrayList<ListItem>) in
                    .readObject();
            in.close();
            fileIn.close();
            for (int i = 0; i < resultList.size(); i++) {
                System.out.println("Picture Credit: "
                        + resultList.get(i).getChinesePlace().get属性1());

            }

            String result = (new Gson()).toJson(listItems);
            System.out.println("" + result);
            Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileNewJsonText), "UTF-8"));
            writer.write(result);
            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    private static Place populateOnwRecordRow(Row row, int languageSheet) {
        Place place = new Place();
        if (isValidString(row, 0)) {
            place.setBuilding_id("" + getString(row, 0));
        }
        if (isValidString(row, 1)) {
            place.setBuilding_Name("" + getString(row, 1));
        }
        if (isValidString(row, 2)) {
            place.setJapanese_name("" + getString(row, 2));
        }
        if (isValidString(row, 3)) {
            place.setOther_names("" + getString(row, 3));
        }
        if (isValidString(row, 4)) {
            place.setかな2("" + getString(row, 4));
        }
        if (isValidString(row, 5)) {
            place.setText("" + getString(row, 5));
        }
        if (isValidString(row, 6)) {
            place.setAdmission_Fee("" + getString(row, 6));
        }

        Sheet tempSheet = workbook.getSheetAt(languageSheet);
        Row tempRow = tempSheet.getRow(0);
        if (isValidString(tempRow, 6)) {
            place.setAdmission_Fee_title("" + getString(tempRow, 6));
        }

        if (isValidString(tempRow, 9)) {
            place.setPublication_TEL_title("" + getString(tempRow, 9));
        }

        if (isValidString(tempRow, 12)) {
            place.setNearest_Station_title("" + getString(tempRow, 12));
        }

        if (isValidString(tempRow, 13)) {
            place.setAccess_title("" + getString(tempRow, 13));
        }

        if (isValidString(tempRow, 17)) {
            place.setAddress_title("" + getString(tempRow, 17));
        }


        if (isValidString(row, 7)) {
            place.setHours_of_Operation("" + getString(row, 7));
        }
        if (isValidString(row, 8)) {
            place.setHolidays("" + getString(row, 8));
        }
        if (isValidString(row, 9)) {
            place.setPublication_TEL("" + getString(row, 9));
        }
        if (isValidString(row, 10)) {
            place.setInquiries("" + getString(row, 10));
        }
        if (isValidString(row, 11)) {
            place.setTelephone_Notes("" + getString(row, 11));
        }
        if (isValidString(row, 12)) {
            place.setNearest_Station("" + getString(row, 12));
        }
        if (isValidString(row, 13)) {
            place.setAccess("" + getString(row, 13));
        }
        if (isValidString(row, 14)) {
            place.setAccess_2("" + getString(row, 15));
        }
        if (isValidString(row, 15)) {
            place.setNo_of_Parking_Lots("" + getString(row, 15));
        }
        if (isValidString(row, 16)) {
            place.setPostal_Code("" + getString(row, 16));
        }
        if (isValidString(row, 17)) {
            place.setAddress("" + getString(row, 17));
        }
        if (isValidString(row, 18)) {
            place.setLatitude("" + getString(row, 18));
        }
        if (isValidString(row, 19)) {
            place.setLongitude("" + getString(row, 19));
        }
        if (isValidString(row, 20)) {
            place.setCoordinates("" + getString(row, 20));
        }
        if (isValidString(row, 21)) {
            place.set属性1("" + getString(row, 21));
        }
        if (isValidString(row, 22)) {
            place.set属性2("" + getString(row, 22));
        }
        if (isValidString(row, 23)) {
            place.setPicture_Filename("" + getString(row, 23));
        }
        if (isValidString(row, 24)) {
            place.setPicture_Credits("" + getString(row, 24));
        }
        if (isValidString(row, 25)) {
            place.setText_sound("" + getString(row, 25));
        }
        if (isValidString(row, 26)) {
            place.setDescription_Sound("" + getString(row, 26));
        }

        return place;
    }

    public static boolean isValidString(Row row, int columnNumber) {
        try {
            String text = "";
            switch (row.getCell(columnNumber).getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    text = row.getCell(columnNumber).getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    text = "" + row.getCell(columnNumber).getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    text = "" + row.getCell(columnNumber).getNumericCellValue();
                    break;
            }

            if (text == null) {
                return false;
            }
            if (text.trim().contentEquals("")) {
                return false;
            }

            if (text.trim().length() < 1) {
                return false;
            }

            if (text.trim().toLowerCase().contentEquals("null")) {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }

        return true;
    }

    public static String getString(Row row, int columnNumber) {
        String text = "";
        try {
            switch (row.getCell(columnNumber).getCellType()) {
                case Cell.CELL_TYPE_STRING:
                    text = row.getCell(columnNumber).getStringCellValue();
                    break;
                case Cell.CELL_TYPE_BOOLEAN:
                    text = "" + row.getCell(columnNumber).getBooleanCellValue();
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    text = "" + row.getCell(columnNumber).getNumericCellValue();
                    break;
            }

            if (text == null) {
                return text;
            }
            if (text.trim().contentEquals("")) {
                return text;
            }

            if (text.trim().length() < 1) {
                return text;
            }

            if (text.trim().toLowerCase().contentEquals("null")) {
                return text;
            }
        } catch (Exception e) {
            // TODO: handle exception
            return text;
        }

        return text;
    }


    private boolean isValidString(String text) {
        if (text == null) {
            return false;
        }
        if (text.trim().contentEquals("")) {
            return false;
        }

        if (text.trim().length() < 1) {
            return false;
        }

        if (text.trim().toLowerCase().contentEquals("null")) {
            return false;
        }

        return true;
    }

}
