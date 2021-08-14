package io.github.viniciussantos02.clientes.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class BigDecimalConverter {
	
	public static BigDecimal convert(String pValue) {
		if(pValue == null){
			return null;
		}
		
		pValue = pValue.replace(".", "").replace(",", ".");
		
		return new BigDecimal(pValue);
	}
}
