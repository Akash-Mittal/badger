
package com.am.innovations.builder.configurations.yml;

import java.io.Serializable;

public class Travis implements Serializable {

	private Object status;
	private final static long serialVersionUID = 8930122196678162696L;

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

}
