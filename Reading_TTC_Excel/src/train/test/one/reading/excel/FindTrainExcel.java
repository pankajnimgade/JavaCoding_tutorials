package train.test.one.reading.excel;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Pankaj Nimgade on 22-01-2016.
 */
public class FindTrainExcel {

    private static final String TAG = "FindTrainExcel";


    public static void main(String[] args){

        System.out.println("running file: "+TAG);
        Path currentRelativePath = Paths.get("");
        System.out.println(""+currentRelativePath.toAbsolutePath().toString());
        String relative_path = currentRelativePath.toAbsolutePath().toString();
        File excel_file = new File(relative_path+"\\Reading_TTC_Excel\\excel_files");

        if (excel_file != null) {
            System.out.println(""+excel_file.getAbsolutePath());
            if (excel_file.isDirectory()) {
                File[] files = excel_file.listFiles();
                if (files != null) {
                    for (File single :files) {
                        if (single != null) {
                            System.out.println("single File is: "+single.getName());
                        }else {
                            System.out.println("single is null");
                        }
                    }
                }else {
                    System.out.println("files are null");
                }
            }else {
                System.out.println("excel_file is not a directory");
            }
        }


    }
}
