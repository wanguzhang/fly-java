package com.fly.study.java;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 张攀钦
 * @date 2019-10-17-20:04
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelRoomDO implements Serializable {
    private static final long serialVersionUID = -471543465548521013L;

    private String name;

    private String level;

    public static void main(String[] args) {
        ModelRoomDO modelRoomDOa1 = new ModelRoomDO("a","1");
        ModelRoomDO modelRoomDOa_1 = new ModelRoomDO("a","1");
        ModelRoomDO modelRoomDOa2 = new ModelRoomDO("a","2");
        ModelRoomDO modelRoomDOb1 = new ModelRoomDO("b","1");
        ModelRoomDO modelRoomDOb2 = new ModelRoomDO("b","2");

        List<ModelRoomDO> modelRoomDOS =new ArrayList<>();
        modelRoomDOS.add(modelRoomDOa_1);
        modelRoomDOS.add(modelRoomDOa1);
        modelRoomDOS.add(modelRoomDOa2);
        modelRoomDOS.add(modelRoomDOb1);
        modelRoomDOS.add(modelRoomDOb2);


        Map<String, String> collect = modelRoomDOS.stream()
                .distinct()
                .collect(Collectors.groupingBy(item -> item.getName(),
                        HashMap::new,
                        Collectors.mapping(ModelRoomDO::getLevel, Collectors.joining(";"))));

        final Map<String, List<ModelRoomDO>> collect1 = modelRoomDOS.stream()
                .distinct()
                .collect(Collectors.groupingBy(item -> item.getName()));


        List<ModelRoomDO> modelRoomDOS2 =new ArrayList<>();
        for (Map.Entry<String, String> stringStringEntry : collect.entrySet()) {
            final String key = stringStringEntry.getKey();
            final String value = stringStringEntry.getValue();
            ModelRoomDO modelRoomDO = new ModelRoomDO(key,value);
            modelRoomDOS2.add(modelRoomDO);
        }

        System.out.println(modelRoomDOS2);
    }

    
}
