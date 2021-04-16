package com.example.service_outsourcing.utils;


import com.example.service_outsourcing.entity.User;
import com.example.service_outsourcing.mapper.*;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author HGP
 * @create 2020/9/11 20:32
 */
@Log
@Slf4j
@Component
public class GenerateIdUtil<T> {

    @SneakyThrows
    public String getRandomId(T t, String prefix) {
        StringBuilder stringBuilder = new StringBuilder(prefix);
        String num;
        Class interfaceImpl = t.getClass();
        Method method = interfaceImpl.getMethod("selectByPrimaryKey", String.class);
        do {
            Random random = new Random();
            int randomNum = random.nextInt(89999999);
            int intNum = randomNum + 10000000;
            num = String.valueOf(intNum);
        } while (method.invoke(t, num) != null);
        stringBuilder.append(num);
        return stringBuilder.toString();
    }

}
