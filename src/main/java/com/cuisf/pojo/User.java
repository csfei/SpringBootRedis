package com.cuisf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
// 所有的对象 都要会序列化
public class User implements Serializable {

    private  String name;

    private int age;
}
