package com.nt.module;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	private Integer empid;
	private String name;
	private String favColor[];
	private List<String> nickNames;
	private Set<Long> phons;
	private Map<String,Long> idDetails;
	private Boolean isVccacinated;
	private LocalDateTime dob;
	private Company company;
		
}
