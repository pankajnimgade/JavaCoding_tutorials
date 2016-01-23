package train.test.one.reading.excel.test;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 22-01-2016.
 */
public class TestOne {

    private static final String PATH = "\\Reading_TTC_Excel\\test_excel_files\\workbook.xls";

    public static void main(String[] args) {
        try {


            Path paths = Paths.get("");

            String project_Path = paths.toAbsolutePath().toString();
            System.out.println("" + project_Path);
            System.out.println("" + project_Path + PATH);
            File file = new File(project_Path + PATH);
            if (file != null) {
                if (file.exists()) {
                    System.out.println("exists1: " + file.exists());
                } else {
                    System.out.println("exists2: " + file.exists());
                    // create a new file
                    FileOutputStream out = new FileOutputStream(project_Path+PATH);
// create a new workbook
//                    Workbook wb = new HSSFWorkbook();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
