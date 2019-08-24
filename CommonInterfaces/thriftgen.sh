THRIFTBIN=./thrift
$THRIFTBIN --gen java -r backendmonitor.thrift
$THRIFTBIN --gen java -r   bskv.thrift  
$THRIFTBIN --gen java -r distributed.thrift  
$THRIFTBIN --gen java -r kv.thrift  
$THRIFTBIN --gen java -r monitor.thrift  
$THRIFTBIN --gen java -r openbase.thrift