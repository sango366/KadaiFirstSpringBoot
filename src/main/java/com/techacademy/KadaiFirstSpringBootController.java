package com.techacademy;

import java.util.Calendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KadaiFirstSpringBootController {

    @GetMapping("/")
    public String index() {
        return "Hello SpringBoot!!!!";
    }

    //指定日の曜日を算定する
    @GetMapping("/dayofweek/{val1}")
    public String dispDayOfWeek(@PathVariable String val1) {
        String ymd = val1;
        int year = Integer.parseInt(ymd.substring(0,4));
        int month = Integer.parseInt(ymd.substring(4,6));
        int day = Integer.parseInt(ymd.substring(6));

        Calendar calendar = Calendar.getInstance();
        //Calendarクラスの月の指定が0始まりのため、引数で-1をする
        calendar.set(year, month -1, day);
        int dayOfWeek_temp = calendar.get(Calendar.DAY_OF_WEEK);
        String dayOfWeek = "";
        if (dayOfWeek_temp == 1){
            dayOfWeek = "Sunday";
        }
        else if (dayOfWeek_temp == 2){
            dayOfWeek = "Monday";
        }
        else if (dayOfWeek_temp == 3){
            dayOfWeek = "Tuesday";
        }
        else if (dayOfWeek_temp == 4){
            dayOfWeek = "Wednesday";
        }
        else if (dayOfWeek_temp == 5){
            dayOfWeek = "Thursday";
        }
        else if (dayOfWeek_temp == 6){
            dayOfWeek = "Friday";
        }
        else if (dayOfWeek_temp == 7){
            dayOfWeek = "Saturday";
        }
        return "実行結果：" + dayOfWeek;
    }

    //四則演算を行う
    @GetMapping("/plus/{val1}/{val2}")
    public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 + val2;
        return "計算結果：" + res;
    }

    @GetMapping("/minus/{val1}/{val2}")
    public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 - val2;
        return "計算結果：" + res;
    }

    @GetMapping("/times/{val1}/{val2}")
    public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 * val2;
        return "計算結果：" + res;
    }

    @GetMapping("/divide/{val1}/{val2}")
    public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
        int res = 0;
        res = val1 / val2;
        return "計算結果：" + res;
    }
}
