package com.hlx.service;

import com.hlx.config.PrizeEnum;
import com.hlx.config.RuleConfig;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * A recognize service that format and recognize the game result
 * @author hlx
 * @version 1.0 2018-3-16
 */
@Service
public class RecognitionServiceImpl implements RecognitionService{

    private static final Logger logger = Logger.getLogger(RecognitionServiceImpl.class);

    public PrizeEnum recognize(String result) {
        String formatResult = formatResult(result);
        logger.info(formatResult);
        if (Pattern.matches(RuleConfig.FLOWERPATTERN, formatResult)) {
            return PrizeEnum.FLOWER;
        } else if (Pattern.matches(RuleConfig.SIXPATTERN, formatResult)) {
            return PrizeEnum.SIX;
        } else if (Pattern.matches(RuleConfig.FIVEPATTERN, formatResult)) {
            return PrizeEnum.FIVE;
        }else if (Pattern.matches(RuleConfig.CHIEFPATTERN, formatResult)) {
            return PrizeEnum.CHIEF;
        } else if (Pattern.matches(RuleConfig.PAIRPATTERN, formatResult)) {
            return PrizeEnum.PAIR;
        } else if (Pattern.matches(RuleConfig.REDPATTERN, formatResult)) {
            return PrizeEnum.RED;
        } else if (Pattern.matches(RuleConfig.ENTERPATTERN, formatResult)) {
            return PrizeEnum.ENTER;
        } else if (Pattern.matches(RuleConfig.LIFTPATTERN, formatResult)) {
            return PrizeEnum.LIFT;
        } else if (Pattern.matches(RuleConfig.SHOWPATTERN, formatResult)) {
            return PrizeEnum.SHOW;
        }else{
            return PrizeEnum.BLANK;
        }

    }


    private String formatResult(String result) {
        int[] resultNum = new int[result.length()];
        for(int i=0;i<result.length();i++) {
            resultNum[i] = Character.getNumericValue(result.charAt(i));
        }
        Arrays.sort(resultNum);
        return Arrays.toString(resultNum)
                .replaceAll("(\\[|]|, )","");
    }
}
