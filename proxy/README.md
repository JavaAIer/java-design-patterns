---
layout: pattern
标题: Proxy
文件夹: proxy
永久链接: /patterns/proxy/
分类: Structural（构造）
tags:
 - Java
 - Gang Of Four
 - 入门难度
---

## 又叫做
Surrogate（代理的; 代理的;）

## 设计目的
Provide a surrogate or placeholder for another object to control
access to it.
为另一个对象提供代理或占位符，以控制对它的访问。



## Explanation 解释 
Real world example

> Imagine a tower where the local wizards go to study their spells. The ivory tower can only be accessed through a proxy which ensures that only the first three wizards can enter. Here the proxy represents the functionality of the tower and adds access control to it.

生活中例子
> 想象一下当地巫师去研究他们的法术的塔。象牙塔只能通过代理进入，确保只有前三个巫师可以进入。这里代理表示塔的功能并为其添加访问控制（我看得云里雾里）。



In plain words

> Using the proxy pattern, a class represents the functionality of another class.

简单点说

> 使用代理模式，是使用一个类来表示另外一个类的功能.

Wikipedia says

> A proxy, in its most general form, is a class functioning as an interface to something else. A proxy is a wrapper or agent object that is being called by the client to access the real serving object behind the scenes. Use of the proxy can simply be forwarding to the real object, or can provide additional logic. In the proxy extra functionality can be provided, for example caching when operations on the real object are resource intensive, or checking preconditions before operations on the real object are invoked.

维基百科这样说：
> 代理其最常见的形式，是一个用做其他类的接口的类。代理是一个包装器或代理对象，客户端调用它来访问幕后的真实服务对象。使用代理可以简单地转发调用到真实对象，或者可以提供额外的逻辑。在代理中，可以提供额外的功能，例如当对真实对象的操作是资源密集时的先进行高速缓存，或者在调用对象的操作之前检查先决条件。

**Programmatic Example**

Taking our wizard tower example from above. Firstly we have the wizard tower interface and the ivory tower class

**示例程序**
拿我们前面举的向导塔为例。首先我们要创建一个向导塔接口WizardTower和一个象牙塔类IvoryTower：

```java
public interface WizardTower {

  void enter(Wizard wizard);
}

public class IvoryTower implements WizardTower {

  private static final Logger LOGGER = LoggerFactory.getLogger(IvoryTower.class);

  public void enter(Wizard wizard) {
    LOGGER.info("{} enters the tower.", wizard);
  }

}
```

Then a simple wizard class
然后写一个简单的向导类

```java
public class Wizard {

  private final String name;

  public Wizard(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
```

Then we have the proxy to add access control to wizard tower
然后我们要写一个代理类来实现对向导类的访问控制

```java
public class WizardTowerProxy implements WizardTower {

  private static final Logger LOGGER = LoggerFactory.getLogger(WizardTowerProxy.class);

  private static final int NUM_WIZARDS_ALLOWED = 3;

  private int numWizards;

  private final WizardTower tower;

  public WizardTowerProxy(WizardTower tower) {
    this.tower = tower;
  }

  @Override
  public void enter(Wizard wizard) {
    if (numWizards < NUM_WIZARDS_ALLOWED) {
      tower.enter(wizard);
      numWizards++;
    } else {
      LOGGER.info("{} is not allowed to enter!", wizard);
    }
  }
}
```

And here is tower entering scenario
下面是塔进入的场景：

```java
WizardTowerProxy proxy = new WizardTowerProxy(new IvoryTower());
proxy.enter(new Wizard("Red wizard")); // Red wizard enters the tower.
proxy.enter(new Wizard("White wizard")); // White wizard enters the tower.
proxy.enter(new Wizard("Black wizard")); // Black wizard enters the tower.
proxy.enter(new Wizard("Green wizard")); // Green wizard is not allowed to enter!
proxy.enter(new Wizard("Brown wizard")); // Brown wizard is not allowed to enter!
```

## Applicability
Proxy is applicable whenever there is a need for a more
versatile or sophisticated reference to an object than a simple pointer. Here
are several common situations in which the Proxy pattern is applicable

* Remote proxy provides a local representative for an object in a different address space.
* Virtual proxy creates expensive objects on demand.
* Protection proxy controls access to the original object. Protection proxies are useful when objects should have different access rights.

## 适用性
只要需要比简单指针更通用或更复杂的对象引用，代理就适用。以下是代理模式适用的几种常见情况
* 远程代理为不同地址空间中的对象提供本地代表。
* 虚拟代理按需创建昂贵的对象。
* 保护代理控制对原始对象的访问：当对象具有不同的访问权限时，保护代理很有用。

## Typical Use Case

* Control access to another object
* Lazy initialization
* Implement logging
* Facilitate network connection
* Count references to an object

## 典型用例
* 控制对另一个对象的访问
* 延迟初始化
* 实施日志记录
* 方便网络连接
* 计算对象的引用

## Tutorials
* [Controlling Access With Proxy Pattern](http://java-design-patterns.com/blog/controlling-access-with-proxy-pattern/)

## 教程
* [使用代理模式控制访问（权限）](http://java-design-patterns.com/blog/controlling-access-with-proxy-pattern/)

## Presentations
* [Proxy](https://github.com/iluwatar/java-design-patterns/tree/master/proxy/etc/presentation.html)

## 演讲
* [代理模式](https://github.com/iluwatar/java-design-patterns/tree/master/proxy/etc/presentation.html)

## Real world examples

* [java.lang.reflect.Proxy](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html)
* [Apache Commons Proxy](https://commons.apache.org/proper/commons-proxy/)
* Mocking frameworks Mockito, Powermock, EasyMock

## 典型例子

* [java.lang.reflect.Proxy](http://docs.oracle.com/javase/8/docs/api/java/lang/reflect/Proxy.html)
* [Apache Commons Proxy](https://commons.apache.org/proper/commons-proxy/)
* 模拟框架： Mockito, Powermock, EasyMock

## Credits

* [Design Patterns: Elements of Reusable Object-Oriented Software](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)

## 鸣谢

* [设计模式: 可重用面向对象软件的元素](http://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)

