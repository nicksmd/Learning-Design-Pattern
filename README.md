# Learning-Design-Pattern
Repository for my Design Pattern Learning.

**Book**: [Head First Design Patterns. A Brain-Friendly Guide] . By Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra

# 17/05/2017

![alt text](https://raw.githubusercontent.com/nicksmd/Learning-Design-Pattern/master/DesignPatterns/medias/Stratery%20pattern.PNG "Strategy Pattern")

**The Strategy pattern** defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from clients that use it.

- ##### Principle 1: Identify the aspects of your app that vary and separate them from what stays the same
- ##### Principle 2: Program to an interface, not an implementation
- ##### Principle 3: Favor composition over inheritance 

[Head First Design Patterns. A Brain-Friendly Guide]: <http://shop.oreilly.com/product/9780596007126.do>

# 18/05/2017
![Observer Pattern](https://github.com/nicksmd/Learning-Design-Pattern/blob/master/DesignPatterns/medias/18555114_856626651151088_1476365090_n.jpg?raw=true)

**Dummy Questions:**
* Why do we need to store a ref to Observable in Observers?
:trollface: In the future, we may want to un-register ourselves as an observer
* Why Observer Pattern provide us a loosely coupled system?
:trollface:
    * We can add new observers anytime
    * Changes to either the Observable or Observer will not affect the other
    * No need to modify Observable to add new type of Observer: we just need to create a new class and implement Observer interface on it.



