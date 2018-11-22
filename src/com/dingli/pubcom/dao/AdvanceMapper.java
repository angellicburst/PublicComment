package com.dingli.pubcom.dao;

import com.dingli.pubcom.bean.Advance;
import com.dingli.pubcom.bean.AdvanceExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AdvanceMapper {
	
	List<Advance> selectAll(Advance advance);
	
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int countByExample(AdvanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int deleteByExample(AdvanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int insert(Advance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int insertSelective(Advance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    List<Advance> selectByExample(AdvanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    Advance selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByExampleSelective(@Param("record") Advance record, @Param("example") AdvanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByExample(@Param("record") Advance record, @Param("example") AdvanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByPrimaryKeySelective(Advance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ad
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByPrimaryKey(Advance record);
}