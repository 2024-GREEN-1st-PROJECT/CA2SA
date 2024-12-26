package com.green.ca2sa.menu.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class MenuGetRes {
   private String categoryName;
   private List<MenuGetDto> menu=new ArrayList<>();
}
