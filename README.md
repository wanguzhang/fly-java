Java 语法

### 泛型

- 泛型可以在类上或方法声明，方法上的泛型优先级高于类上的优先级
- 静态方法不能使用类上泛型声明，只能再方法上声明
- 常用的泛型声明(T，E，K，V，？)
  - ？表示不确定的 java 类型
  - T (type) 表示具体的一个java类型
  - K V (key value) 分别代表java键值中的Key Value
  - E (element) 代表Element
  - S、U、V 等：多参数情况中的第 2、3、4 个类型

### 代码验证

- 泛型可以在类上或方法声明，方法上的泛型优先级高于类上的优先级

```java
package com.fly.study.java.generics;

import org.junit.Before;
import org.junit.Test;

/**
 * @author 张攀钦
 * @date 2019-09-16-00:04
 * @description 泛型验证
 */
public class ClientTest<T> {

    /**
     * 限制方法参数的泛型和返回值类型,泛型优先使用方法上的，当方法上没有使用类上的
     * 不能这样 <K1 super Parent>
     */

    public <T extends ArgsParent, T2 extends ArgsParent> T2 run2(T k) {
        System.out.println(k.getName());
        System.out.println(k);
        return (T2) k;
    }
  

    @Test
    public void test2() {
        System.out.println(clientTest.run2(argsParent));
        System.out.println(clientTest.run2(argsSon));
        // 验证方法上的泛型优先于类上的泛型
        sonClientTest.run2(argsSon);
        // 下面用法错误
        // sonClientTest.run2(son);
    }
}

```

- 静态方法不能使用类上泛型声明，只能再方法上声明

```java
public class ClientTest<T> {
    /**
     * 静态方法上的泛型不能使用类上的，只能再方法上声明泛型
     */
    public static <T extends ArgsParent, T2 extends ArgsParent> void run4(T k) {
        System.out.println(k);
    }
  	
  	// 语法错误
    public static  void run4(T k) {
        System.out.println(k);
    }
}
```

