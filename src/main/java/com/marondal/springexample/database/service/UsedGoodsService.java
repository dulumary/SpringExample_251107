package com.marondal.springexample.database.service;

import com.marondal.springexample.database.domain.UsedGoods;
import com.marondal.springexample.database.repository.UsedGoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 부가적인 기능 수행
// 데이터 가공 처리
@Service
public class UsedGoodsService {

    // 의존성 주입 - DI
    // Spring Framework가 직접 객체 생성 관리
    @Autowired
    private UsedGoodsRepository usedGoodsRepository;

    // 중고 거래 게시글 리스트 얻어오기
    public List<UsedGoods> getUsedGoodsList() {

        // used_goods 모든 행 조회 결과
        List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();

        return usedGoodsList;
    }


}
