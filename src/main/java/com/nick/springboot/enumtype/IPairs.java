package com.nick.springboot.enumtype;

/**
 * 通用 枚举规范
 * @author zhangyx
 * @date 2020/2/14
 */
public interface IPairs<C, N, E extends Enum> {
    /**
     * 返回枚举
     * @return 枚举值
     */
    E get();

    /**
     * 获取代码
     * @return 代码
     */
    C getCode();

    /**
     * 获取名称
     * @return 名称
     */
    N getName();

}
