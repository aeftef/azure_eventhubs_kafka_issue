KAFKA_DIR=/somewhere/kafka_2.12-2.6.0
MY_JAAS_CONF=/adir/jaas.conf

export KAFKA_OPTS="-Djava.security.auth.login.config=${MY_JAAS_CONF}"
${KAFKA_DIR}/bin/kafka-consumer-groups.sh  --bootstrap-server xxxxxxxxxxx:9093 --command-config client_common.properties --all-groups --all-topics --describe