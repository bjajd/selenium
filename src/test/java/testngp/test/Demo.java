package testngp.test;

import java.io.IOException;
import java.util.ArrayList;

public class Demo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven dt=new dataDriven();
		ArrayList<String> data= dt.getData();
		System.out.println(data.get(1));
		

	}

}
