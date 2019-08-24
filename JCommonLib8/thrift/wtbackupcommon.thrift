include "wtcommon.thrift"

namespace cpp wtbackup
namespace java wtbackup
namespace php wtbackup


struct KVBackupData
{
    1: string key,
    2: string val,
}

service KVBackupService
{
    void put(1:KVBackupData data),
    void remove(1: string key),
}