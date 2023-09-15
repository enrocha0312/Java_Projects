package com.mindsim.petroapi.shared;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VariavelResponse {
    private Integer id;
    private String tag;
    private String name;
    private String mfgName;
    private String plataforma;
}
