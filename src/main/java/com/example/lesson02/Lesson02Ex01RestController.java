package com.example.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lesson02.bo.UsedGoodsBO;
import com.example.lesson02.model.UsedGoods;

@RestController
public class Lesson02Ex01RestController {

	@Autowired
	private UsedGoodsBO usedGoodsBO;	// 스프링 빈을 DI(주입) 받음
	
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {
		List<UsedGoods> usedGoodsList = usedGoodsBO.getUsedGoodsList();
		return usedGoodsList;		// json
	}
}

/*
스프링부트에서 잘 생기는 에러

1. DB연결 xml파일 query 오타 (500)
콘솔에서 ###이 나오면 => DB 에러

2. DAO랑 xml 연결중 주소 오타 (500)
콘솔에서 패키지 부분 주의 - mybatis가 아니라 ibatis로 나오면 => DB 에러
콘솔에서 statement를 찾을수 없다 => DAO 에러 혹은 xml 에러

3. Spring bean으로 어노테이션을 설정 안 한 경우 (서버 비활성화 혹은 500)
dependency 혹은 autowired 가 나오면 어노테이션 설정 잘못
NPE가 나올때 어노테이션 설정 잘못 (spring bean은 null일수 없다)
*/
