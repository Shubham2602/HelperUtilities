package Resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel 
{
	XSSFWorkbook workbook = new XSSFWorkbook();
	public void xcl(ArrayList<String> firstNames,ArrayList<String> lastNames,ArrayList<String> ages)
	{
		
        XSSFSheet sheet = workbook.createSheet("Sample sheet");
        
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        
        for(int i=0;i<firstNames.size();i++)
        {
            data.put(i+"",new Object[]{firstNames.get(i),lastNames.get(i),ages.get(i)});
        }
     
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof Date)
                    cell.setCellValue((Date) obj);
                else if (obj instanceof Boolean)
                    cell.setCellValue((Boolean) obj);
                else if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Double)
                    cell.setCellValue((Double) obj);
            }
        }
	}
	
	public void write()
	{
		ArrayList<String> firstNames = new ArrayList<String>();
        ArrayList<String> lastNames = new ArrayList<String>();
        ArrayList<String> ages = new ArrayList<String>();
        
		try {
			xcl(firstNames, lastNames, ages);
            FileOutputStream out = new FileOutputStream(new File("C:/Users/admin/Desktop/book.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Excel written successfully..");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
