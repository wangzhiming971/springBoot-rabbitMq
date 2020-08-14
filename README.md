# Spring-rabbitMQ
  - 在业务逻辑的异步处理，系统解耦，分布式通信以及控制高并发的场景下，消息队列有着广泛的应用。本项目基于Spring的AMQP模块，整合流行的开源消息队列中间件rabbitMQ,实现一个向rabbitMQ添加和读取消息的功能。并比较了两种模式：生产者-消费者模式和发布-订阅模式的区别。AMQP作为比JMS更加高级的消息协议，支持更多的消息路由和消息模式。
  
- 包含的特性如下：

  ![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/1.png "在这里输入图片标题")
  
1. 如上图，生产者消费者模型：添加了一个队列，并创建了两个消费者用于监听队列消息，我们发现，当有消息到达时，两个消费者会交替收到消息。这一过程虽然不用创建交换机，但会使用默认的交换机，并用默认的直连（default-direct）策略连接队列；

![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/simple.png"在这里输入图片标题")

2. 如下图，发布订阅模型，添加两个队列，分别各用一个消费者监听，设置一个交换机，类型为广播（fanout），交换机会将收到的消息广播给所有相连的队列：

![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/2.png "在这里输入图片标题")
![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/fanout.png  "在这里输入图片标题")
![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/5.png "在这里输入图片标题")

3. direct直连交换机通信模型，包括一个direct交换机，三个binding，两个队列，两个消费者监听器，消息只会被投入到routingkey一致的队列中

 ![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/3.png "3.png")
 ![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/6.png "6.png")
 ![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/direct.png "direct.png")

4.topic主题交换机通信，包括一个topic交换机，三个binding，两个队列，两个消费者监听器，消息只会被投入到routingkey能够匹配的队列中，#表示0个或若干个关键字，*表示一个关键字

![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/4.png "4.png")
![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/topic.png "topic.png")

5. 进入http://localhost:8070/index 可向rabbitMQ发送消息，如下图：
 ![输入图片说明](https://github.com/wangzhiming971/springBoot-rabbitMq/blob/master/src/main/resources/static/img/9.png"QQ截图20170902122553.png")

