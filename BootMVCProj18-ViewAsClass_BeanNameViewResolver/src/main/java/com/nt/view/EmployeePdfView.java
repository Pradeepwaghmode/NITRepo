package com.nt.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.modle.Employee;

@Component("pdfReport")
public class EmployeePdfView  extends AbstractPdfView{

	@Override
	public void buildPdfDocument(Map<String, Object> map, Document doc, PdfWriter pw,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		//get all employee
		List<Employee> list=(List<Employee>)map.get("emplist");
		
		//take paragraph 
		
		Paragraph pr=new Paragraph("Employee Report",new Font(Font.TIMES_ROMAN ,Font.DEFAULTSIZE,Font.BOLDITALIC) );
		doc.add(pr);
		
		Table table=new Table(7,list.size());
		table.addCell("EMPNO");
		table.addCell("EMPNAME");
		table.addCell("JOB");
		table.addCell("SALARY");
		table.addCell("COUNTRY");
		table.addCell("STATE");
		table.addCell("STATUS");
		for(Employee emp:list) {
			table.addCell(String.valueOf(emp.getEMPNO()));
			table.addCell(emp.getEMPNAME());
			table.addCell(emp.getJOB());
			table.addCell(String.valueOf(emp.getSALARY()));
			table.addCell(emp.getCOUNTRY());
			table.addCell(emp.getSTATE());
			table.addCell(emp.getSTATUS());
		}
		doc.add(table);
		
	}
}
