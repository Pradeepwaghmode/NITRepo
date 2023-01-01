package com.nt.modul;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modul {
	private  Integer id;
	private String pname;
	private Double price;
	private Double qty;
}
