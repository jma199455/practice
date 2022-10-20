package com.example.demo.result;

import lombok.Data;
import lombok.ToString;

/**
 * Ajax 요청을 처리하기 위한 공통 Object<br>
 * 기본적으로 {@link resultBuilder}를 통한 반환을 권장<br>
 * 생성자를 이용해 객체 생성 시 resultType이 항상 fail로 설정됨을 주의<br>
 */
@Data
@ToString
public class ResultVO {

	private Header header;
	private Object body;

	public ResultVO(String responseCode) {
		this.header = new Header(responseCode);
	}

	@Data
	public class Header {
		private String responseCode;
		private String responseMsg;
		
		public Header(String responseCode) {
			this.responseCode = responseCode;
		}
	}
}
