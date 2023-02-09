package nit.BootSchadulingProj01_UsingJdk;

import java.util.Date;
import java.util.Timer;

import nit.BootSchadulingProj01_UsingJdk.service.Task1;

public class Test {

	public static void main(String[] args) {
		System.out.println("Start of application time::"+new Date());
		Timer t=new Timer();
		//t.scheduleAtFixedRate(new Task1(), 5000, 1000);//period of time
		//t.schedule(new Task1(), new Date((2023-1900), 0, 28, 13, 26, 50));//point of time
		t.schedule(new Task1(), 5000);//point of time
	}

}
