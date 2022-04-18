/**
 * 描述：测试之用。
 */
package com.cqsd.api;

enum Info {
    VERSION,
    UPDATE_TIME;

    final String value;

    Info() {
        value = "1.0.0";
    }

    public String getValue() {
        return value;
    }
}
