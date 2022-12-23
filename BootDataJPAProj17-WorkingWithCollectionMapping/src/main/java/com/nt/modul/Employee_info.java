package com.nt.modul;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ListIndexBase;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="EMPLOYEE_CILLECTION_INFO")
public class Employee_info {

	@Id
	@GeneratedValue
	private Integer eid;
	
	@Column(length = 20)
	private String ename;
	
	@ElementCollection
	@CollectionTable(name="EMPOLYEE_FRIENDS",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
	@OrderColumn(name="FRIEND_INDX")
	@ListIndexBase(value=1)
	@Column(name="FRIEND_NAME",length = 20)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> frineds;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_PHONE_NUMBRS",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
	@Column(name="PHONE_NUMBRS" ,length = 10)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Long> phoneNumber;
	
	@ElementCollection
	@CollectionTable(name="EMPLOYEE_IDDETIALS",joinColumns = @JoinColumn(name="EMP_ID",referencedColumnName = "EID"))
	@MapKeyColumn(name="ID_TYPE",length = 20)
	@Column(name="ID_VALUE",length = 20)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Map<String, String> idDetails;
}
