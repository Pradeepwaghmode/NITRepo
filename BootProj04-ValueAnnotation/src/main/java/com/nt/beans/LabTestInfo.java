package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("info")
@Data
public class LabTestInfo {

	@Value("${lab.bpPrice}")
	private float bloodProfilePrice;
	@Value("${lab.rtpcrPrice}")
	private float rtpcrPrice;
	@Value("${lab.echo2DPrice}")
	private float echo2DPrice;
	
}
