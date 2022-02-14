package com.zap.office.commonutils;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author: ZhuApeng
 * @Title: GetRandom
 * @ProjectName: OfficeRelation
 * @Description:
 * @date: 2021/12/3 21:01
 */

public class GetRandom {
    private static final Random random = new Random();
    private static final DecimalFormat fourNum = new DecimalFormat("0000");
    private static final DecimalFormat sixNum = new DecimalFormat("000000");

    //生成4位随机数
    public static String getFourBitRandom() {
        return fourNum.format(random.nextInt(10000));
    }
    //生成6位随机数
    public static String getSixBitRandom() {
        return sixNum.format(random.nextInt(1000000));
    }
}
