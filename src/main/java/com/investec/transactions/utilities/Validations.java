package com.investec.transactions.utilities;

import org.springframework.stereotype.Component;

@Component
public class Validations {

    public boolean isMobileNumberValid(String number){
        if(number.matches("^\\[+27][0-9]{9}$") || number.matches("^\\[0][0-9]{9}$")  ){
            return true;
        } else {
            return false;
        }
    }


   public static boolean isIdValid(String idNumber)
    {
        int nDigits = idNumber.length();
        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--)
        {
            int d = idNumber.charAt(i) - '0';
            if (isSecond == true)
                d = d * 2;
            nSum += d / 10;
            nSum += d % 10;
            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

}
