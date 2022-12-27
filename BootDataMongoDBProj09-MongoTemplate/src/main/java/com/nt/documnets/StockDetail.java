package com.nt.documnets;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDetail implements Serializable{

	@Id
	private Integer id;
	private String sname;
	private Float stockPrice;
	private String excechangeName;
	
}
