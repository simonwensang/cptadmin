package com.cpt.vo;

import lombok.Data;

@Data
public class JsonModel {
	  public Long id;
      public Long pId;
      public String name;
      public Boolean open;
      public Boolean isParent;
      public Boolean checked;
      public String url;
      public String icon;
}
