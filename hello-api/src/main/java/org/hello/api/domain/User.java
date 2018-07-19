package org.hello.api.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

/**
 *
 * @author: hanqiang
 * @Date: 2018年7月17日
 */
@Data
public class User implements Serializable {
	
	private static final long serialVersionUID = -2843210805539006603L;
	
	private String id;
	private String name;
	private LocalDateTime createdTime;
}
