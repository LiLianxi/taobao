package com.taobao.order.common.constants;

/**
 * @author Lawrence Li
 * @date 2020/9/9 3:37 PM
 */
public abstract class RegexPatterns {
    /**
     * phone number regex
     */
    public static final String PHONE_REGEX = "^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\\d{8}$";
    /**
     * Email account regex
     */
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
    /**
     * username regex
     */
    public static final String USERNAME_REGEX = "^\\w{4,32}$";

    /**
     *  numeric regex
     */
    public static final String NUMERIC_REGEX = "^[0-9]*$";

    /**
     *  china mainland phone regex
     */
    public static final String CHINA_MAINLAND_PHONE_REGEX = "^[1]\\d{10}$";

}
