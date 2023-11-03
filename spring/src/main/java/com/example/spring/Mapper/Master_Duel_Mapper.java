package com.example.spring.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Master_Duel_Mapper {

    @Insert("INSERT INTO September (Deck,int Tier) VALUES (#{deck},#{tier});")
    int insertResultSeptember();

    @Insert("INSERT INTO August (Deck,int Tier) VALUES ((#{deck},#{tier});")
    int insertResultAugust();
}
