package edu.yu.oats.oatsdb.dbms;

/** The TxMgr interface defines the methods that allow the DBMS manage
 * transaction boundaries.
 *
 * Design note: API loosely modeled on javax.transaction APIs
 * https://docs.oracle.com/javaee/5/api/javax/transaction/package-summary.html
 * 
 * Design note: Only a vestige of the javax Transaction interface because don't
 * see a need for operations such as resource enlistment and synchronization
 * registration.
 *
 * @author Avraham Leff
 */

public interface Tx {
  
  /** Obtain the status of the transaction associated with the target
   * Transaction object.
   *
   * @return Appropriate TxStatus enum value.

   * @throws SystemException Thrown if the transaction manager encounters an
   * unexpected error condition.
   */
  TxStatus getStatus() throws SystemException;

  /** Obtain the "completion" status of the transaction.
   *
   * @returns The completed transaction status.  If the transaction has not yet
   * completed, returns the "ACTIVE" value.  Otherwise, even if the transaction
   * is no longer associated with the current (or any other) thread, returns
   * the appropriate "completion" value.  Will not throw an exception.
  */
  TxCompletionStatus getCompletionStatus();
}
