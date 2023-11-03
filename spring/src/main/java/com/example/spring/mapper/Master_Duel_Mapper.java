package com.example.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Master_Duel_Mapper<MasterDuel> {

    @Select("SELECT * FROM September;")
    List<MasterDuel> findAll();

    @Insert("INSERT INTO September (Deck, Tier) VALUES (#{deck}, #{tier});")
    int insertResultSeptember();

    @Insert("INSERT INTO August (Deck, Tier) VALUES (#{deck}, #{tier});")
    int insertResultAugust();

}
