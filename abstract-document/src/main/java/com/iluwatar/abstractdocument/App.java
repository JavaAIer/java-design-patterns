/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.abstractdocument;

import com.iluwatar.abstractdocument.domain.Car;
import com.iluwatar.abstractdocument.domain.HasModel;
import com.iluwatar.abstractdocument.domain.HasParts;
import com.iluwatar.abstractdocument.domain.HasPrice;
import com.iluwatar.abstractdocument.domain.HasType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 抽象文档模式可用于处理附加的、非静态的属性。此模式使用特征的概念来启用类型安全性，
 * 并将不同类的属性分离到一组接口中。
 * <p>
 * <p>
 * 在抽象文档模式中,({@link AbstractDocument}) 完全实现了
 * {@link Document}) 接口. 然后定义get和set(特性)，以支持以通常的静态方式访问属性。
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * 执行应用程序
   */
  public App() {
    LOGGER.info("创建零件和车");

    Map<String, Object> carProperties = new HashMap<>();
    carProperties.put(HasModel.PROPERTY, "300SL");
    carProperties.put(HasPrice.PROPERTY, 10000L);

    Map<String, Object> wheelProperties = new HashMap<>();
    wheelProperties.put(HasType.PROPERTY, "wheel");
    wheelProperties.put(HasModel.PROPERTY, "15C");
    wheelProperties.put(HasPrice.PROPERTY, 100L);

    Map<String, Object> doorProperties = new HashMap<>();
    doorProperties.put(HasType.PROPERTY, "door");
    doorProperties.put(HasModel.PROPERTY, "Lambo");
    doorProperties.put(HasPrice.PROPERTY, 300L);

    carProperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

    Car car = new Car(carProperties);

    LOGGER.info("Here is our car:");
    LOGGER.info("-> model: {}", car.getModel().get());
    LOGGER.info("-> price: {}", car.getPrice().get());
    LOGGER.info("-> parts: ");
    car.getParts().forEach(p -> LOGGER.info("\t{}/{}/{}", p.getType().get(), p.getModel().get(), p.getPrice().get()));
  }

  /**
   * 程序入口
   *
   * @param args 命令行参数
   */
  public static void main(String[] args) {
    new App();
  }

}
