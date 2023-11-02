package com.alibaba.xingchen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerVariable {

    public String description;
    public String defaultValue;
    public HashSet<String> enumValues = null;
}
