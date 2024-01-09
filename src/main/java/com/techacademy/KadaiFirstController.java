package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable String val1) {
        String yyyy = val1.substring(0,4);
        String mm = val1.substring(4,6);
        String dd = val1.substring(val1.length()-2);

        int year= Integer.parseInt(yyyy);
        int month= Integer.parseInt(mm);
        int date= Integer.parseInt(dd);


        Calendar calendar = Calendar.getInstance();
        calendar.set(year,month-1,date);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String dayOfWeekStr = "";

        switch(dayOfWeek) {
        case Calendar.SUNDAY: dayOfWeekStr = "Sunday"; break;
        case Calendar.MONDAY: dayOfWeekStr = "Monday"; break;
        case Calendar.TUESDAY: dayOfWeekStr = "Tuesday"; break;
        case Calendar.WEDNESDAY: dayOfWeekStr = "Wednesday"; break;
        case Calendar.THURSDAY: dayOfWeekStr = "Thursday"; break;
        case Calendar.FRIDAY: dayOfWeekStr = "Friday"; break;
        case Calendar.SATURDAY: dayOfWeekStr = "Saturday"; break;
        }
        return dayOfWeekStr;
    }

    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 + val2;

        return "計算結果：" + result;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 - val2;

        return "計算結果：" + result;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 * val2;

        return "計算結果：" + result;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int result = val1 / val2;

        return "計算結果：" + result;
    }
}

