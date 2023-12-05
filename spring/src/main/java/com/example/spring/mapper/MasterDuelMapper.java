package com.example.spring.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.spring.controller.Deck;

@Mapper
public interface MasterDuelMapper<MasterDuel> {

    @Select("SELECT * FROM September;")
    List<Deck> findAll();

    @Insert("INSERT INTO September (Deck, Tier) VALUES (#{deck}, #{tier});")
    int insertResultSeptember();

    @Insert("INSERT INTO August (Deck, Tier) VALUES (#{deck}, #{tier});")
    int insertResultAugust();

    @Update("UPDATE November SET Tier = #{tier} WHERE Deck = #{deck}")
    void updateDeck(@Param("deck") String deck, @Param("tier") String updatedTier);

}
