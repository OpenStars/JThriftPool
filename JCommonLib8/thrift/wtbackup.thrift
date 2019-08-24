include "wtcommon.thrift"

namespace cpp wtbackup
namespace java wtbackup
namespace php wtbackup


struct KVBackupData
{
    1: required string key,
    2: required string value,
}

service KVBackupService
{
    void put(1:KVBackupData data),
    void remove(1: string key),
    i32  doneCount(), // recovery status
}