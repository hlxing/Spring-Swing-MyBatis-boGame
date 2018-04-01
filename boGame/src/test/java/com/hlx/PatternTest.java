package com.hlx;

import com.hlx.config.RuleConfig;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.util.regex.Pattern;

/**
 * A test about bo game rule
 * @author hlx
 * @version 1.0 2018-3-16
 */
public class PatternTest {

    private static final Logger logger = Logger.getLogger(PatternTest.class);

    @Test
    public void testShow() {
        logger.info(Pattern.matches(RuleConfig.SHOWPATTERN,"114141"));
        logger.info(Pattern.matches(RuleConfig.SHOWPATTERN,"123346"));
        logger.info(Pattern.matches(RuleConfig.SHOWPATTERN,"323453"));
        logger.info(Pattern.matches(RuleConfig.SHOWPATTERN,"423351"));
    }

    @Test
    public void testLift() {
        logger.info(Pattern.matches(RuleConfig.LIFTPATTERN,"441234"));
        logger.info(Pattern.matches(RuleConfig.LIFTPATTERN,"221244"));
        logger.info(Pattern.matches(RuleConfig.LIFTPATTERN,"241422"));
        logger.info(Pattern.matches(RuleConfig.LIFTPATTERN,"441232"));
    }

    @Test
    public void testRed() {
        logger.info(Pattern.matches(RuleConfig.REDPATTERN,"124444"));
        logger.info(Pattern.matches(RuleConfig.REDPATTERN,"444123"));
        logger.info(Pattern.matches(RuleConfig.REDPATTERN,"141424"));
        logger.info(Pattern.matches(RuleConfig.REDPATTERN,"123444"));
    }

    @Test
    public void testFive() {
        logger.info(Pattern.matches(RuleConfig.FIVEPATTERN,"111122"));
        logger.info(Pattern.matches(RuleConfig.FIVEPATTERN,"344444"));
    }


}
