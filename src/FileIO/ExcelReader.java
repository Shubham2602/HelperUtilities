package FileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	private String file = "";
    
	public ExcelReader(String file) {
		this.file = file;
	}
	
	public Map<Integer,String> getHeaders()throws Exception
	{
		
		FileInputStream excelFile = new FileInputStream(new File(file));
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheet("Sheet1");
		Map<Integer,String> headerMap = new LinkedHashMap<>();
        Iterator<Row> iterator = sheet.iterator();
        if(iterator.hasNext()) {
        	Row headerRow = iterator.next();
        	Iterator<Cell> cellIterator = headerRow.iterator();
        	int i=0;
        	while(cellIterator.hasNext()) {
        		Cell cell = cellIterator.next();
            	headerMap.put(i, cell.getStringCellValue());
            	i++;
        	}
        }
        
        excelFile.close();
        
        return headerMap;
	}
	
	public List<Map<String,String>> readSheet()throws Exception 
	{
		List<Map<String,String>> sheetInfo = new ArrayList<>();
		Map<String,String> rowMap; 
		
		Map<Integer,String> headerMap = getHeaders();
		FileInputStream excelFile = new FileInputStream(new File(file));
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheet("Sheet1");
		
        Iterator<Row> iterator = sheet.iterator();
        if(iterator.hasNext()) {
        	iterator.next();
        }
         
//        for(Map.Entry<Integer, String> m : headerMap.entrySet()) {
//        	System.out.println(m.getKey()+ " : " +m.getValue());
//        }
        while(iterator.hasNext()) {
        	Row row = iterator.next();
        	Iterator<Cell> cellIterator = row.iterator();
        	rowMap = new LinkedHashMap<>();
        	int i=0;
        	while(cellIterator.hasNext()) {
        		Cell cell = cellIterator.next();
				String cellValue = cell.getStringCellValue();
				rowMap.put(headerMap.get(i), cellValue);
				i++;
        	}
        	sheetInfo.add(rowMap);
        }
        
        excelFile.close();
        
        return sheetInfo;
	}
	
	public void writeNewRow(Map<String,String> newEntry) throws Exception {
		FileInputStream excelFile = new FileInputStream(new File(file));
		Workbook workbook = new XSSFWorkbook(excelFile);
		Sheet sheet = workbook.getSheet("Sheet1");
		
		Iterator<Row> iterator = sheet.iterator();
		int numberOfRows = 0;
		while(iterator.hasNext()) {
			iterator.next();
			numberOfRows++;
		}
		
		Row row = sheet.createRow(numberOfRows);
		for(int i=0;i<getHeaders().size();i++) {
			Cell cell = row.createCell(i);
			String value = newEntry.get(getHeaders().get(i));
			cell.setCellValue(value);
		}
		
		try {
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            workbook.close();
            System.out.println("A new entry has been made");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String args[]) throws Exception
	{
		ExcelReader re = new ExcelReader("F:/eclipse/HelperUtilitites/sampleXL.xlsx");
		//System.out.println(re.readSheet().get(2).get("Working Hour"));
		
		Map<String,String> map = new LinkedHashMap<>();
		map.put("LastName", "Routh");
		map.put("FirstName", "Shubham");
		map.put("FullName", "ShubhamRouth");
		map.put("EmployeeNumber", "56789");
		map.put("Organization", "hakunamatata");
		map.put("Working Hour", "5-4");
		map.put("Jobs Name", "Panu byabshayi");
		map.put("Annualized salary", "2");
		map.put("ACF User Id", "Shubham");
		map.put("SalaryEndDT", "00.00.0000");
		
		re.writeNewRow(map);
    }
}
