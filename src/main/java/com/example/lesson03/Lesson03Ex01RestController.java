package com.example.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson03.bo.ReviewBO;
import com.example.lesson03.model.Review;

@RestController
public class Lesson03Ex01RestController {

	@Autowired
	private ReviewBO reviewBO;
	
	// http://localhost/lesson03/ex01?id=
	@RequestMapping("/lesson03/ex01")
	public Review ex01(
			@RequestParam("id") int id) {
			//@RequestParam(value="id") int id) {						// @RequestParam이면 필수 파라미터
			//@RequestParam(value="id", required=true) int id) {		// required=true => 파라미터 필수 (기본값도 필수로 되어있다.)
			//@RequestParam(value="id", required=false) Integer id) {	// required=false => 파라미터 필수X
			//@RequestParam(value="id", defaultValue="1") int id) {	
			// defaultValue="1" => 파라미터 필수X일 경우 기본값으로 설정 (required=false) 생략 가능
		
//		if(id == null) {
//			return null;
//		} else {
			return reviewBO.getReview(id);
//		}
	}
}
/*
 	Error => TooManyResultsException: 실제 데이터(쿼리)와 output이 다름
 */

