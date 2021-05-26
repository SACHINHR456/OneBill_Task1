package com.oneBillTask1.modifySubscriptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

public class MappingToTheCSV {

	static int changed = 0;
	static int cancel = 0;
	static int pricePlan = 0;

	public static void main(String[] args) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("subscriber_Account_Number", "Subscriber_Account_Number");
		data.put("order_Number", "Order_Number");
		data.put("action_Type", "Action_Type");
		data.put("product_Name", "Product_Name");
		data.put("price_Plan_Name", "Price_Plan_Name");
		data.put("subscription_Identifier", "Subscription_Identifier");
		data.put("subscription_Quantity", "Subscription_Quantity");
		data.put("activation_Date", "Activation_Date");
		data.put("address_Line1", "Address_Line1");
		data.put("address_Line2", "Address_Line2");
		data.put("city", "City");
		data.put("county", "County");
		data.put("state", "State");
		data.put("zip", "Zip");
		data.put("zipcode_Extension", "Zipcode_Extension");
		data.put("country", "Country");
		data.put("address_Attribute_Key", "Address_Attribute_Key");
		data.put("address_Attribute_Value", "Address_Attribute_Value");
		data.put("attribute_Block_Start", "Attribute_Block_Start");
		data.put("attribute", "Attribute");
		data.put("attribute_Value", "Attribute_Value");
		data.put("order_Attribute_Block_Start", "Order_Attribute_Block_Start");
		data.put("order_Attribute_Key", "Order_Attribute_Key");
		data.put("order_Attribute_Value", "Order_Attribute_Value");
		data.put("device_Type_Block_Start", "Device_Type_Block_Start");
		data.put("device_Type", "Device_Type");
		data.put("device_Id", "Device_Id");

		HeaderColumnNameTranslateMappingStrategy<ModiffySubscriptions> strategy = new HeaderColumnNameTranslateMappingStrategy<ModiffySubscriptions>();
		strategy.setType(ModiffySubscriptions.class);
		strategy.setColumnMapping(data);

		CSVReader csvReader = null;
		try {
			csvReader = new CSVReader(new FileReader("C:\\OneBillTask1\\ModifySubscriptions (3).csv"));

			CsvToBean csvToBean = new CsvToBean(); // to store data

			List<ModiffySubscriptions> list = csvToBean.parse(strategy, csvReader);

			for (ModiffySubscriptions e : list) {
				if (e.getAction_Type().equalsIgnoreCase("Cancel")) {
					cancel++;
				} else if (e.getAction_Type().equalsIgnoreCase("Changed")) {
					changed++;
				} else if (e.getAction_Type().equalsIgnoreCase("ChangePriceplan")) {
					pricePlan++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Changed:-" + changed);
		System.out.println("Cancel:-" + cancel);
		System.out.println("ChangePriceplan:-" + pricePlan);

	}

}
