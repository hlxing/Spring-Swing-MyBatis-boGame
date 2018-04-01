package com.hlx.config;
/**
 * The regular expression about bo game prize
 * @warn Must format the game result that make the number be sorted in ascending order before using
 * @author hlx
 * @version 1.0 2018-3-16
 *
 */
public class RuleConfig {

    //秀才
    public static final String SHOWPATTERN = "^((?!4).)*4{1}((?!4).)*$";

    //二举
    public static final String LIFTPATTERN = "^((?!4).)*4{1}((?!4).)*4{1}((?!4).)*$";

    //四进
    public static final String ENTERPATTERN = "^\\d*((1{4})|(2{4})|(3{4})|(4{4})|(5{4})|(6{4}))\\d*$";

    //三红
    public static final String REDPATTERN = "^((?!4).)*4{1}((?!4).)*4{1}((?!4).)*4{1}((?!4).)*$";

    //对堂
    public static final String PAIRPATTERN = "123456";

    //状元
    public static final String CHIEFPATTERN = "^\\d*4444\\d*$";

    //五子
    public static final String FIVEPATTERN = "^\\d*((1{5})|(2{5})|(3{5})|(4{5})|(5{5})|(6{5}))\\d*$";

    //六杯红
    public static final String SIXPATTERN = "444444";

    //状元插金花
    public static final String FLOWERPATTERN = "114444";
}
