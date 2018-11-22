package com.dingli.pubcom.dao;

import com.dingli.pubcom.bean.DicType;
import com.dingli.pubcom.bean.DicTypeExample;
import com.dingli.pubcom.bean.DicTypeKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DicTypeMapper {
	
	List<DicType> selectByType(DicType type);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int countByExample(DicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int deleteByExample(DicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int deleteByPrimaryKey(DicTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int insert(DicType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int insertSelective(DicType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    List<DicType> selectByExample(DicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    DicType selectByPrimaryKey(DicTypeKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByExampleSelective(@Param("record") DicType record, @Param("example") DicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByExample(@Param("record") DicType record, @Param("example") DicTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByPrimaryKeySelective(DicType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table dic
     *
     * @mbggenerated Wed Aug 15 14:28:46 CST 2018
     */
    int updateByPrimaryKey(DicType record);
}