package com.hvscode.iperf3test.service.impl;

import com.hvscode.iperf3test.GeneralException;
import com.hvscode.iperf3test.Iperf;
import com.hvscode.iperf3test.annotations.IperfOption;
import com.hvscode.iperf3test.service.IperfService;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Optional;

import lombok.NonNull;

public class IperfServiceImpl implements IperfService {



    @Override
    public String buildCommand(Iperf iperf) {

        StringBuilder builder = new StringBuilder();

        builder.append("iperf3");
        builder.append(" ");

        for (Field field : iperf.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            IperfOption iperfOption = field.getAnnotation(IperfOption.class);
            Optional.ofNullable(iperfOption).ifPresent(option -> {

                //String name = getOptionName(field, iperfOption);
                //if (Optional.ofNullable(options.get(name)).isPresent()) {
                String value = null;
                try {
                    if (!option.withValue()) {

                        boolean present = field.getBoolean(iperf);
                        if (present) {

                            builder.append(option.command());
                            builder.append(" ");

                        }


                    } else {

                        value = (String) field.get(iperf);
                        Optional.ofNullable(value).ifPresent(val -> {
                            if (val.trim().isEmpty())
                                throw new GeneralException(String.format("field %s is empty, the value should be not empty", option.name(), option.withValue()));
                            builder.append(option.command());
                            builder.append(" ");
                            builder.append(val);
                            builder.append(" ");

                        });


                    }
                } catch (IllegalAccessException e) {
                        e.printStackTrace();
                }

            });



        }

        return builder.toString();
    }



    public void processOptions(HashMap<String, String> options, @NonNull Iperf iperf){

        Optional.ofNullable(options).ifPresent(opt -> {

                        for (Field declaredField : iperf.getClass().getDeclaredFields()) {

                            declaredField.setAccessible(true);
                            IperfOption iperfOption = declaredField.getAnnotation(IperfOption.class);
                            String name = getOptionName(declaredField, iperfOption);

                            String value = options.get(name);
                            try {
                                if (declaredField.getType().getSimpleName().equals(boolean.class.getName())) {
                                    declaredField.set(iperf, true);

                                } else if (Optional.ofNullable(value).isPresent()) {

                                    declaredField.set(iperf, value);

                                }

                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }

                        }
        });

    }

    public String getOptionName(Field field, IperfOption iperfOption){
        return  (!Optional.ofNullable(iperfOption.name()).isPresent() || iperfOption.name().trim().isEmpty()) ? field.getName() : iperfOption.name();
    }

    @Override
    public String validateParams() throws GeneralException {

        //Optional.ofNullable(iperf).orElseThrow(GeneralException::new);


        return null;

    }
}

