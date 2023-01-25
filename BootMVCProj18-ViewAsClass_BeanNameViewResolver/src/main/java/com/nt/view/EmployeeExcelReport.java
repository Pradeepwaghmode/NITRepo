package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.modle.Employee;

@Component("excelReport")
public class EmployeeExcelReport  extends AbstractXlsView{

	private int i=1;
	@Override
	public void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		
		//get all emp
		List<Employee> list=(List<Employee>)map.get("emplist");
		
		//create excel sheet in work book
		Sheet sheet1=workbook.createSheet("Employee");
		
		//add heading into sheet
		Row row1=sheet1.createRow(0);
		row1.createCell(0).setCellValue("Employee Id");
		row1.createCell(1).setCellValue("Employee Name");
		row1.createCell(2).setCellValue("Employee Job");
		row1.createCell(3).setCellValue("Employee salary");
		row1.createCell(4).setCellValue("Employee status");
		row1.createCell(5).setCellValue("Employee country");
		row1.createCell(6).setCellValue("Employee state");
		
		//add data into sheet
		list.forEach(emp->{
			Row row=sheet1.createRow(i);
			row.createCell(0).setCellValue(emp.getEMPNO());
			row.createCell(1).setCellValue(emp.getEMPNAME());
			row.createCell(2).setCellValue(emp.getJOB());
			row.createCell(3).setCellValue(emp.getSALARY());
			row.createCell(4).setCellValue(emp.getSTATUS());
			row.createCell(5).setCellValue(emp.getCOUNTRY());
			row.createCell(6).setCellValue(emp.getSTATE());
			i++;
		});
		
	}
}
