package com.oneBillTask1.modifySubscriptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class MappingToTheCSV {

	static int changed=0;
	static int cancel=0;
	static int pricePlan=0;
	
	public static void main(String[] args) {
		Map<String, String> mapping=new HashMap<String, String>();
		mapping.put("subscriber_Account_Number", "Subscriber_Account_Number");
		mapping.put("order_Number","Order_Number");
		mapping.put("action_Type","Action_Type");
		mapping.put("product_Name","Product_Name");
		mapping.put("price_Plan_Name","Price_Plan_Name");
		mapping.put("subscription_Identifier","Subscription_Identifier");
		mapping.put("subscription_Quantity","Subscription_Quantity");
		mapping.put("activation_Date","Activation_Date");
		mapping.put("address_Line1","Address_Line1");
		mapping.put("address_Line2","Address_Line2");
		mapping.put("city","City");
		mapping.put("county","County");
		mapping.put("state","State");
		mapping.put("zip","Zip");
		mapping.put("zipcode_Extension","Zipcode_Extension");
		mapping.put("country","Country");
		mapping.put("address_Attribute_Key","Address_Attribute_Key");
		mapping.put("address_Attribute_Value","Address_Attribute_Value");
		mapping.put("attribute_Block_Start","Attribute_Block_Start");
		mapping.put("attribute","Attribute");
		mapping.put("attribute_Value","Attribute_Value");
		mapping.put("order_Attribute_Block_Start","Order_Attribute_Block_Start");
		mapping.put("order_Attribute_Key","Order_Attribute_Key");
		mapping.put("order_Attribute_Value","Order_Attribute_Value");
		mapping.put("device_Type_Block_Start","Device_Type_Block_Start");
		mapping.put("device_Type","Device_Type");
		mapping.put("device_Id","Device_Id");
		
		
		HeaderColumnNameTranslateMappingStrategy<ModiffySubscriptions> strategy=new HeaderColumnNameTranslateMappingStrategy<ModiffySubscriptions>();
		strategy.setType(ModiffySubscriptions.class);
		strategy.setColumnMapping(mapping);
		
		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("C:\\OneBillTask1\\ModifySubscriptions (3).csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		CsvToBean csvToBean = new CsvToBean(); // to store data

		// calling the parse method of CsvToBean
		// pass strategy, csvReader to parse method
		List<ModiffySubscriptions> list = csvToBean.parse(strategy, csvReader);

		// print details of Bean object
		for (ModiffySubscriptions e : list) {
//			System.out.println(e);
		}

		try {
			FileReader file = new FileReader("C:\\OneBill\\ModifySubscriptions (3).csv");
			BufferedReader Subcription = new BufferedReader(file);
			String row = "";

			while ((row = Subcription.readLine()) != null ) {
				String[] cols = row.split(","); // array of string
//				for (String index : cols) {
//					System.out.printf("%-30s", index); // printf for printing table
//					
//				}
				
//				for (int i = 0; i <cols.length; i++) {
////					String[] index=cols;
//					System.out.print(cols[2]+"   " );
//				}
//				System.out.println(cols[2]+"   " );
				if(cols[2].equalsIgnoreCase("Changed")) {
					changed++;
				}else if (cols[2].equalsIgnoreCase("Cancel")) {
					cancel++;
				}else if (cols[2].equalsIgnoreCase("ChangePriceplan")) {
					pricePlan++;
				}
//			

			}
			System.out.println();

		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println("Changed:-"+changed);
		System.out.println("Cancel:-"+cancel);
		System.out.println("ChangePriceplan:-"+pricePlan);

	}

}