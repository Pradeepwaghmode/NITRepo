package com.nt.modal;

public class Employee {

	private Integer eno;
	private String name;
	private String desg;
	private Float netSalary;
	public Integer getEno() {
		return eno;
	}
	public void setEno(Integer eno) {
		this.eno = eno;
	}
	public String geteName() {
		return name;
	}
	public void setName(String eName) {
		this.name = eName;
	}
	public String getDesg() {
		return desg;
	}
	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + ", desg=" + desg + ", netSalary=" + netSalary + "]";
	}
	public void setDesg(String desg) {
		this.desg = desg;
	}
	public Float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Float netSalary) {
		this.netSalary = netSalary;
	}
}
