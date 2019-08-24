namespace cpp wtcommon
namespace java wtcommon
namespace php wtcommon

typedef i32 TUID
typedef list<TUID> TListUIDS
typedef set<TUID> TSetUIDS

exception TInvalidOperation {
  1: i32 error,
  2: string message
}

exception TInvalidArgument {
  1: i32 error,
  2: string message
}

struct TVersion {
	1:required byte verMajor,
	2:required byte verMinor,
	3:required byte verBuild,
	4:required byte verRevision,
}

struct TBackupConfig {
	1:string dir,
	2:string preFileName,
	3:string sufFileName,
	4:i64 maxFileSize,
	5:i64 splitFileInterval,
}

enum  TBackupCommand {
	BKC_UNDEFINED = 0,
	BKC_PUT = 1,
	BKC_MULTIPUT = 2,
	BKC_REMOVE = 3,
	BKC_MULTIREMOVE = 4,
}

struct TRestoreStatus {
	1:string curPath,
	2:i32 doneCount,
	3:i64 readSize,
	4:i64 totalSize,
	5:double progress,
	6:i32 error,
	7:string message,
	8:bool running,
}

struct TCMLRecovStatus {
	1:string curPath = "",
	2:i32 doneCount = 0,
	3:i32 failCount = 0,
	4:i64 readSize = 0,
	5:i64 totalSize = 0,
	6:double progress = 0.0,
	7:i64 timeElapsed = 0,
	8:i32 error = 0,
	9:string message = "",
	10:bool running = 0,
}

struct TBDBRecovStatus {
	1:string current = "",
	2:i32 doneCount = 0,
	3:i32 failCount = 0,
	4:i32 totalCount = 0,
	5:double progress = 0.0,
	6:i64 timeElapsed = 0,
	7:i32 error = 0,
	8:string message = "",
	9:bool running = 0,
}


struct TDataSyncStatus {
	1:TUID curID,
	2:i32 idDoneCount,
	3:i32 idHasDataCount,
	4:i32 idTotalCount,
	5:double progress,
	6:i32 error,
	7:string message,
	8:bool running,
}

enum THandlerTypesSet {
	HND_NONE = 0,
	HND_ALL = 1,
	HND_READ = 2,
	HND_WRITE = 3,
}

enum TOperationTypesSet {
	OPT_NONE = 0,
	OPT_ALL = 1,
	OPT_READ = 2,
	OPT_WRITE = 3,
	OPT_W_ADD = 4,
	OPT_W_REMOVE = 5,
}

enum TOperationPolicy {
    OPPOL_NONE = 0,
    OPPOL_INSERT = 1,
    OPPOL_UPDATE = 2,
    OPPOL_INS_OR_UPD = 3,
    OPPOL_ERA_AFTER_GET = 4,
}
                                        

struct TDumpingStatus
{
    1: bool isDumping,
    2: i64 totalItemCount,
    3: i64 completedCount,
}

struct TStorageStatus
{
    1: required string storageName,
    2:required i32 maxCacheItemCount, // general
    3:required i32 cacheItemCount, // general
    4:required i32 savingQueueSize, // general
    5:required list<string> readBEStorage,
    6:required list<string> writeBEStorage,
    7:required  TCMLRecovStatus recoveryStatus, // commitlog
    8: TBDBRecovStatus bdbRecoveryStatus,

    9: TDumpingStatus dumpingStatus,
    10: i32 secondCacheCount,


}

struct TServiceStatus
{
    1: required list<TStorageStatus> storageStatus,
    2:required i64 readCount,
    3:required i64 writeCount,

}
