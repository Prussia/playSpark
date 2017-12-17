echo "start hadoop"
echo $HADOOP_HOME
bash $HADOOP_HOME/sbin/start-all.sh


echo "start spark"
echo $APACHE_SPARK_HOME
export SPARK_MASTER_WEBUI_PORT=8989
bash $APACHE_SPARK_HOME/sbin/start-all.sh 


