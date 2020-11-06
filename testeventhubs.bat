@echo off
rem change the follwing variables to your event hubs configuration
rem you can also adjust the path to the program jar

set bootstrap_servers=xxxxxxxxxxxxxxx:9093
set topic=yyyyyyyy
set jaas_config="org.apache.kafka.common.security.plain.PlainLoginModule required username=\"$ConnectionString\" password=\"zzzzzzzzzzzzzzzzzzz"

.\bin\spark-submit  --class TestEventHubs  --master local[1] .\POC-Spark-EventHubs-0.0.1-SNAPSHOT-jar-with-dependencies.jar %bootstrap_servers%  %topic% %jaas_config%