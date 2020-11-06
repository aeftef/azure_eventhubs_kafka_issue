import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.streaming.DataStreamReader;

object TestEventHubs {

  def main(args: Array[String]): Unit = {

    val servers: String = args(0);
    val topic: String = args(1);
    val jaas_config: String = args(2);

    System.out.println("servers: " + servers);
    System.out.println("topic: " + topic);
    System.out.println("jaas_config: " + jaas_config);

    val spark: SparkSession = SparkSession
      .builder()
      .appName("Test")
      .getOrCreate();

    val df: DataFrame = spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", servers)
      .option("subscribe", topic)
      .option("startingOffsets", "earliest")
      .option("kafka.sasl.mechanism", "PLAIN")
      .option("kafka.security.protocol", "SASL_SSL")
      .option("kafka.sasl.jaas.config", jaas_config)
      .option("kafka.request.timeout.ms", "60000")
      .option("kafka.session.timeout.ms", "30000")
      //.option("kafka.group.id", "testing") Invalid configuration for spark 2.4...
      .option("failOnDataLoss", "true")
      
      .load();

    df.printSchema();

    val consoleOutput = df.writeStream
      .outputMode("append")
      .format("console")
      .start();

    consoleOutput.awaitTermination();

    return ;

  }

}