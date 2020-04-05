package com.sample.mathematicaldemo.service;






import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

	


import com.sample.mathematicaldemo.model.calculation;




@Service
public class mathematicalService {
    

	JdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}
	

       

	public Integer getResult(int operand1, int operand2, String operation) {

		Integer result = null;
		if (operation.equalsIgnoreCase("addition")) {

			result = (int) (operand1 + operand2 + 2);

		} else if (operation.equalsIgnoreCase("subtraction")) {

			result = (int) (operand1 - operand2);

		} else if (operation.equalsIgnoreCase("multiplication")) {

			result = (int) (operand1 * operand2);

		} else if (operation.equalsIgnoreCase("division")) {

			if (operand2 != 0) {

				result = (int) (operand1 / operand2);

			}

		} else if (operation.equalsIgnoreCase("square")) {

			result = (int) (operand1 * operand1);

		} else {
			result = null;
		}
		
		calculation cal = new calculation();
		cal.setOperand1(operand1);
		if (!operation.equalsIgnoreCase("square"))
			cal.setOperand2(operand2);
		else {
			cal.setOperand2(0);;
		}
		cal.setOperation(operation);
		cal.setResult(result);
		
		String sql = "truncate calculation";
		template.update(sql);
		
String sql1 = "insert into calculation(operand1,operand2,operation,result) values ("+cal.getOperand1()+","+cal.getOperand2()+",'"+cal.getOperation()+"',"+cal.getResult()+")";
       	
	    template.update(sql1);
	    
                
		return result;

	}
        
       

	}


