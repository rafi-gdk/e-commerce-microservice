kafka install in docker

consumer - open Intellij terminal & run below commands one by one

> cd kafka-install

> docker-compose -f docker-compose.yml up -d

> docker exec -it kafka /bin/sh

> cd /opt/kafka

> ./bin/kafka-topics.sh --zookeeper zookeeper:2181 --replication-factor 1 --create --topic my-topic --partitions 1

> ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --from-beginning

producer - open Intellij terminal & run below commands one by one

> cd kafka-install

> docker-compose -f docker-compose.yml up -d

> docker exec -it kafka /bin/sh

> cd /opt/kafka

> ./bin/kafka-console-producer.sh --broker-list localhost:9092 --topic my-topic


List All Groups
------------------
> ./bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --list

Create Group
----------------
> ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --consumer-property
> group.id=my-group

Describe Group
------------------
> ./bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group

Delete Group
------------------
Single Group:

> ./bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --delete --group my-group

Multiple Group:

> ./bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --delete --group cg_name_1 --group cg_name_3

List All Consumers
-------------------
> ./bin/kafka-consumer-groups.sh --bootstrap-server localhost:9092 --describe --group my-group --members


List All Topics
-------------------
> ./bin/kafka-topics.sh --list --zookeeper zookeeper:2181

Create Topic
-------------------

Single Partition:
> ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic my-topic

Multiple Partition:
> ./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic my-topic

Describe Topic
------------------
> ./bin/kafka-topics.sh --describe --zookeeper localhost:2181 --topic my-topic

Delete Topic
------------------
> kafka-topics.sh --bootstrap-server kafka:9092 --delete --topic my-topic

OR

> ./bin/kafka-topics.sh --delete --zookeeper localhost:2181 --topic my-topic


Fetch all Messages from Topic
------------------------------
> ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --from-beginning

> ./bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic my-topic --consumer-property
> group.id=my-group


Services:
---------------
Get:

http://localhost:8081/publishMessage/{message}

