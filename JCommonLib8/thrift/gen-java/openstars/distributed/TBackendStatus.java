/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package openstars.distributed;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-08-24")
public enum TBackendStatus implements org.apache.thrift.TEnum {
  EReady(1),
  EInActiveForAdding(2),
  EInActiveForRemoving(3),
  EReadyRemove(4);

  private final int value;

  private TBackendStatus(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static TBackendStatus findByValue(int value) { 
    switch (value) {
      case 1:
        return EReady;
      case 2:
        return EInActiveForAdding;
      case 3:
        return EInActiveForRemoving;
      case 4:
        return EReadyRemove;
      default:
        return null;
    }
  }
}
