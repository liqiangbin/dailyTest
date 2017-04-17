package oracleTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestExcel {
	// 获取Excel文档的路径
	public static  String filePath = "D://lll1.xlsx";
	public static void main(String args[]){
		Tmcc mcc=new Tmcc();
		TestExcel dao=new TestExcel();
		ArrayList<Tmcc> showList=dao.getExcelData();
		System.out.println("list.size()-------->"+showList.size());
		for(int i=0;i<showList.size();i++){
		System.out.println("第"+i+"条记录-->"+showList.get(i).getKey()+"|"+showList.get(i).getName());
		}
	}
	public ArrayList<Tmcc>  getExcelData() {
		ArrayList<Tmcc> list= new ArrayList<Tmcc>();
		try {
			Workbook book = null;
			try {
				book = new XSSFWorkbook(filePath);
			} catch (Exception ex) {
				book = new HSSFWorkbook(new FileInputStream(filePath));
			}

			Sheet sheet = book.getSheet("Sheet1");
			// 获取到Excel文件中的所有行数
			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println("&&&&&&&&"+rows);
			// 遍历行
			for (int i = 0; i < rows; i++) {
				
				// 读取左上端单元格
				Row row = sheet.getRow(i);
				// 行不为空
				if (row != null) {
					// 获取到Excel文件中的所有的列
					int cells = row.getPhysicalNumberOfCells();
					String value = "";
					// 遍历列
					for (int j = 0; j < cells; j++) {
						// 获取到列的值
						Cell cell = row.getCell(j);
						if (cell != null) {
							switch (cell.getCellType()) {
							case Cell.CELL_TYPE_FORMULA:
								break;
							case Cell.CELL_TYPE_NUMERIC:
								value += cell.getNumericCellValue() + ",";
								break;
							case Cell.CELL_TYPE_STRING:
								value += cell.getStringCellValue() + ",";
								break;
							default:
								value += " ";
								break;
							}
						}
					}
					String[] val = value.split(",");
					
					if(i!=0){
						Tmcc m=new Tmcc();
						m.setKey(val[0]);
						m.setName(val[1]);
						list.add(m);	
					}
					
					System.out.println("第几行？="+i+"每一行的列数："+val.length+"---->"+val[0]+"|"+val[1]+"| "+val[2]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}