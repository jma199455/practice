package com.example.demo.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ResultBuilder {

	public static final String MESSAGE_PREFIX = "error.message.";
	public static final String SUCCESS = "200";
	public static final String FAIL = "500";

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ObjectMapper objectMapper;

	@Value("spring.profiles.active")
	private String profile;

	/**
	 * 입력 값이 0이상일 경우 success code를 반환
	 * 
	 * @param  returnData
	 * @return            ResultVO
	 */
	public ResultVO resultForCount(int returnData) {
		if(returnData > 0) {
			ResultVO resultVO = new ResultVO(SUCCESS);
			resultVO.getHeader().setResponseMsg(messageSource.getMessage(MESSAGE_PREFIX + SUCCESS, null, LocaleContextHolder.getLocale()));
			printResult(resultVO);
			return resultVO;
		}
		else {
			throw new FailedDataSaveException();
		}
	}

	/**
	 * boolean값에 따라 success code를 반환
	 * 
	 * @param  returnData
	 * @return            ResultVO
	 */
	public ResultVO resultForZeroCount(boolean returnData) {
		ResultVO resultVO = new ResultVO(FAIL);
		if(returnData) {
			resultVO.getHeader().setResponseCode(SUCCESS);
		}
		resultVO.getHeader()
				.setResponseMsg(messageSource.getMessage(MESSAGE_PREFIX + resultVO.getHeader().getResponseCode(), null, LocaleContextHolder.getLocale()));
		printResult(resultVO);
		return resultVO;
	}

	/**
	 * object 리턴
	 * 
	 * @param  returnData
	 * @return            ResultVO
	 */

	 /*  
	public ResultVO resultForObject(String returnKey, Object returnData) {
		if(ObjectUtils.isEmpty(returnData)) {
			throw new NoDataException();
		}
		else {
			Map<String, Object> map = new HashMap<>();
			map.put(returnKey, returnData);

			return resultForObjectAll(map);
		}
	}
	*/

	/**
	 * 항상 성공으로 리턴
	 * 
	 * @param  returnData
	 * @return            ResultVO
	 */
	
	public ResultVO resultForObjectAll(Object returnData) {
		if(ObjectUtils.isEmpty(returnData)) {
			throw new NoDataException();
		}
		else {
			ResultVO resultVO = new ResultVO(FAIL);
			resultVO.getHeader().setResponseCode(SUCCESS);
			resultVO.setBody(returnData);
			resultVO.getHeader()
					.setResponseMsg(messageSource.getMessage(MESSAGE_PREFIX + resultVO.getHeader().getResponseCode(), null, LocaleContextHolder.getLocale()));
			printResult(resultVO);
			return resultVO;
		}
	}
	

	/**
	 * Exception이 발생했을 경우 호출하는 함수<br>
	 * 항상 error를 반환하며 message code를 통해 message를 생성하여 ResultVO에 삽입 후 반환<br>
	 * messageCode가 null 일 경우 errorResponseMsg는 전송하지 않는다.
	 * 
	 * @param  messageCode
	 * @param  messageArgs
	 * @return             ResultVO
	 */
	public ResultVO resultForException(String errorCode, String messageCode, String... messageArgs) {
		ResultVO resultVO = new ResultVO(errorCode);
		if(messageCode != null) {
			resultVO.getHeader().setResponseMsg(messageSource.getMessage(messageCode, messageArgs, LocaleContextHolder.getLocale()));
		}
		printResult(resultVO);
		return resultVO;
	}

	/**
	 * error code를 통해 message를 생성하여 ResultVO에 삽입 후 반환<br>
	 * 
	 * @param  errorCode
	 * @param  message
	 * @return           ResultVO
	 */
	public ResultVO resultForException(String errorCode) {
		return resultForException(errorCode, MESSAGE_PREFIX + errorCode);
	}

	/**
	 * ResultVO에 errorCode와 meassge 삽입 후 반환<br>
	 * 
	 * @param  errorCode
	 * @param  message
	 * @param  b
	 * @return           ResultVO
	 */
	public ResultVO resultForException(String errorCode, String message, boolean b/* 구분용 가짜 값 */) {
		ResultVO resultVO = new ResultVO(errorCode);
		resultVO.getHeader().setResponseMsg(message);
		printResult(resultVO);
		return resultVO;
	}

	private void printResult(ResultVO resultVO) {
		try {
			log.info("############################ Response ResultVO  ############################");
			log.info(objectMapper.writeValueAsString(resultVO));
			log.info("############################################################################");
		}
		catch(JsonProcessingException e) {
			log.error("", e);
		}
	}

}
